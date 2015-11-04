package org.neos.hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateUtils {
	
	private static SessionFactory sessionFactory;
	private static final ThreadLocal<Session> session = new ThreadLocal<Session>();
	private static final Logger log = LoggerFactory
			.getLogger(HibernateUtils.class);
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            log.info("Hibernate Configuration loaded");
             
            //apply configuration property settings to StandardServiceRegistryBuilder
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            log.info("Hibernate serviceRegistry created");
             
            SessionFactory sessionFactory = configuration
                                .buildSessionFactory(serviceRegistry);
             
            return sessionFactory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
        	log.error("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
     
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
    
    public static Session getSession() {
    	Session s = (Session) session.get();
		if (s == null || !s.isOpen()) {
			if (sessionFactory == null) {
				sessionFactory=buildSessionFactory();
				//rebuildSessionFactory();
			}
			s = sessionFactory.openSession();
			session.set(s);
		} else {
			s = sessionFactory.openSession();
		}
		return s;
    }

    public static void closeSession() {
    	log.info("::::CERRANDO LA SESSION:::");
        if (sessionFactory != null) {
            sessionFactory.close();
            sessionFactory = null;
        }
    }
}
