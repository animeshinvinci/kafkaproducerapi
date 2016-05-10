package com.ibm.integration.kafkaproducerapi.dao;

import java.util.Calendar;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageProducer
{
	private static final Logger logger = LogManager.getLogger(KafkaMessageProducer.class);

	@Autowired
	private PropertiesDao propsDao;
	
	@Value("${producer.refresh.interval.ms}")
	private long reloadTime;
	
	private long lastLoadTime =0;

	private KafkaProducer<String, String> producer;
	
	private synchronized KafkaProducer<String, String> getProducer() throws Exception
	{
		long loadInterval = Calendar.getInstance().getTimeInMillis() - lastLoadTime;
		if (producer == null || lastLoadTime == 0 || loadInterval > reloadTime)
		{
			logger.info("Creating Kafka Producer... " + "Load Interval = " + loadInterval);
			producer = new KafkaProducer<>(propsDao.getKafkaProperties());
			lastLoadTime = Calendar.getInstance().getTimeInMillis();
		}
		return producer;
	}

	public void publishMessage(String topic, String key, String value) throws Exception
	{
		getProducer().send(new ProducerRecord<String, String>(topic, key, value));
	}
	
}