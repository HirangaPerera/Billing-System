package com.hiranga.BillingSystem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.hiranga.productDetails.ProductTable;




public class App 
{
    public static void main( String[] args )
    {
   try {
    	
    	Configuration con = new Configuration().configure().addAnnotatedClass(SupplierTable.class).addAnnotatedClass(ProductTable.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session ssn = sf.openSession();
        Transaction tr =  ssn.beginTransaction();
        
        SupplierTable st = new SupplierTable();
    	st.setSupplierID("CS05");
    	st.setSuppliarName("Harshan Walisinghe");
    	st.setContactNumber("0719624398");
    	st.setCompanyName("kashyapa");
    	st.setCompanyAddress("kashyapa.Org");
    	
    	ProductTable pt = new ProductTable();
    	pt.setProductId("CP05");
    	pt.setProduct("Watana");
    	pt.setAmount("10");
    	pt.setMeisure("kg");
    	pt.setOtherDetails("red dhal");
    	pt.getSuppliertable().add(st);
    	
    	ProductTable ptone = new ProductTable();
    	ptone.setProductId("CP06");
    	ptone.setProduct("Watana");
    	ptone.setAmount("10");
    	ptone.setMeisure("kg");
    	ptone.setOtherDetails("red dhal");
    	ptone.getSuppliertable().add(st);
        ssn.save(st);
        ssn.save(pt);
        ssn.save(ptone);
       
        tr.commit(); 
    	} catch(Exception e) {
    		 e.printStackTrace();
    	      // tr.rollback();
    	}
    }
}
