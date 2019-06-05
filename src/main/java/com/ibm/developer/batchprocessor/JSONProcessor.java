package com.ibm.developer.batchprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONProcessor implements ItemProcessor<FootballPlayRecord, FootballPlayRecord> {
	private static final Logger LOGGER = LoggerFactory.getLogger(JSONProcessor.class);
	ObjectMapper mapper = new ObjectMapper();

	@Override
	public FootballPlayRecord process(FootballPlayRecord item) throws Exception {
		String jsonString = mapper.writeValueAsString(item);

		LOGGER.info(jsonString);
		return item;
	}

}
