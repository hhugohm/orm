package org.neos.hibernate.test;

import java.util.List;

import org.neos.hibernate.dao.CustomerDao;
import org.neos.hibernate.dao.CustomerDaoImpl;
import org.neos.hibernate.domain.Customer;
import org.neos.hibernate.utils.JPAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSelectAllCustomer {
	private static final Logger log = LoggerFactory.getLogger(TestSelectAllCustomer.class);
	public static void main(String[] args) {
		CustomerDao customerDao = new CustomerDaoImpl();
		try {

			List<Customer> ltsCustomer;

			ltsCustomer = customerDao.findAll();
			for(Customer customer:ltsCustomer){
				log.debug(customer.toString());
			}
			
		} catch (Exception e) {
			log.error("", e);
		} finally {
			JPAUtil.getEntityManagerFactory().close();
		}
	}


}
