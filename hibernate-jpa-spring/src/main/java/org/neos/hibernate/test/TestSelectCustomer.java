package org.neos.hibernate.test;

import org.neos.hibernate.dao.CustomerDao;
import org.neos.hibernate.domain.Customer;
import org.neos.hibernate.domain.Telephone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSelectCustomer {
	private static final Logger log = LoggerFactory.getLogger(TestSelectCustomer.class);

	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
			CustomerDao customerDao = (CustomerDao)ctx.getBean("customerDao");
			Customer customer = new Customer();
			customer.setCustomerId(1);

			customer = customerDao.find(customer.getCustomerId());
			if (customer != null) {
				log.info(customer.toString());
				if(customer.getPhones()!=null){
					log.info("NUMERO DE TELEFONOS: " +customer.getPhones().size() );
					for(Telephone telephone:customer.getPhones()){
						log.info(telephone.toString());
					}
				}
			}
			ctx.close();
		} catch (Exception e) {
			log.error("", e);
		} 
		
		
	}

}
