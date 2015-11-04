package org.neos.hibernate.test;

import org.neos.hibernate.dao.CustomerDao;
import org.neos.hibernate.dao.CustomerDaoImpl;
import org.neos.hibernate.domain.Customer;
import org.neos.hibernate.utils.JPAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSelectCustomer {
	private static final Logger log = LoggerFactory.getLogger(TestSelectCustomer.class);

	public static void main(String[] args) {
		try {

			CustomerDao customerDao = new CustomerDaoImpl();
			Customer customer = new Customer();
			customer.setCustomerId(1);

			customer = customerDao.find(customer.getCustomerId());
			if (customer != null) {
				log.info(customer.toString());
			}
		} catch (Exception e) {
			log.error("", e);
		} finally {
			JPAUtil.getEntityManagerFactory().close();
		}
	}

}
