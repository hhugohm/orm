package org.neos.hibernate.dao;


import org.neos.hibernate.domain.Customer;

public interface CustomerDao {
	
	public void saveCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
	public Customer getByIdAddress(Customer customer);

}
