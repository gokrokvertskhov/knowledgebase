package com.gokrokve.knowledgebase.samples.backend;

import java.util.Collection;

import com.gokrokve.knowledgebase.samples.backend.data.Category;
import com.gokrokve.knowledgebase.samples.backend.data.DocumentEntry;
import com.gokrokve.knowledgebase.samples.backend.mock.MockDataService;
import com.gokrokve.knowledgebase.samples.db.DBDocumentService;

public interface DocumentService {
    public abstract Collection<DocumentEntry> getAllProducts();

    public abstract Collection<Category> getAllCategories();

    public abstract void updateProduct(DocumentEntry p);

    public abstract void deleteProduct(int productId);

    public abstract DocumentEntry getProductById(int productId);

}
