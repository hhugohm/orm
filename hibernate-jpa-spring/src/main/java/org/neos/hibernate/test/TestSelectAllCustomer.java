package org.neos.hibernate.test;

import java.util.List;

import org.neos.hibernate.dao.CustomerDao;
import org.neos.hibernate.domain.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSelectAllCustomer {
	private static final Logger log = LoggerFactory.getLogger(TestSelectAllCustomer.class);

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		CustomerDao customerDao = (CustomerDao) ctx.getBean("customerDao");

		List<Customer> ltsCustomer;

		ltsCustomer = customerDao.findAll();
		for (Customer customer : ltsCustomer) {
			log.debug(customer.toString());
		}
		ctx.close();
	}

}
