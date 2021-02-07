package br.com.cpdias.contact.seguranca;

import org.springframework.stereotype.Repository;

@Repository("usuarioDao")
class UsuarioDaoInMemory implements UsuarioDao {

    @Override
    public UsuarioDTO recuperar(String id) {
        UsuarioDTO u = new UsuarioDTO();
        
        u.setId("carlos");
        u.setNome("Ênio");
        u.setSenha("$2a$10$4vme6oHShjemqAJo.txyk.FsZpnT3HklZKJFZ5M67DOelsV6yGMrW");
        u.setSiglaSecao("asd");
        u.setIdSecao(1201);
        u.setChefe(true);
        u.setSubChefe(false);
        
        return u;
    }

}
