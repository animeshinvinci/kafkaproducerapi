package com.ibm.integration.kafkaproducerapi.beans;

public class APIResponse
{
	public static final String STATUS_SUCCESS = "SUCCESS";
	public static final String STATUS_ERROR = "ERROR";

	private String status;
	private String errMsg;
	private Object errDetails;
	private Object response;
	private String version;

	public String getVersion()
	{
		return version;
	}

	public void setVersion(String version)
	{
		this.version = version;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getErrMsg()
	{
		return errMsg;
	}

	public void setErrMsg(String errMsg)
	{
		this.errMsg = errMsg;
	}

	public Object getErrDetails()
	{
		return errDetails;
	}

	public void setErrDetails(Object errDetails)
	{
		this.errDetails = errDetails;
	}

	public Object getResponse()
	{
		return response;
	}

	public void setResponse(Object response)
	{
		this.response = response;
	}
}
