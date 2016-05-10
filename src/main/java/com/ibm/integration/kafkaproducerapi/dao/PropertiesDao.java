package com.ibm.integration.kafkaproducerapi.dao;

import java.util.Properties;

public interface PropertiesDao
{
	public Properties getKafkaProperties() throws Exception;
}
