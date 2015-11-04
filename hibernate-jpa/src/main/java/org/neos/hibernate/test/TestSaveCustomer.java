package org.neos.hibernate.test;

import org.neos.hibernate.dao.CustomerDao;
import org.neos.hibernate.dao.CustomerDaoImpl;
import org.neos.hibernate.domain.Address;
import org.neos.hibernate.domain.Customer;
import org.neos.hibernate.utils.JPAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSaveCustomer {
	private static final Logger log = LoggerFactory.getLogger(TestSaveCustomer.class);
	
	private static CustomerDao customerDao;
	
	public static void main(String[] args) {
		try {
		customerDao =new CustomerDaoImpl();
		Address  address = new Address();
		address.setAddress("DOMICILIO CONOCIDO2");
		address.setNumberInt(502);
		address.setPostalCode(52100);
		address.setComments("SIN DESCRIPCION2");
		
		Customer customer = new Customer();
		customer.setAddress(address);
		customer.setName("HUGO");
		customer.setLastName("HIDALGO MARTINEZ");
		customer.setPhone("N/A");
		customerDao.persist(customer);
		
		log.info(customer.toString());
		} catch (Exception e) {
			log.error("", e);
		} finally {
			JPAUtil.getEntityManagerFactory().close();
		}
	}

}
