package com.ibm.developer.batchprocessor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class TestBigPlayProcessor {

	@Test
	public void testBigPlayProcessor() throws Exception {
		BigPlayProcessor processor = new BigPlayProcessor();
		FootballPlayRecord record = new FootballPlayRecord();
		record.setYards((short) 40);
		record.setDescription("A PLAY");
		processor.process(record);

		ILoggingEvent event = StaticAppender.getEvents().get(0);
		assertEquals(Level.INFO, event.getLevel());
		assertEquals("***BIG PLAY ALERT: A PLAY ***", event.getMessage());
	}
}
