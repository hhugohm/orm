package org.neos.hibernate.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="ADDRESS",catalog="PAPELERIA")
public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer idAddress;	
	private String address;
	private Integer numberInt;
	private Integer postalCode;
	private String comments;

	public Address() {
	}
	
	public Address(String address, Integer numberInt, Integer postalCode,
			String comments) {
		super();
		this.address = address;
		this.numberInt = numberInt;
		this.postalCode = postalCode;
		this.comments = comments;
	}

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_ADDRESS")
	public Integer getIdAddress() {
		return idAddress;
	}
	
	public void setIdAddress(Integer idAddress) {
		this.idAddress = idAddress;
	}
	@Column(name = "ADDRESS",nullable=false,length=200)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name = "NUMBERINT",nullable=true)
	public Integer getNumberInt() {
		return numberInt;
	}

	public void setNumberInt(Integer numberInt) {
		this.numberInt = numberInt;
	}
	@Column(name = "POSTALCODE",nullable=true)
	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}
	@Column(name = "COMMENTS",nullable=true)
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	@Override
	public String toString(){
		StringBuilder cadena = new StringBuilder();
		cadena.append("idAddress "+ this.idAddress+ " ");
		cadena.append("address "+ this.address+ " ");
		cadena.append("No "+ this.numberInt+ " ");
		cadena.append("CP "+ this.postalCode+ " ");
		cadena.append("comments "+ this.comments+ " ");
		return cadena.toString();
		
	}
}
