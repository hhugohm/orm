package org.neos.hibernate.test;


import org.neos.hibernate.dao.CustomerDao;
import org.neos.hibernate.dao.CustomerDaoImpl;
import org.neos.hibernate.domain.Address;
import org.neos.hibernate.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSelectAddress {

	private static CustomerDao customerConsulta;
	private static final Logger log = LoggerFactory.getLogger(TestSaveAddress.class);
	public static void main(String args[]) {	
	
		
		
		/////////////////////////////////////////////////
		
		customerConsulta =new CustomerDaoImpl();
		Customer  customer = new Customer();
		Address direccion= null;
		
		customer.setCustomerId(1);
		
		
		customer = customerConsulta.getByIdAddress(customer);
		
		
		direccion = customer.getAddress();
		log.info("DIRECCION ACTUAL " +direccion.getAddress() );
		
		

		
		
		
	} 
}

