package br.com.cpdias.contact;

import java.util.Collections;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
		return this.sessionFactory.getCurrentSession().get(Contact.class, contactId);
	}

	@Override
	public List<Contact> list() {
		LOGGER.info("Busca de todos os contacts.");
		CriteriaQuery<Contact> all = contactCriteria();

	    TypedQuery<Contact> allQuery = this.sessionFactory.getCurrentSession().createQuery(all);
	    List<Contact> usuarios =  allQuery.getResultList();
        
        if (usuarios != null) {
        	LOGGER.info("Retornando {} contacts.", usuarios.size());
            return Collections.unmodifiableList(usuarios);
        }
        return Collections.emptyList();
        
	}

	private CriteriaQuery<Contact> contactCriteria() {
		CriteriaBuilder cb = this.sessionFactory.getCurrentSession().getCriteriaBuilder();
	    CriteriaQuery<Contact> cq = cb.createQuery(Contact.class);
	    Root<Contact> rootEntry = cq.from(Contact.class);
	    CriteriaQuery<Contact> all = cq.select(rootEntry);
		return all;
	}

}
