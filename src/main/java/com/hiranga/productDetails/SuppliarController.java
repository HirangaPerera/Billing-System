package com.hiranga.productDetails;

import java.net.URL;
import java.util.ResourceBundle;

import com.hiranga.BillingSystem.ProductTable;
import com.hiranga.BillingSystem.SupplierTable;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public class SuppliarController implements Initializable {
	public static SupplierTable st = null;
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		
	}
	public void saveSuppliarDetails(ActionEvent e) {
		st = new SupplierTable();
    	st.setSupplierID("CS01");
    	st.setSuppliarName("Harshan Walisinghe");
    	st.setContactNumber("0719624398");
    	st.setCompanyName("kashyapa");
    	st.setCompanyAddress("kashyapa.Org");
	}
	public void saveProductDetails(ActionEvent e) {
		ProductTable pt = new ProductTable();
    	pt.setProductId("CP03");
    	pt.setProduct("Watana");
    	pt.setAmount("10");
    	pt.setMeisure("kg");
    	pt.setOtherDetails("red dhal");
    	
	}

}
