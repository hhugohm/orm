package org.neos.hibernate.test;

import org.neos.hibernate.dao.CustomerDao;
import org.neos.hibernate.dao.CustomerDaoImpl;
import org.neos.hibernate.domain.Customer;
import org.neos.hibernate.utils.JPAUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestUpdateCustomer {
	
	private static final Logger log =  LoggerFactory.getLogger(TestUpdateCustomer.class);
	
	private static CustomerDao customerDao;
	
	public static void main(String args[]) {
		try {
			customerDao = new CustomerDaoImpl();

			Customer customer = new Customer();
			customer.setCustomerId(1);

			customer = customerDao.find(customer.getCustomerId());
			if (customer != null) {
				log.debug(customer.toString());
				customer.setPhone("7227150689");
				customerDao.update(customer);
				log.info("::SE MODIFICO LA ENTIDAD:::");
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
