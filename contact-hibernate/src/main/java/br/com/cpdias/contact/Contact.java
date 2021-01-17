package br.com.cpdias.contact;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT")
@Access(AccessType.FIELD)
public class Contact {
	
	@Id
	private Long id;
	
	@Column(name = "NAME")
    private String name;
	
	@Column(name = "EMAIL")
    private String email;
    
	@Column(name = "ADDRESS")
    private String address;
	
	@Column(name = "TELEPHONE")
    private String telephone;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
