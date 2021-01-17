package br.com.cpdias.contact;

import java.util.Collections;
import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.ibatis.session.SqlSession;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("contactDao")
class ContactDAOHib implements ContactDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContactDAOHib.class);
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public ContactDAOHib(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Contact contact) {
		LOGGER.info("Gravando o objeto contact :{}", contact.toString());
		try {
			this.sessionFactory.getCurrentSession().save(contact);
		}
		catch(Exception exc) {
			throw new PersistenceException(exc.getMessage(), exc.getCause());
		}
	}

	@Override
	public void update(Contact contact) {
		LOGGER.info("Atualizando  o objeto contact :{}", contact.toString());
		this.sessionFactory.getCurrentSession().update(contact);
	}

	@Override
	public void delete(long contactId) {
		LOGGER.info("Excluindo o objeto Contact :{}", contactId);
		Contact contact =  this.sessionFactory.getCurrentSession().load(Contact.class, contactId);
		if (contact != null) {
			this.sessionFactory.getCurrentSession().delete(contact);
		}
	}

	@Override
	public Contact get(long contactId) {
		LOGGER.info("Restaurando o objeto  :{}", contactId);
		return this.sessionFactory.getCurrentSession().get(Contact.class, contactId);s
	}

	@Override
	public List<Contact> list() {
		LOGGER.info("Busca de todos os contacts.");
		List<Contact>usuarios = this.sessionFactory.getCurrentSession().createCriteria(Contact.class).list();
        
        if (usuarios != null) {
        	LOGGER.info("Retornando {} contacts.", usuarios.size());
            return Collections.unmodifiableList(usuarios);
        }
        return Collections.emptyList();
        
	}

}
