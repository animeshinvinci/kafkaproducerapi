package com.ibm.integration.kafkaproducerapi.beans;

public class APIRequest
{
	private RequestingUserCredentials requester;
	private User subject;
	private ChannelMessage message;
	
	public User getSubject()
	{
		return subject;
	}
	
	public void setSubject(User subject)
	{
		this.subject = subject;
	}

	public ChannelMessage getMessage()
	{
		return message;
	}

	public void setMessage(ChannelMessage message)
	{
		this.message = message;
	}

	public RequestingUserCredentials getRequester()
	{
		return requester;
	}

	public void setRequester(RequestingUserCredentials requester)
	{
		this.requester = requester;
	}
	

}
