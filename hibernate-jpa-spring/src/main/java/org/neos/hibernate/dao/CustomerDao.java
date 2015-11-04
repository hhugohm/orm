package org.neos.hibernate.dao;


import java.io.Serializable;
import java.util.List;

import org.neos.hibernate.domain.Customer;

public interface CustomerDao {
	
	public void persist(Customer customer);
	 public void update(Customer customer);
	 public void remove(Customer customer);
	 public Customer find(Serializable id);
	 public List<Customer> findAll();

}
