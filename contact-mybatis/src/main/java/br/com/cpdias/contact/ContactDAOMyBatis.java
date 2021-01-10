package br.com.cpdias.contact;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cpdias.contact.exception.PersistenceException;

@Repository("contactDao")
class ContactDAOMyBatis implements ContactDAO {
	
	private SqlSession sqlSession;
	private static final Logger LOGGER = LoggerFactory.getLogger(ContactDAOMyBatis.class);
	
	@Autowired
	public ContactDAOMyBatis(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	@Override
	public void save(Contact contact) {
		LOGGER.info("Gravando o objeto contact :{}", contact.toString());
		try {
			this.sqlSession.insert("contact.contacts.insert", contact);
		}
		catch(Exception exc) {
			throw new PersistenceException(exc.getMessage(), exc.getCause());
		}
	}

	@Override
	public void update(Contact contact) {
		LOGGER.info("Atualizando  o objeto contact :{}", contact.toString());
		this.sqlSession.update("contact.contacts.update", contact);
	}

	@Override
	public void delete(long contactId) {
		LOGGER.info("Excluindo o objeto Contact :{}", contactId);
		this.sqlSession.delete("contact.contacts.delete", contactId);
	}

	@Override
	public Contact get(long contactId) {
		LOGGER.info("Restaurando o objeto  :{}", contactId);
		return this.sqlSession.selectOne("contact.contacts.byId", contactId);
	}

	@Override
	public List<Contact> list() {
		LOGGER.info("Busca de todos os contacts.");
		List<Contact>usuarios = this.sqlSession.selectList("contact.contacts.allContacts");
        
        if (usuarios != null) {
        	LOGGER.info("Retornando {} contacts.", usuarios.size());
            return Collections.unmodifiableList(usuarios);
        }
        return Collections.emptyList();
        
	}

}
