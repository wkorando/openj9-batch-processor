package com.ibm.developer.batchprocessor;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Service;

@Service
public class FootballPlayRecordReader implements ItemWriter<FootballPlayRecord> {

	private FootballPlayRecordRepo repo;

	public FootballPlayRecordReader(FootballPlayRecordRepo repo) {
		this.repo = repo;
	}

	@Override
	public void write(List<? extends FootballPlayRecord> items) throws Exception {
		repo.saveAll(items);
	}

}
