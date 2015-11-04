package org.neos.hibernate.test;

import org.neos.hibernate.dao.CustomerDao;
import org.neos.hibernate.dao.CustomerDaoImpl;
import org.neos.hibernate.domain.Customer;
import org.neos.hibernate.utils.JPAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDeleteCustomer {
	private static CustomerDao customerDao;

	private static final Logger log = LoggerFactory.getLogger(TestDeleteCustomer.class);

	public static void main(String args[]) {
		try {
			customerDao = new CustomerDaoImpl();

			Customer customer = new Customer();
			customer.setCustomerId(2);

			customer = customerDao.find(customer.getCustomerId());
			if (customer != null) {
				log.debug(customer.toString());
				customerDao.remove(customer);
				log.info("::SE BORRO LA ENTIDAD:::");
			} else {
				log.info("::NO SE ENCONTRO LA ENTIDAD:::");
			}
		} catch (Exception e) {
			log.error("", e);
		} finally {
			JPAUtil.getEntityManagerFactory().close();
		}

	}
}
