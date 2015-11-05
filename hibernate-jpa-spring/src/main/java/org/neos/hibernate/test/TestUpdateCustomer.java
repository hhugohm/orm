package org.neos.hibernate.test;

import org.neos.hibernate.dao.CustomerDao;
import org.neos.hibernate.domain.Customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUpdateCustomer {
	
	private static final Logger log =  LoggerFactory.getLogger(TestUpdateCustomer.class);
	
	private static CustomerDao customerDao;
	
	public static void main(String args[]) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
			customerDao = (CustomerDao)ctx.getBean("customerDao");

			Customer customer = new Customer();
			customer.setCustomerId(7);

			customer = customerDao.find(customer.getCustomerId());
			if (customer != null) {
				log.debug(customer.toString());
				customer.setPhone("71389895627");
				customerDao.update(customer);
				log.info("::SE MODIFICO LA ENTIDAD:::");
			} else {
				log.info("::NO SE ENCONTRO LA ENTIDAD:::");
			}
			ctx.close();

	}
}
