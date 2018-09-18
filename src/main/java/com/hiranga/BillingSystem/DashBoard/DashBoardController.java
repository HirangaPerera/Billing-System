package com.hiranga.BillingSystem.DashBoard;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hiranga.BillingSystem.ProductTable;
import com.hiranga.BillingSystem.SupplierTable;

import hibernate.Configuaration.ConfigDeclaration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DashBoardController implements Initializable {
	 	@FXML
	    private TableColumn<ProductTable, String> clmnsellingprice;

	    @FXML
	    private TableColumn<ProductTable, String> clmnavailability;

	    @FXML
	    private TableColumn<ProductTable, String> clmncodeno;

	    @FXML
	    private TableColumn<ProductTable, String> clmnbuingprice;

	    @FXML
	    private TableView<ProductTable> clmndashboardtable;

	    @FXML
	    private TableColumn<ProductTable, String> clmnitem;
ObservableList<ProductTable> oblist =  FXCollections.observableArrayList(); 


	    ConfigDeclaration cd;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cd = new ConfigDeclaration();
		cd.con = new Configuration().configure().addAnnotatedClass(SupplierTable.class).addAnnotatedClass(ProductTable.class);
		cd.createSessionFactory();
		
	}
	
public void getIten(ActionEvent e) {
	cd.session = cd.sf.openSession();
	Transaction tr = cd.session.beginTransaction();
	Query q = cd.session.createQuery("From ProductTable");
	List<ProductTable> prdctlist = q.list();
	for(ProductTable pt : prdctlist){
		oblist.add(pt);
	}
	cd.session.getTransaction().commit();
	cd.session.close();
	clmncodeno.setCellValueFactory(new PropertyValueFactory<ProductTable,String>("ProductID"));
	clmnitem.setCellValueFactory(new PropertyValueFactory<ProductTable,String>("Product"));
	clmnavailability.setCellValueFactory(new PropertyValueFactory<ProductTable,String>("Amount"));
	clmnbuingprice.setCellValueFactory(new PropertyValueFactory<ProductTable,String>("Meisure"));
	clmnsellingprice.setCellValueFactory(new PropertyValueFactory<ProductTable,String>("OtherDetails"));
	clmndashboardtable.setItems(oblist);
}
}
