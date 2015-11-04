package org.neos.hibernate.utils;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaSessionEntitymanager {
	
	private static EntityManagerFactory emFactory= Persistence.createEntityManagerFactory("learn_persistence");
	
	public static EntityManager getEntityManager(){
		
		return emFactory.createEntityManager();
	}
	
	public static void close(){
		emFactory.close();
	}

}
