package org.neos.hibernate.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.neos.hibernate.domain.Customer;
import org.neos.hibernate.utils.HibernateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerDaoImpl implements CustomerDao {
private Session session;
	
	private static final Logger log = 
								LoggerFactory.getLogger(AddressDaoImpl.class);
	@Override
	public void saveCustomer(Customer customer) {
		session = HibernateUtils.getSession();
		Transaction txt = session.beginTransaction();
		try {
			log.info("SE VA A GUARDAR UN CLIENTE..." + customer);

			session.save(customer);
			
			txt.commit();
			

		} catch (Exception e) {
			txt.rollback();
		} finally {
			HibernateUtils.closeSession();;
		}


	}
	@Override
	public Customer getByIdAddress(Customer customer) {
		session = HibernateUtils.getSession();
		Transaction txt = session.beginTransaction();
		Customer resultCustomer = new Customer();
		try {
			log.info("SE OBTIENE CLIENTE ID... : "+ customer.getCustomerId());

			resultCustomer= (Customer) session.load(Customer.class, customer.getCustomerId());
			txt.commit();
			
			Hibernate.initialize(resultCustomer);
			 
		} catch (Exception e) {
			e.printStackTrace();
			txt.rollback();
		} finally {
			HibernateUtils.closeSession();;
		}
		
		return resultCustomer;
	}
	@Override
	public void updateCustomer(Customer customer) {
		session = HibernateUtils.getSession();
		Transaction txt = session.beginTransaction();
		try {
			log.info("SE VA A MODIFICAR Customer..." + customer);

			session.update(customer);
			txt.commit();

		} catch (Exception e) {
			txt.rollback();
		} finally {
			HibernateUtils.closeSession();;
		}

		
	}
	@Override
	public void deleteCustomer(Customer customer) {
		session = HibernateUtils.getSession();
		Transaction txt = session.beginTransaction();
		try {
			log.info("SE VA A BORRAR CUSTOMER..." + customer);

			session.delete(customer);
			txt.commit();

		} catch (Exception e) {
			txt.rollback();
		} finally {
			HibernateUtils.closeSession();;
		}

	}

}
