package br.com.cpdias.contact;

import java.util.List;

interface ContactDAO {
	
	void save(Contact contact);
    
	void update(Contact contact);
	
    void delete(long contactId);
     
    Contact get(long contactId);
     
    List<Contact> list();
    
}
