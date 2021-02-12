package br.com.cpdias.contact;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.cpdias.contact.config.CtxPersistenciaBaseTesteIntegracaoBD;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CtxPersistenciaBaseTesteIntegracaoBD.class})
public class Cen_PersistenceContact {

	@Autowired
	private ContactDAO contactDAO;
	
	private List<Contact> contacts = new ArrayList<>(0);
	@Test
	public void existe_banco() {
		assertNotNull(contactDAO, "Objeto de persistência de contato está inválido.");
	}
	
	@Test
	@Transactional
	public void deve_retornar_uma_lista_vazia() {
		 this.contacts = contactDAO.list();
		 assertNotNull(this.contacts);
		 assertThat(this.contacts.size(), greaterThan(0));
	}
	
	@Test
	@Transactional
	@Commit
	public void deve_lancar_uma_excecao_ao_tentar_gravar_um_objeto_invalido() {
		 Contact contact = createInvalidContact(); 
		 assertThrows(DataIntegrityViolationException.class, ()->contactDAO.save(contact));
		 
	}
	
	@Test
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW)
	//@Commit
	public void deve_retornar_um_objeto_gravado() {
		 Contact contact = createvalidContact();
		 contactDAO.save(contact);
		 List<Contact>localListOfContacts = contactDAO.list();
		 assertThat(localListOfContacts.size(), greaterThan(this.contacts.size()));
		 
	}
	
	@Test
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW)
	//@Commit
	public void deve_excluir_um_objeto() {
		 Contact contact = contactDAO.get(1L);
		 contactDAO.delete(contact.getId());
		 
		 Contact deletedContact = contactDAO.get(1L);
		 assertNull(deletedContact);
		 
	}
	
	@Test
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW)
	//@Commit
	public void deve_atulizar_um_objeto() {
		 Contact contact = contactDAO.get(1L);
		 contact.setEmail("aaa@aaa.com.br");
		 contactDAO.update(contact);
		 Contact updatedContact = contactDAO.get(1L);
		 assertEquals(contact.getEmail(), updatedContact.getEmail());
		 
	}
	
	private Contact createInvalidContact() {
		Contact contact = new Contact();
		
		return contact;
	}
	
	
	
	private Contact createvalidContact() {
		Contact contact = new Contact();
	
		contact.setName("Eduardo Siqueira");
		contact.setEmail("eduardo@truma.com.br");
		contact.setTelephone("(66) 3359-7585");
		contact.setAddress("Rua Almeida 25, casa 7");
		
		return contact;
	}
}
