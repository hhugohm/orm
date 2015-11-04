package org.neos.hibernate.test;

import org.neos.hibernate.dao.CustomerDao;
import org.neos.hibernate.dao.CustomerDaoImpl;
import org.neos.hibernate.domain.Address;
import org.neos.hibernate.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestUpdateCustomer {
	private static CustomerDao customerConsulta;
	private static CustomerDao customerModificacion;
	
	private static final Logger log = 
			LoggerFactory.getLogger(TestUpdateCustomer.class);
	public static void main(String args[]) {
		
		customerConsulta =new CustomerDaoImpl();
		customerModificacion =new CustomerDaoImpl();
		
		
		Customer  customer = new Customer();
		Address address= null;
		
		customer.setCustomerId(4);
		
		
		customer = customerConsulta.getByIdAddress(customer);
		
		
		address = customer.getAddress();
		log.info("DIRECCION ACTUAL " +address.getAddress() );
		address.setAddress("MI NUEVA DIRECCION");
		//address.setIdAddress(9);
		
		customer.setLastName("HIDALGO UPDATE2");
		customer.setAddress(address);
		
		customerModificacion.updateCustomer(customer);
		
		log.info("APELLIDO : " + customer.getLastName());
		
	} 
}
