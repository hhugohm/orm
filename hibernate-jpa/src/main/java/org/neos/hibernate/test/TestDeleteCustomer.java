package org.neos.hibernate.test;

import org.neos.hibernate.dao.CustomerDao;
import org.neos.hibernate.dao.CustomerDaoImpl;
import org.neos.hibernate.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDeleteCustomer {
	private static CustomerDao customerConsulta;
	private static CustomerDao customerDelete;
	
	private static final Logger log = 
			LoggerFactory.getLogger(TestDeleteCustomer.class);
	public static void main(String args[]) {
		
		customerConsulta =new CustomerDaoImpl();
		customerDelete =new CustomerDaoImpl();
		
		
		Customer  customer = new Customer();

		
		customer.setCustomerId(5);
		
		
		customer = customerConsulta.getByIdAddress(customer);
		customerDelete.deleteCustomer(customer);
		
		log.info("::SE BORRO LA ENTIDAD:::");
	} 
}

