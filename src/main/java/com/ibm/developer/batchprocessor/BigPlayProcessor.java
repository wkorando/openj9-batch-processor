package com.ibm.developer.batchprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class BigPlayProcessor implements ItemProcessor<FootballPlayRecord, FootballPlayRecord> {
	private static final Logger LOGGER = LoggerFactory.getLogger(BigPlayProcessor.class);
	@Override
	public FootballPlayRecord process(FootballPlayRecord item) throws Exception {
		item.setBigPlay(item.getYards() >= 20);
		if (item.isBigPlay()) {
			LOGGER.info("***BIG PLAY ALERT: " + item.getDescription() + " ***");
		}

		return item;
	}

}
