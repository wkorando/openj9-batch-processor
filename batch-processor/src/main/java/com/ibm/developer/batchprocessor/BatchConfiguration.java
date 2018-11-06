package com.ibm.developer.batchprocessor;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private FootballPlayRecordWriter writer;

	@Autowired
	private EntityManagerFactory emf;

	/*
	 * Either short or long, defaults to long
	 */
	@Value("${run-type:long}")
	private String runType;

	@Bean
	FlatFileItemReader<FootballPlay> reader() {
		FlatFileItemReader<FootballPlay> reader = new FlatFileItemReader<FootballPlay>();
		reader.setResource(new ClassPathResource(runType + "-run.csv"));
		reader.setLineMapper(new DefaultLineMapper<FootballPlay>() {
			{

				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { //
								"gameId", //
								"gameDate", //
								"quarter", //
								"minute", //
								"second", //
								"offenseTeam", //
								"defenseTeam", //
								"down", //
								"toGo", //
								"yardLine", //
								"seriesFirstDown", //
								"nextScore", //
								"description", //
								"teamWin", //
								"seasonYear", //
								"yards", //
								"formation", //
								"playType", //
								"isRush", //
								"isPass", //
								"isIncomplete", //
								"isTouchdown", //
								"passType", //
								"isSack", //
								"isChallenge", //
								"isChallengeReversed", //
								"challenger", //
								"isMeasurement", //
								"isInterception", //
								"isFumble", //
								"isPenalty", //
								"isTwoPointConversion", //
								"isTwoPointConversionSuccessful", //
								"rushDirection", //
								"yardLineFixed", //
								"yardLineDirection", //
								"isPenaltyAccepted", //
								"penaltyTeam", //
								"isNoPlay", //
								"penaltyType", //
								"penaltyYards" //
						});
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<FootballPlay>() {
					{
						setTargetType(FootballPlay.class);
					}
				});
			}
		});
		return reader;
	}

	JpaPagingItemReader<FootballPlayRecord> recordReader() {
		JpaPagingItemReader<FootballPlayRecord> reader = new JpaPagingItemReader<>();
		reader.setQueryString("Select p FROM FootballPlayRecord p");
		reader.setEntityManagerFactory(emf);
		reader.setPageSize(10);
		return reader;
	}
	
	@Bean
	Job importFootballPlayJob(Step step1, Step step2, Step step3, Step step4) {
		return jobBuilderFactory.get("importFootballPlayJob").incrementer(new RunIdIncrementer()).start(step1)
				.next(step2).next(step3).next(step4).build();
	}

	/*
	 * Pull items from CSV file, transform, hash, write to H2 DB.
	 */
	@Bean
	Step step1() {
		return stepBuilderFactory.get("step1").<FootballPlay, FootballPlayRecord>chunk(10).reader(reader())
				.processor(new FootballPlayProcessor()).writer(writer).build();
	}

	/*
	 * Check items if "big play", if true update record and print to console, write to database
	 */
	@Bean
	Step step2() {
		return stepBuilderFactory.get("step2").<FootballPlayRecord, FootballPlayRecord>chunk(10).reader(recordReader())
				.processor(new BigPlayProcessor()).writer(writer).build();
	}

	/*
	 * Perform series of regexes and checks to see if play by Mahomes and the outcome of play,, update record, print message, write record to DB
	 */
	@Bean
	Step step3() {
		return stepBuilderFactory.get("step3").<FootballPlayRecord, FootballPlayRecord>chunk(10).reader(recordReader())
				.processor(new MahomiesProcessor()).writer(writer).build();
	}

	/*
	 * Serialize to JSON and print message to console
	 */
	@Bean
	Step step4() {
		return stepBuilderFactory.get("step4").<FootballPlayRecord, FootballPlayRecord>chunk(10).reader(recordReader())
				.processor(new JSONProcessor()).writer(writer).build();
	}
}
