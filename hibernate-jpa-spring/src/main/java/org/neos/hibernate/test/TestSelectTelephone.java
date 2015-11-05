package org.neos.hibernate.test;


import org.neos.hibernate.dao.TelephoneDao;
import org.neos.hibernate.domain.Telephone;
import org.neos.hibernate.domain.TelephoneKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSelectTelephone {
	private static final Logger log = LoggerFactory.getLogger(TestSelectTelephone.class);

	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
			TelephoneDao telephoneDao = (TelephoneDao)ctx.getBean("telephonesDao");
			TelephoneKey key = new TelephoneKey(1,"1");
			

			Telephone telephone = telephoneDao.find(key);
			if (telephone != null) {
				log.info(telephone.toString());
			}
			ctx.close();
		} catch (Exception e) {
			log.error("", e);
		} 
		
		
	}

}
