package br.com.cpdias.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Contacts {
	
	private ContactDAO contactDAO;

	@Autowired
	public Contacts(ContactDAO contactDAO) {
		super();
		this.contactDAO = contactDAO;
	}
	
	
}
