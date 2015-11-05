package org.neos.hibernate.test;

import org.neos.hibernate.dao.CustomerDao;
import org.neos.hibernate.dao.TelephoneDao;
import org.neos.hibernate.domain.Customer;
import org.neos.hibernate.domain.Telephone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDeleteCustomer {
	private static CustomerDao customerDao;
	private static TelephoneDao telephoneDao;

	private static final Logger log = LoggerFactory.getLogger(TestDeleteCustomer.class);

	public static void main(String args[]) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		customerDao = (CustomerDao) ctx.getBean("customerDao");
		telephoneDao = (TelephoneDao)ctx.getBean("telephoneDao");
		Customer customer = new Customer();
		customer.setCustomerId(7);

		customer = customerDao.find(customer.getCustomerId());
		if (customer != null) {
			log.debug(customer.toString());
			if(customer.getPhones()!=null){
				for(Telephone phone:customer.getPhones()){
					log.info(phone.toString());
					telephoneDao.remove(phone.getTelephoneKey());
				}
			}
			customerDao.remove(customer.getCustomerId());
			log.info("::SE BORRO LA ENTIDAD:::");
		} else {
			log.info("::NO SE ENCONTRO LA ENTIDAD:::");
		}
		ctx.close();
	}
}
