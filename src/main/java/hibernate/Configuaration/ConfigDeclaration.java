package hibernate.Configuaration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ConfigDeclaration {
public Configuration con = null;
public Session session = null;
public SessionFactory  sf= null;
public ServiceRegistry reg = null;
public void createSessionFactory() {
	   reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
	    sf = con.buildSessionFactory(reg);
}
}
