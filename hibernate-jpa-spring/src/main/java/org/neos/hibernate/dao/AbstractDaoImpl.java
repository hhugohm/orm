package org.neos.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AbstractDaoImpl<T extends Serializable> implements AbstractDao<T> {

	@PersistenceContext
	private EntityManager manager;
	private Class<T> aClass;

	public AbstractDaoImpl() {
	}

	public AbstractDaoImpl(Class<T> aClass) {
		this.aClass = aClass;
	}

	@Override
	public void persist(T t) {
		manager.persist(t);
	}

	@Override
	public void update(T t) {
		manager.merge(t);
	}

	@Override
	public void remove(Serializable id) {
		manager.remove(manager.find(aClass, id));
	}

	@Override
	public T find(Serializable id) {
		return manager.find(aClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		String query = "select o from " + aClass.getName() + " o";
		Query q = manager.createQuery(query, aClass);
		return q.getResultList();
	}
}
