package com.sample.cxf.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class JsonResponse {

	private String name;
	
	private Date date;
	
	public JsonResponse(String name) {
		setName(name);
		setDate(new Date());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}