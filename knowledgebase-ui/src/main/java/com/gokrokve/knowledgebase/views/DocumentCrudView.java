package com.gokrokve.knowledgebase.views;


import com.gokrokve.knowledgebase.samples.ResetButtonForTextField;
import com.gokrokve.knowledgebase.samples.backend.DataService;
import com.gokrokve.knowledgebase.samples.backend.data.Document;
import com.gokrokve.knowledgebase.samples.backend.data.Category;
import com.vaadin.event.FieldEvents;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class DocumentCrudView extends CssLayout implements View {
	public static final String VIEW_NAME = "Documents";
	private DocumentGrid grid;
	private DocumentForm form;
	private Button newProduct;
	/**
	 * 
	 */
	private static final long serialVersionUID = -5641196972885103584L;

	public DocumentCrudView(){
		 setSizeFull();
	        addStyleName("crud-view");
	        HorizontalLayout topLayout = createTopBar();

	       // grid = new ProductGrid();
//	        grid.addSelectionListener(new SelectionListener() {
//
//	            @Override
//	            public void select(SelectionEvent event) {
//	                viewLogic.rowSelected(grid.getSelectedRow());
//	            }
//	        });

	        form = new DocumentForm();
	        //form.setCategories(DataService.get().getAllCategories());

	        VerticalLayout barAndGridLayout = new VerticalLayout();
	        barAndGridLayout.addComponent(topLayout);
	       // barAndGridLayout.addComponent(grid);
	        barAndGridLayout.setMargin(true);
	        barAndGridLayout.setSpacing(true);
	        barAndGridLayout.setSizeFull();
	        //barAndGridLayout.setExpandRatio(grid, 1);
	        barAndGridLayout.setStyleName("crud-main-layout");

	        addComponent(barAndGridLayout);
	        addComponent(form);

	}
	   public HorizontalLayout createTopBar() {
	        TextField filter = new TextField();
	        filter.setStyleName("filter-textfield");
	        filter.setInputPrompt("Filter");
	        ResetButtonForTextField.extend(filter);
	        filter.setImmediate(true);
	        filter.addTextChangeListener(new FieldEvents.TextChangeListener() {
	            @Override
	            public void textChange(FieldEvents.TextChangeEvent event) {
	                grid.setFilter(event.getText());
	            }
	        });

	        newProduct = new Button("New product");
	        newProduct.addStyleName(ValoTheme.BUTTON_PRIMARY);
	        newProduct.setIcon(FontAwesome.PLUS_CIRCLE);
	        newProduct.addClickListener(new ClickListener() {
	            @Override
	            public void buttonClick(ClickEvent event) {
	            	//TODO: Add view logic here
	               Document doc = new Document();
	               editProduct(doc);
	            }
	        });

	        HorizontalLayout topLayout = new HorizontalLayout();
	        topLayout.setSpacing(true);
	        topLayout.setWidth("100%");
	        topLayout.addComponent(filter);
	        topLayout.addComponent(newProduct);
	        topLayout.setComponentAlignment(filter, Alignment.MIDDLE_LEFT);
	        topLayout.setExpandRatio(filter, 1);
	        topLayout.setStyleName("top-bar");
	        return topLayout;
	    }


	    @Override
	    public void enter(ViewChangeEvent event) {
	        //viewLogic.enter(event.getParameters());
	    }

	    public void showError(String msg) {
	        Notification.show(msg, Type.ERROR_MESSAGE);
	    }

	    public void showSaveNotification(String msg) {
	        Notification.show(msg, Type.TRAY_NOTIFICATION);
	    }

	    public void setNewProductEnabled(boolean enabled) {
	        newProduct.setEnabled(enabled);
	    }

	    public void clearSelection() {
	        //grid.getSelectionModel().reset();
	    }

	    public void selectRow(Document row) {
	       // ((SelectionModel.Single) grid.getSelectionModel()).select(row);
	    }

	    public Document getSelectedRow() {
	       // return grid.getSelectedRow();
	    }

	    public void editProduct(Document product) {
	        if (product != null) {
	            form.addStyleName("visible");
	            form.setEnabled(true);
	        } else {
	            form.removeStyleName("visible");
	            form.setEnabled(false);
	        }
	        form.editProduct(product);
	    }



}
