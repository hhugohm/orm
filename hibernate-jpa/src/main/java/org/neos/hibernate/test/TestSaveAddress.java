package org.neos.hibernate.test;

import org.neos.hibernate.dao.AddressDao;
import org.neos.hibernate.dao.AddressDaoImpl;
import org.neos.hibernate.domain.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSaveAddress {
	
	private static AddressDao addressDao;
	private static final Logger log = 
			LoggerFactory.getLogger(TestSaveAddress.class);
	
	public static void main(String[] args) {
		
		addressDao = new AddressDaoImpl();
		
		Address  address = new Address();
		address.setAddress("OTRA DIRECCION");
		address.setNumberInt(402);
		address.setPostalCode(52104);
		address.setComments("TIENE REJA NEGRA");
		
		//addressDao.saveAddress(address);
		addressDao.persistAddress(address);
		
		log.info("Id de direccion: " + address.getIdAddress());

	}

}
