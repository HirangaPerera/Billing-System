package com.hiranga.BillingSystem;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class FetchData {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(SupplierTable.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session ssn = sf.openSession();
        ssn.beginTransaction();
       
        Query q =ssn.createQuery("from SupplierTable");
        List<SupplierTable> st = q.list();
        for(SupplierTable sp : st)
        {
        	System.out.println(sp.toString());
        }
        ssn.getTransaction().commit();
        
       
	}

}
