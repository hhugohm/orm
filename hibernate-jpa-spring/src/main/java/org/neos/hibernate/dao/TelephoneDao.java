package org.neos.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.neos.hibernate.domain.Telephone;

public interface TelephoneDao {

	public void persist(Telephone telephone);
	 public void update(Telephone telephone);
	 public void remove(Serializable id);
	 public Telephone find(Serializable id);
	 public List<Telephone> findAll();
}
