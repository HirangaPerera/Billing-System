package com.hiranga.BillingSystem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;




public class App 
{
    public static void main( String[] args )
    {
   
    	SupplierTable obj = new SupplierTable();
    	obj.setSupplierID("CP03");
    	obj.setSuppliarName("Malith Girandurukotte");
    	obj.setContactNumber("0719628436");
    	obj.setCompanyName("dragon");
    	obj.setCompanyAddress("dragon.Org");
    	Configuration con = new Configuration().configure().addAnnotatedClass(SupplierTable.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session ssn = sf.openSession();
        Transaction tr =  ssn.beginTransaction();
        ssn.save(obj);
        tr.commit(); 
    }
}
