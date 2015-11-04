package org.neos.hibernate.dao;

import javax.persistence.EntityManager;

import org.neos.hibernate.domain.Customer;
import org.neos.hibernate.utils.JPAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Operations {
	private static final Logger log = LoggerFactory.getLogger(Operations.class);

	public Customer getByIdAddress(Customer customer) {
		Customer resultCustomer = new Customer();
		EntityManager em = null;
		try {

			em = JPAUtil.getEntityManager();
			log.info("SE OBTIENE CLIENTE ID... : " + customer.getCustomerId());
			em.getTransaction().begin();

			resultCustomer = em.find(Customer.class, customer.getCustomerId());

			em.getTransaction().commit();
			em.close();

		} catch (Exception e) {
			log.error("ERROR in get data Customer", e);
			em.getTransaction().rollback();
		} finally {
			JPAUtil.close();
		}

		return resultCustomer;
	}

}
