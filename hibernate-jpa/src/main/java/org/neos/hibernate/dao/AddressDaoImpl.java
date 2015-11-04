package org.neos.hibernate.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.neos.hibernate.domain.Address;
import org.neos.hibernate.utils.HibernateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressDaoImpl implements AddressDao {
private Session session;
	
	private static final Logger log = 
								LoggerFactory.getLogger(AddressDaoImpl.class);
	
	@Override
	public void saveAddress(Address address) {
		session = HibernateUtils.getSession();
		Transaction txt = session.beginTransaction();
		try {
			log.info("SE VA A GUARDAR UNA DIRECCION..." + address);

			session.save(address);
			
			txt.commit();
			

		} catch (Exception e) {
			txt.rollback();
		} finally {
			HibernateUtils.closeSession();;
		}

	}
	
	@Override
	public void persistAddress(Address address) {
		session = HibernateUtils.getSession();
		Transaction txt = session.beginTransaction();
		try {
			log.info("SE VA A GUARDAR..." + address);

			session.persist(address);
			
			txt.commit();
			

		} catch (Exception e) {
			txt.rollback();
		} finally {
			HibernateUtils.closeSession();;
		}

	}

	@Override
	public void updateAdress(Address address) {
		session = HibernateUtils.getSession();
		Transaction txt = session.beginTransaction();
		try {
			log.info("SE VA A MODIFICAR..." + address);

			session.update(address);
			txt.commit();

		} catch (Exception e) {
			txt.rollback();
		} finally {
			HibernateUtils.closeSession();;
		}

	}


	@Override
	public void deleteAdress(Address address) {
		session = HibernateUtils.getSession();
		Transaction txt = session.beginTransaction();
		try {
			log.info("SE VA A BORRAR..." + address);

			session.delete(address);
			txt.commit();

		} catch (Exception e) {
			txt.rollback();
		} finally {
			HibernateUtils.closeSession();;
		}

	}

	@Override
	public List<Address> getAllAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address getByIdAddress(Address address) {
		session = HibernateUtils.getSession();
		Transaction txt = session.beginTransaction();
		Address resultAdrress = new Address();
		try {
			log.info("SE VA A OBTENER DIRECCION..." + address.getIdAddress());

			resultAdrress= (Address) 
							session.get(Address.class, address.getIdAddress());
			txt.commit();
		} catch (Exception e) {
			txt.rollback();
		} finally {
			HibernateUtils.closeSession();
		}
		
		return resultAdrress;
	}

	@Override
	public Address loadByIdAddress(Address address) {
		session = HibernateUtils.getSession();
		Transaction txt = session.beginTransaction();
		Address resultAdrress = new Address();
		try {
			log.info("SE VA A OBTENER DIRECCION...con LOAD 4 : "
													+ address.getIdAddress());

			resultAdrress= (Address) 
							session.load(Address.class, address.getIdAddress());
			txt.commit();
			
			Hibernate.initialize(resultAdrress);
			 
		} catch (Exception e) {
			txt.rollback();
		} finally {
			HibernateUtils.closeSession();;
		}
		
		return resultAdrress;
	}
	
	

}
