package com.hiranga.BillingSystem;

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
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	
	}
public void saveDetails(ActionEvent e) {
	String supid  = sid.getText();
	
	Configuration con = new Configuration().configure().addAnnotatedClass(SupplierTable.class).addAnnotatedClass(ProductTable.class);
    ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    SessionFactory sf = con.buildSessionFactory(reg);
    Session ssn = sf.openSession();
    Transaction tr =  ssn.beginTransaction();
    
    SupplierTable st = new SupplierTable();
	st.setSupplierID(supid);
	st.setSuppliarName("Dulanjana Walisinghe");
	st.setContactNumber("0719624398");
	st.setCompanyName("kashyapa");
	st.setCompanyAddress("kashyapa.Org");
    ssn.save(st);
	tr.commit();
	ssn.close();
}
public void showTable(ActionEvent e) {
	//SupplierTable stt = new SupplierTable();
	Configuration con = new Configuration().configure().addAnnotatedClass(SupplierTable.class).addAnnotatedClass(ProductTable.class);
    ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    SessionFactory sf = con.buildSessionFactory(reg);
    Session ssn = sf.openSession();
    Transaction tr =  ssn.beginTransaction();
	//stt = null;
	 Query q =ssn.createQuery("from SupplierTable");
     List<SupplierTable> st = q.list();
     for(SupplierTable sp : st)
     {
   suplist.add(sp);
     }
     ssn.getTransaction().commit();
	
	colsid.setCellValueFactory(new PropertyValueFactory<SupplierTable,String>("SupplierID"));
	colsname.setCellValueFactory(new PropertyValueFactory<SupplierTable,String>("SupplierName"));
	colscompany.setCellValueFactory(new PropertyValueFactory<SupplierTable,String>("CompanyName"));
	colsaddress.setCellValueFactory(new PropertyValueFactory<SupplierTable,String>("CompanyAddress"));
	colscontact.setCellValueFactory(new PropertyValueFactory<SupplierTable,String>("ContactNumber"));
	tablesup.setItems(suplist);
	
}
}
