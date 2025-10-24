package config;

import entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() { // me method eke thamai hibernate bootstrap wenne.
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Customer.class);  // Adding class

        sessionFactory = configuration.buildSessionFactory(); // creating sessionFactory
    }

    public static FactoryConfiguration getInstance() {
        if (factoryConfiguration == null) {
            factoryConfiguration = new FactoryConfiguration();
        }
        return factoryConfiguration;
    }

    public Session getSessionFactory() {
        return sessionFactory.openSession();
    }
}
