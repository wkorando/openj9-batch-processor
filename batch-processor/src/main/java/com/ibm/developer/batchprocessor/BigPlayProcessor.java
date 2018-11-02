package com.ibm.developer.batchprocessor;

import org.springframework.batch.item.ItemProcessor;

public class BigPlayProcessor implements ItemProcessor<FootballPlayRecord, FootballPlayRecord> {

	@Override
	public FootballPlayRecord process(FootballPlayRecord item) throws Exception {
		item.setBigPlay(item.getYards() >= 20);
		if (item.isBigPlay()) {
			System.out.println("***BIG PLAY ALERT: " + item.getDescription() + " ***");
		}

		return item;
	}

}
