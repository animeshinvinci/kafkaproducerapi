package com.ibm.integration.kafkaproducerapi.beans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ChannelMessage
{	
	public static String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	
	private SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

	//private ObjectId _id;
	private String uuid;
	private String title;
	private String message;
	private Long likes;
	private String threadId;
	private String author;
	private Date date;
	private ArrayList<String> tags;
	private String channel;
	
	public String getUuid()
	{
		return uuid;
	}
	public void setUuid(String uuid)
	{
		this.uuid = uuid;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	public Long getLikes()
	{
		return likes;
	}
	public void setLikes(Long likes)
	{
		this.likes = likes;
	}
	public String getThreadId()
	{
		return threadId;
	}
	public void setThreadId(String threadId)
	{
		this.threadId = threadId;
	}
	public ArrayList<String> getTags()
	{
		return tags;
	}
	public void setTags(ArrayList<String> tags)
	{
		this.tags = tags;
	}
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public String getChannel()
	{
		return channel;
	}
	public void setChannel(String channel)
	{
		this.channel = channel;
	}
	public String getDate()
	{
		return sdf.format(date);
	}
	public void setDate(String date)
	{
		try
		{
			this.date = sdf.parse(date);
		}
		catch (Exception e)
		{
			this.date = new Date();
		}
	}
}
