package com.ibm.integration.kafkaproducerapi.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;

import com.ibm.integration.kafkaproducerapi.beans.APIResponse;

public abstract class APIController
{
	private static final Logger logger = LogManager.getLogger(APIController.class);

	protected ResponseEntity<APIResponse> handleException(Throwable e, String version)
	{
		ResponseEntity<APIResponse> response;
		APIResponse result = null;

		logger.error(e.getMessage(), e);
		result = new APIResponse();
		result.setStatus(APIResponse.STATUS_ERROR);
		result.setErrMsg(e.getMessage());
		result.setVersion(version);
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		result.setErrDetails(sw.toString());
		result.setResponse(false);

		response = ResponseEntity.badRequest().body(result);
		return response;
	}

	protected ResponseEntity<APIResponse> handleException(Throwable e, String version,
			boolean badRequest)
	{
		ResponseEntity<APIResponse> response;
		APIResponse result = null;

		logger.error(e.getMessage(), e);
		result = new APIResponse();
		result.setStatus(APIResponse.STATUS_ERROR);
		result.setErrMsg(e.getMessage());
		result.setVersion(version);
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		result.setErrDetails(sw.toString());
		result.setResponse(false);

		response = (badRequest) ? ResponseEntity.badRequest().body(result)
				: ResponseEntity.ok().body(result);
		return response;
	}

}
