package com.gokrokve.knowledgebase.samples.backend.data;
import java.io.Serializable;
import com.gokrokve.knowledgebase.samples.backend.data.Attachment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Document implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8484374264948260604L;
	@JsonProperty("id")
	private int id=-1;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("date")
	private String date;
	
	@JsonProperty("author")
	private String author;
	
	@JsonProperty("keywords")
	private String keywords;
	
	@JsonProperty("content_type")
	private String content_type;
	
	@JsonProperty("content_length")
	private String content_length;
	
	@JsonProperty("language")
	private String language;

//	@JsonProperty("file")
//	private Attachment file;

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
}
