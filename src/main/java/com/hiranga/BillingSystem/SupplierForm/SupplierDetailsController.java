package com.hiranga.BillingSystem.SupplierForm;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import com.jfoenix.controls.JFXTextField;

import hibernate.Configuaration.ConfigDeclaration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SupplierDetailsController implements Initializable {
	@FXML
    private JFXTextField scontact;

    @FXML
    private JFXTextField scompany;

    @FXML
    private JFXTextField pmeisure;

    @FXML
    private JFXTextField sname;

    @FXML
    private JFXTextField pid;

    @FXML
    private JFXTextField pamount;

    @FXML
    private JFXTextField potherdetails;

    @FXML
    private JFXTextField pproduct;

    @FXML
    private JFXTextField sid;

    @FXML
    private JFXTextField saddress;

    @FXML
    private TableColumn<SupplierTable, String> colsname;

    @FXML
    private TableColumn<SupplierTable, String> colsaddress;
    
    @FXML
    private TableColumn<SupplierTable, String> colscontact;
   
    @FXML
    private TableColumn<SupplierTable, String> colsid;
    
    @FXML
    private TableColumn<SupplierTable, String> colscompany;
    
    @FXML
    private TableView<SupplierTable> tablesup;
    
	  ObservableList<SupplierTable> suplist = FXCollections.observableArrayList();	
	  
	  ConfigDeclaration conf;
	  public SupplierDetailsController(){
	  conf = new ConfigDeclaration();
	  conf.con = new Configuration().configure().addAnnotatedClass(SupplierTable.class).addAnnotatedClass(ProductTable.class);
	  conf.createSessionFactory();
	  }
	  
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
	
	}
public void saveDetails(ActionEvent e) {
	//Supplier
	String supid  = sid.getText();
	String supcon = scontact.getText();
	String supcom = scompany.getText();
	String supname = sname.getText();
	String supaddress = saddress.getText();
	
	//Product
	String prodid = pid.getText();
	String prodmeisure = pmeisure.getText();
	String prodproduct = pproduct.getText();
	String prodother = potherdetails.getText();
	String prodamount = pamount.getText();
	
	conf.session = conf.sf.openSession();
    Transaction tr =  conf.session.beginTransaction();
    
   
	ProductTable pt = new ProductTable();
	pt.setProductId(prodid);
	pt.setProduct(prodproduct);
	pt.setAmount(prodamount);
	pt.setMeisure(prodmeisure);
	pt.setOtherDetails(prodother);
	 
	SupplierTable st = new SupplierTable();
		st.setSupplierID(supid);
		st.setSuppliarName(supname);
		st.setContactNumber(supcon);
		st.setCompanyName(supcom);
		st.setCompanyAddress(supaddress);
		pt.setSuppliartable(st);
	conf.session.save(st);
	conf.session.save(pt);
	tr.commit();
	conf.session.close();
}
public void showTable(ActionEvent e) {

	conf.session = conf.sf.openSession();
    Transaction tr =  conf.session.beginTransaction();

	 Query q =conf.session.createQuery("from SupplierTable");
     List<SupplierTable> st = q.list();
     for(SupplierTable sp : st)
     {
    	 	suplist.add(sp);
     }
     conf.session.getTransaction().commit();
	conf.session.close();
	colsid.setCellValueFactory(new PropertyValueFactory<SupplierTable,String>("SupplierID"));
	colsname.setCellValueFactory(new PropertyValueFactory<SupplierTable,String>("SupplierName"));
	colscompany.setCellValueFactory(new PropertyValueFactory<SupplierTable,String>("CompanyName"));
	colsaddress.setCellValueFactory(new PropertyValueFactory<SupplierTable,String>("CompanyAddress"));
	colscontact.setCellValueFactory(new PropertyValueFactory<SupplierTable,String>("ContactNumber"));
	tablesup.setItems(suplist);
	
}
}
