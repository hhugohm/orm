package org.neos.hibernate.test;

import org.neos.hibernate.dao.AddressDao;
import org.neos.hibernate.dao.AddressDaoImpl;
import org.neos.hibernate.domain.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDeleteAddress {
	private static AddressDao addressDao;
	private static AddressDao addressDelete;

	private static final Logger log = LoggerFactory
			.getLogger(TestDeleteAddress.class);

	public static void main(String args[]) {
		addressDao = new AddressDaoImpl();
		addressDelete = new AddressDaoImpl();

		Address address = new Address();
		address.setIdAddress(2);

		address = addressDao.loadByIdAddress(address);
		
		log.info(":::::ELIMINANDO DIRECCIO::::::");
		
		
		addressDelete.deleteAdress(address);

	}

}
