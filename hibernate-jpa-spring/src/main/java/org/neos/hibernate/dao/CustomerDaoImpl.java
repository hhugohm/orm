package org.neos.hibernate.dao;



import org.neos.hibernate.domain.Customer;
import org.springframework.stereotype.Repository;


@Repository("customerDao")
public class CustomerDaoImpl  extends AbstractDaoImpl<Customer> implements CustomerDao {

	public CustomerDaoImpl() {
		super(Customer.class);
	}
	
}
