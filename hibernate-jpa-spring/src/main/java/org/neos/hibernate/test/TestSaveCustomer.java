package org.neos.hibernate.test;

import org.neos.hibernate.dao.CustomerDao;
import org.neos.hibernate.domain.Address;
import org.neos.hibernate.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSaveCustomer {
	private static final Logger log = LoggerFactory.getLogger(TestSaveCustomer.class);
	
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		CustomerDao customerDao = (CustomerDao)ctx.getBean("customerDao");
		
		Address  address = new Address();
		address.setAddress("DOMICILIO CONOCIDO2");
		address.setNumberInt(502);
		address.setPostalCode(52100);
		address.setComments("SIN DESCRIPCION2");
		
		Customer customer = new Customer();
		customer.setAddress(address);
		customer.setName("HUGO2");
		customer.setLastName("HIDALGO MARTINEZ2");
		customer.setPhone("N/A");
		
		customerDao.persist(customer);
		log.info(customer.toString());
		
		ctx.close();
		
	}

}
