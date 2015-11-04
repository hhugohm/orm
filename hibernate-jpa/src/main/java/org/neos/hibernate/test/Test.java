package org.neos.hibernate.test;

import org.neos.hibernate.dao.Operations;
import org.neos.hibernate.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
	private static final Logger log = 
			LoggerFactory.getLogger(Test.class);
	public static void main(String[] args) {
		Operations operations = new Operations();
		Customer  customer = new Customer();
		customer.setCustomerId(1);
		customer= operations.getByIdAddress(customer);
		//Address direccion= null;
		//direccion = customer.getAddress();
		log.info(customer.toString());

	}

}
