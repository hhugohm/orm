package org.neos.hibernate.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TelephoneKey implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "ID_TELEPHONE", nullable = false)
    private Integer id;

    @Column(name = "ID_CUSTOMER", nullable = false)
    private String idCustomer;
    
    public TelephoneKey(){
    	
    }
    public TelephoneKey(Integer id,String idCustomer){
    	this.id=id;
    	this.idCustomer=idCustomer;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	} 
	@Override
	public int hashCode() {
		return id.hashCode()+idCustomer.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TelephoneKey) {
			TelephoneKey telephoneKey = (TelephoneKey) obj;
			
			if(!telephoneKey.getId().equals(id)){
				return false;
			}
			if(!telephoneKey.getIdCustomer().equals(idCustomer)){
				return false;
			}
			return true;
		}

		return false;
	}

}
