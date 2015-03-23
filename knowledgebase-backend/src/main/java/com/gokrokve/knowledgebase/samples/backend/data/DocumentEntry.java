package com.gokrokve.knowledgebase.samples.backend.data;

import java.io.Serializable;

public class DocumentEntry implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2476869969830265707L;
	public DocumentEntry() {}
	
	private int id;
    public int getId() {
	      return id;
	   }
	public void setId( int id ) {
	      this.id = id;
	   }
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getContent_type() {
		return content_type;
	}
	public void setContent_type(String content_type) {
		this.content_type = content_type;
	}
	public int getContent_length() {
		return content_length;
	}
	public void setContent_length(int content_length) {
		this.content_length = content_length;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String get_index() {
		return _index;
	}
	public void set_index(String _index) {
		this._index = _index;
	}
	public String get_type() {
		return _type;
	}
	public void set_type(String _type) {
		this._type = _type;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public long get_version() {
		return _version;
	}
	public void set_version(long _version) {
		this._version = _version;
	}
	private String title;
	private String date;
	private String author;
	private String keywords;
	private String content_type;
	private int content_length;
	private String language;
	private String _index;
	private String _type;
	private String _id;
	private long _version;

}
