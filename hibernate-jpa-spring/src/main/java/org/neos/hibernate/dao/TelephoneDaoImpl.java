package org.neos.hibernate.dao;



import org.neos.hibernate.domain.Telephone;
import org.springframework.stereotype.Repository;


@Repository("telephoneDao")
public class TelephoneDaoImpl extends AbstractDaoImpl<Telephone>implements TelephoneDao {

	public TelephoneDaoImpl() {
		super(Telephone.class);
	}
}
