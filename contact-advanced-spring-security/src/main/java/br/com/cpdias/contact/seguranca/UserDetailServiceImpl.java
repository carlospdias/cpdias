package br.com.cpdias.contact.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {
    
    
    private UsuarioDao UsuarioDao;
   
    @Autowired
    public UserDetailServiceImpl(UsuarioDao usuarioDao) {
        super();
        UsuarioDao = usuarioDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioDTO usuario = UsuarioDao.recuperar(username);
        return new UsuarioAutenticado(usuario);
   
    }
 
}
