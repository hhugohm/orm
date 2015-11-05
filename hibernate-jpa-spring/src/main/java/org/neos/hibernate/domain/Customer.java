package org.neos.hibernate.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name ="CUSTOMER",catalog="PAPELERIA")
public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer customerId;
	private String name;
	private String lastName;
	private String phone;
    private Address address;
    private List<Telephone> phones;
    
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID")
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	@Column(name = "NAME", nullable = false, length = 50)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "LASTNAME", nullable = false, length = 25)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name = "PHONE", nullable = false, length = 25)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="ID_ADDRESS",referencedColumnName="ID_ADDRESS")
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@OneToMany(orphanRemoval=true,cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="CUSTOMER_ID", referencedColumnName="CUSTOMER_ID")
	public List<Telephone> getPhones() {
		return phones;
	}
	public void setPhones(List<Telephone> phones) {
		this.phones = phones;
	}
	@Override
	public String toString(){
		StringBuilder cadena = new StringBuilder();
		cadena.append("IdCustomer: "+ this.customerId+ " ");
		cadena.append("name: "+ this.name+ " ");
		cadena.append("lastName: "+ this.lastName+ " ");
		cadena.append("phone: "+ this.phone+ " ");
		if(this.address!=null){
			cadena.append(address.toString());
		}
		return cadena.toString();
	}
	
}

