package org.neos.hibernate.test;

import org.neos.hibernate.dao.AddressDao;
import org.neos.hibernate.dao.AddressDaoImpl;
import org.neos.hibernate.dao.CustomerDao;
import org.neos.hibernate.dao.CustomerDaoImpl;
import org.neos.hibernate.domain.Address;
import org.neos.hibernate.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSaveCustomer {

	private static CustomerDao customerDao;
	private static AddressDao addressDao;
	
	private static final Logger log = 
			LoggerFactory.getLogger(TestSaveAddress.class);
	public static void main(String[] args) {

		customerDao =new CustomerDaoImpl();
		addressDao = new AddressDaoImpl();
		Address  address = new Address();
		address.setAddress("DOMICILIO CONOCIDO");
		address.setNumberInt(502);
		address.setPostalCode(52100);
		address.setComments("SIN DESCRIPCION");
		
		addressDao.saveAddress(address);
		
	
		Customer customer = new Customer();
		customer.setAddress(address);
		customer.setName("JUDITH");
		customer.setLastName("HIDALGO COLIN");
		customer.setPhone("N/A");
		customerDao.saveCustomer(customer);
		
		log.info("Id Customer " + customer.getCustomerId());



	}

}
