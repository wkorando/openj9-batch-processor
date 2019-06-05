package com.ibm.developer.batchprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class MahomiesProcessor implements ItemProcessor<FootballPlayRecord, FootballPlayRecord> {
	private static final Logger LOGGER = LoggerFactory.getLogger(MahomiesProcessor.class);

	@Override
	public FootballPlayRecord process(FootballPlayRecord item) throws Exception {
		if (item.getDescription().contains("MAHOMES")) {
			if (item.getDescription().contains("TOUCHDOWN")) {
				if (item.isBigPlay()) {
					item.setMahomesFlair("An incredible play by Mahomes: 😍😍😍");
				} else {
					item.setMahomesFlair("A great play Mahomes: 🙌🙌🙌");
				}
			} else if (item.getDescription().contains("INTERCEPTION") || item.getDescription().contains("FUMBLE")) {
				item.setMahomesFlair("Oh no an interception: 😭😭😭");
			} else if (item.isBigPlay()) {
				item.setMahomesFlair("A big play by Mahomes: 🤩🤩🤩");
			} else {
				item.setMahomesFlair("Just normal Mahomes magic: 😄😄😄");
			}
			LOGGER.info(item.getMahomesFlair());
		}
		return item;
	}

}
