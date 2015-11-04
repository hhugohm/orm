package org.neos.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.neos.hibernate.domain.Telephone;

public interface TelephonesDao {

	public void persist(Telephone telephone);
	 public void update(Telephone telephone);
	 public void remove(Telephone telephone);
	 public Telephone find(Serializable id);
	 public List<Telephone> findAll();
}
