package com.ramosvji.app.restcontroller.dto;

import java.io.Serializable;

public class GameDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String title;
	private String subtitle;
	private String year;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSubtitle() {
		return subtitle;
	}
	
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
}
