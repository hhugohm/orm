package org.neos.hibernate.dao;

import java.io.Serializable;
import java.util.List;

public interface AbstractDao<T> {
	
	 public void persist(T t);
	 public void update(T t);
	 public void remove(Serializable id);
	 public T find(Serializable id);
	 public List<T> findAll();

}
