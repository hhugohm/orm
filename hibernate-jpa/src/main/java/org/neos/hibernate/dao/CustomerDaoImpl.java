package org.neos.hibernate.dao;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.neos.hibernate.domain.Customer;
import org.neos.hibernate.test.TestSelectCustomer;
import org.neos.hibernate.utils.JPAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerDaoImpl  implements CustomerDao {

	private static final Logger log =  LoggerFactory.getLogger(TestSelectCustomer.class);
	@Override
	public void persist(Customer customer) {
		EntityManager em = null;
		try {

			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();

			em.persist(customer);

			em.getTransaction().commit();
			em.close();

		} catch (Exception e) {
			log.error("ERROR in persist a customer", e);
			em.getTransaction().rollback();
		}
		
	}

	@Override
	public void update(Customer customer) {
		EntityManager em = null;
		try {

			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			customer = em.merge(customer);
			em.merge(customer);

			em.getTransaction().commit();
			em.close();

		} catch (Exception e) {
			log.error("ERROR in update a customer", e);
			em.getTransaction().rollback();
		} 
		
	}

	@Override
	public void remove(Customer customer) {
		EntityManager em = null;
		try {

			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			customer = em.merge(customer);
			em.remove(customer);

			em.getTransaction().commit();
			em.close();

		} catch (Exception e) {
			log.error("ERROR in remove a customer", e);
			em.getTransaction().rollback();
		} 
		
	}

	@Override
	public Customer find(Serializable id) {
		Customer resultCustomer = new Customer();
		EntityManager em = null;
		try {

			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();

			resultCustomer = em.find(Customer.class, id);

			em.getTransaction().commit();
			em.close();

		} catch (Exception e) {
			log.error("ERROR in get data Customer", e);
			em.getTransaction().rollback();
		} 

		return resultCustomer;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAll() {
		List<Customer> ltsCustomer = new ArrayList<Customer>();
		EntityManager em = null;
		try {

			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();

			String query = "select o from " + Customer.class.getName() + " o";
		    Query q= em.createQuery(query, Customer.class);
		    ltsCustomer = q.getResultList();
			em.getTransaction().commit();
			em.close();

		} catch (Exception e) {
			log.error("ERROR in get data Customer", e);
			em.getTransaction().rollback();
		} 
		return  ltsCustomer;
	       
	}

	
}
