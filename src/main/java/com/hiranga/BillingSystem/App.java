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
   
    	SupplierTable st = new SupplierTable();
    	st.setSupplierID("CS03");
    	st.setSuppliarName("Harsha Walisinghe");
    	st.setContactNumber("0719628698");
    	st.setCompanyName("proling");
    	st.setCompanyAddress("prolink.Org");
    	
    	ProductTable pt = new ProductTable();
    	pt.setProductId("CP03");
    	pt.setProduct("Sugar");
    	pt.setAmount("10");
    	pt.setMeisure("kg");
    	pt.setOtherDetails("red Dhal");
    	pt.setSuppliertable(st);
    	Configuration con = new Configuration().configure().addAnnotatedClass(SupplierTable.class).addAnnotatedClass(ProductTable.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session ssn = sf.openSession();
        Transaction tr =  ssn.beginTransaction();
        
        ssn.save(st);
        ssn.save(pt);
        tr.commit(); 
    }
}
