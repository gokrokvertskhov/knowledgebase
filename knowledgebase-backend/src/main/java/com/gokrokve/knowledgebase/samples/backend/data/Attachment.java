package com.gokrokve.knowledgebase.samples.backend.data;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Attachment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2832954437188738863L;
	
	@JsonProperty("_content_type")
	private String content_type;
	
	@JsonProperty("_name")
	private String name;
	
	@JsonProperty("_language")
	private String language;
	
	@JsonProperty("_content")
	private String content;

	@JsonProperty("_indexed_chars")
	private Integer indexed_chars = -1;
}
