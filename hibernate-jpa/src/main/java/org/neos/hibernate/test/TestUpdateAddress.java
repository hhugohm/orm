package org.neos.hibernate.test;


import org.neos.hibernate.dao.AddressDao;
import org.neos.hibernate.dao.AddressDaoImpl;
import org.neos.hibernate.domain.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestUpdateAddress {
	private static AddressDao addressDao;
	private static AddressDao addressUpdate;
	
	private static final Logger log = 
			LoggerFactory.getLogger(TestSaveAddress.class);
	public static void main(String args[]) {
		
		addressDao = new AddressDaoImpl();
		addressUpdate = new AddressDaoImpl();
		
		Address  address = new Address();
		address.setIdAddress(3);
		
		address = addressDao.loadByIdAddress(address);	
		
		
		address.setAddress("Aldama");
		address.setNumberInt(502);
		address.setComments("a media cuadra de independencia 4");
		
		addressUpdate.updateAdress(address);
		
		log.info("Id de direccion: " + address.getIdAddress());
		log.info("Address: " + address.getAddress());		
		log.info("CP: " + address.getPostalCode());
		log.info("Number int: " + address.getNumberInt());
		log.info("Comentarios: "  + address.getComments());		
		
		
	} 
}
