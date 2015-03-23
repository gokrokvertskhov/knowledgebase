package com.gokrokve.knowledgebase.samples.backend;

import org.elasticsearch.action.index.IndexResponse;

import com.gokrokve.knowledgebase.samples.backend.data.Document;

public interface DocumentServiceElastic {
	public String indexName = "documents";
	public String docType = "book";
	public String mapping = "{\"book\" : { \"properties\" : {"
			+ " \"file\" :  {\"type\" : \"attachment\"}"
			+ "}"
			+ "}"
			+ "}";
	public IndexResponse put( Document doc);

}
