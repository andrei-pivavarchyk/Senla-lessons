package com.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Factory {
    private static final SessionFactory sessionFactory = configureSessionFactory();
    private static ServiceRegistry serviceRegistry;
    private static Logger log = Logger.getLogger(Factory.class);

    private static SessionFactory configureSessionFactory()
            throws HibernateException {

        try {
            Configuration configuration = new Configuration().configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).buildServiceRegistry();
            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            log.error(e.toString());
            return null;
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
