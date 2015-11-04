package org.neos.hibernate.dao;



import org.neos.hibernate.domain.Telephone;
import org.springframework.stereotype.Repository;

@Repository("telephonesDao")
public class TelephonesDaoImpl extends AbstractDaoImpl<Telephone>implements TelephonesDao {

	public TelephonesDaoImpl() {
		super(Telephone.class);
	}
}
