package br.com.cpdias.contact.seguranca;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UsuarioAutenticado extends User {
    private static final long serialVersionUID = 1L;
    
    private String secao;
    private int idSecao;
    
    public UsuarioAutenticado(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
    
    public UsuarioAutenticado(UsuarioDTO usuario) {
        super(usuario.getId(), usuario.getSenha(), true, true, true, true, usuario.getPerfis());
        this.idSecao = usuario.getIdSecao();
        this.secao   = usuario.getSiglaSecao();
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public int getIdSecao() {
        return idSecao;
    }

    public void setIdSecao(int idSecao) {
        this.idSecao = idSecao;
    }

    @Override
    public String toString() {
        return "UsuarioApp [secao=" + secao + ", idSecao=" + idSecao + ", getAuthorities()=" + getAuthorities()
                + ", getPassword()=" + getPassword() + ", getUsername()=" + getUsername() + ", isEnabled()="
                + isEnabled() + ", isAccountNonExpired()=" + isAccountNonExpired() + ", isAccountNonLocked()="
                + isAccountNonLocked() + ", isCredentialsNonExpired()=" + isCredentialsNonExpired() + "]";
    }
    
}
