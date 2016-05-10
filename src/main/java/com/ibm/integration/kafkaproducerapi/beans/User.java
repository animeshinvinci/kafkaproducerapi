/**
 * 
 */
package com.ibm.integration.kafkaproducerapi.beans;

import java.util.ArrayList;

/**
 * @author tambre
 *
 */
public class User
{
	private String email;
	private String phone;
	private String pwd;
	private String accessToken;

	private ArrayList<String> roles;
	private ArrayList<String> aoe;
	
	private String fname;
	private String lname;
	
	public String getFname()
	{
		return fname;
	}
	public void setFname(String fname)
	{
		this.fname = fname;
	}
	public String getLname()
	{
		return lname;
	}
	public void setLname(String lname)
	{
		this.lname = lname;
	}
	
	public String getPwd()
	{
		return pwd;
	}
	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}

	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public ArrayList<String> getRoles()
	{
		return roles;
	}
	public void setRoles(ArrayList<String> roles)
	{
		this.roles = roles;
	}
	public ArrayList<String> getAoe()
	{
		return aoe;
	}
	public void setAoe(ArrayList<String> aoe)
	{
		this.aoe = aoe;
	}
	public String getAccessToken()
	{
		return accessToken;
	}
	public void setAccessToken(String accessToken)
	{
		this.accessToken = accessToken;
	}
	
	
}
