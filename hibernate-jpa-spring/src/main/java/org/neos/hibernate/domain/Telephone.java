package org.neos.hibernate.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TELEPHONE")
public class Telephone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId   //al ocupar esta anotacion es obligatorio que la clase key sobreescriba los metodos hashcode y equals
	private TelephoneKey telephoneKey;

	@Column(name = "TELEPHONE")
	private String telephone;
	
	@Column(name = "TYPE_PHONE")
	private String typeTelephone;
    
	public Telephone(TelephoneKey telephoneKey,String telephone,String typeTelephone){
		this.telephoneKey=telephoneKey;
		this.telephone=telephone;
		this.typeTelephone=typeTelephone;
	}
	public Telephone(){
	}
	
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
	
	public String getTypeTelephone() {
		return typeTelephone;
	}

	public void setTypeTelephone(String typeTelephone) {
		this.typeTelephone = typeTelephone;
	}

	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("idTelephone: " + telephoneKey.getId() + " ");
		cadena.append("idCustomer: " + telephoneKey.getIdCustomer() + " ");
		cadena.append("Telephone: " + this.telephone + " ");
		cadena.append("Type: " + this.typeTelephone + " ");
		return cadena.toString();
	}

}
