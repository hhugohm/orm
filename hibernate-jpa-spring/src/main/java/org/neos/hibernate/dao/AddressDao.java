package org.neos.hibernate.dao;

import java.util.List;

import org.neos.hibernate.domain.Address;

public interface AddressDao {
	
	public void saveAddress(Address address);
	public void persistAddress(Address address);
	public void updateAdress(Address address);
	public void deleteAdress(Address address);
	public List<Address> getAllAddress();
	public Address getByIdAddress(Address address);
	public Address loadByIdAddress(Address address);
}
