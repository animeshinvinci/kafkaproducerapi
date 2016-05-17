package com.ibm.integration.kafkaproducerapi.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.integration.kafkaproducerapi.beans.APIResponse;
import com.ibm.integration.kafkaproducerapi.beans.ChannelMessage;
import com.ibm.integration.kafkaproducerapi.dao.KafkaMessageProducer;

@RestController
@RequestMapping
public class KafkaProducerController extends APIController
{
	private static final Logger logger = LogManager.getLogger(KafkaProducerController.class);

	@Autowired
	private KafkaMessageProducer kafkaProducer;
	
	@Value("${version}")
	private String version;
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{topic}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<APIResponse> createMessage(
			@PathVariable("topic") String topic,
			@RequestBody(required = true) ChannelMessage message)
	{
		APIResponse result = null;
		ResponseEntity<APIResponse> response;
		try
		{
			ObjectMapper om = new ObjectMapper();
			String payload = om.writeValueAsString(message);
			logger.info("Received request to publish Kafka Message: " + payload);
			kafkaProducer.publishMessage(topic, message.getUuid(), payload);
			result = new APIResponse();
			result.setStatus(APIResponse.STATUS_SUCCESS);
			result.setResponse(payload);
			result.setVersion(version);
			response = ResponseEntity.ok(result);
		}
		catch (Exception e)
		{
			response = handleException(e, version);
		}
		return response;
	}


}
