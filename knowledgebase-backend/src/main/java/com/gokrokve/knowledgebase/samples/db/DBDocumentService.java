package com.gokrokve.knowledgebase.samples.db;

import java.util.Collection;

import org.hibernate.SessionFactory;

import com.gokrokve.knowledgebase.samples.backend.DocumentService;
import com.gokrokve.knowledgebase.samples.backend.data.Category;
import com.gokrokve.knowledgebase.samples.backend.data.DocumentEntry;

public class DBDocumentService implements DocumentService {
	private SessionFactory factory;
	public DBDocumentService(SessionFactory _factory){
		this.factory = _factory;
	}
	@Override
	public Collection<DocumentEntry> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProduct(DocumentEntry p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub

	}

	@Override
	public DocumentEntry getProductById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}


}
