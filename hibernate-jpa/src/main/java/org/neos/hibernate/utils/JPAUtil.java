package org.neos.hibernate.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class JPAUtil {
	private static final Logger log = LoggerFactory.getLogger(JPAUtil.class);

	private static EntityManagerFactory entityManagerFactory = null;

	private static InheritableThreadLocal<EntityManager> entityManagerThreadLocal = new InheritableThreadLocal<EntityManager>();

	static {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("learn_persistence");
		} catch (Throwable ex) {
			
			log.error("Initial EntityManagerFactory creation failed.",ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	/**
	 * Get the configured entityManagerFactory
	 * 
	 * @return entityManagerFactory
	 */
	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	/**
	 * Get entity manager from thread
	 * 
	 * @return entity manager
	 */
	public static EntityManager getEntityManager() {
		if (entityManagerThreadLocal.get() == null || entityManagerThreadLocal.get().isOpen() == false) {
			entityManagerThreadLocal.set(entityManagerFactory
					.createEntityManager());
		}
		return entityManagerThreadLocal.get();
	}
	
	public static void close(){
		entityManagerFactory.close();
	}
}