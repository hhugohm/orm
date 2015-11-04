package org.neos.hibernate.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="telephones")
public class Telephone implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@EmbeddedId
	private TelephoneKey telephoneKey;
	
	@Column(name = "TELEPHONE")
	private String telephone;

	public TelephoneKey getTelephoneKey() {
		return telephoneKey;
	}

	public void setTelephoneKey(TelephoneKey telephoneKey) {
		this.telephoneKey = telephoneKey;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Override
	public String toString(){
		StringBuilder cadena = new StringBuilder();
		cadena.append("idTelephone: "+ telephoneKey.getId()+" ");
		cadena.append("idCustomer: "+ telephoneKey.getIdCustomer()+" ");
		cadena.append("Telephone: "+ this.telephone +" ");
		return cadena.toString();
	}
	
	
}
