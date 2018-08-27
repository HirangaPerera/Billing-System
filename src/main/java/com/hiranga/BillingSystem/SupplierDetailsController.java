package com.hiranga.BillingSystem;

import java.net.URL;
import java.util.ResourceBundle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

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
}
}
