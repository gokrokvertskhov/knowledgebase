package com.gokrokve.knowledgebase.views;

import java.util.Collection;

import com.gokrokve.knowledgebase.samples.backend.DataService;
import com.gokrokve.knowledgebase.samples.backend.data.Category;
import com.gokrokve.knowledgebase.samples.backend.data.Document;
import com.gokrokve.knowledgebase.samples.backend.data.Product;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitEvent;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.fieldgroup.FieldGroup.CommitHandler;
import com.vaadin.server.Page;
import com.vaadin.ui.Field;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification.Type;
import com.vaadin.data.util.BeanItem;

public class DocumentForm extends DocumentFormDesign {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2259254832802204981L;
	private BeanFieldGroup<Document> fieldGroup;
	
	public DocumentForm(){
		 super();
	     addStyleName("product-form");
	     fieldGroup = new BeanFieldGroup<Document>(Document.class);
	     fieldGroup.bindMemberFields(this);
	     // perform validation and enable/disable buttons while editing
	        ValueChangeListener valueListener = new ValueChangeListener() {
	            @Override
	            public void valueChange(ValueChangeEvent event) {
	                formHasChanged();
	            }
	        };
	        for (Field f : fieldGroup.getFields()) {
	            f.addValueChangeListener(valueListener);
	        }

	        fieldGroup.addCommitHandler(new CommitHandler() {

	            @Override
	            public void preCommit(CommitEvent commitEvent)
	                    throws CommitException {
	            }

	            @Override
	            public void postCommit(CommitEvent commitEvent)
	                    throws CommitException {
	                //DataService.get().updateProduct(
	                //        fieldGroup.getItemDataSource().getBean());
	            }
	        });
	        save.addClickListener(new ClickListener() {
	            @Override
	            public void buttonClick(ClickEvent event) {
	                try {
	                    fieldGroup.commit();

	                    // only if validation succeeds
	                    Document product = fieldGroup.getItemDataSource().getBean();
	                    //viewLogic.saveProduct(product);
	                } catch (CommitException e) {
	                    Notification n = new Notification(
	                            "Please re-check the fields", Type.ERROR_MESSAGE);
	                    n.setDelayMsec(500);
	                    n.show(getUI().getPage());
	                }
	            }
	        });

	        cancel.addClickListener(new ClickListener() {
	            @Override
	            public void buttonClick(ClickEvent event) {
	               // viewLogic.cancelProduct();
	            }
	        });

	        delete.addClickListener(new ClickListener() {
	            @Override
	            public void buttonClick(ClickEvent event) {
	                Document product = fieldGroup.getItemDataSource().getBean();
	               // viewLogic.deleteProduct(product);
	            }
	        });
	}
	
	   public void setCategories(Collection<Category> categories) {
	        //category.setOptions(categories);
	    }
	   
	    public void editProduct(Document product) {
	        if (product == null) {
	            product = new Document();
	        }
	        fieldGroup.setItemDataSource(new BeanItem<Document>(product));

	        // before the user makes any changes, disable validation error indicator
	        // of the product name field (which may be empty)
	        title.setValidationVisible(false);

	        // Scroll to the top
	        // As this is not a Panel, using JavaScript
	        String scrollScript = "window.document.getElementById('" + getId()
	                + "').scrollTop = 0;";
	        Page.getCurrent().getJavaScript().execute(scrollScript);
	    }

	    private void formHasChanged() {
	        // show validation errors after the user has changed something
	        title.setValidationVisible(true);

	        // only products that have been saved should be removable
	        boolean canRemoveProduct = false;
	        BeanItem<Document> item = fieldGroup.getItemDataSource();
	        if (item != null) {
	            Document product = item.getBean();
	            canRemoveProduct = product.getId() != -1;
	        }
	        delete.setEnabled(canRemoveProduct);
	    }


}
