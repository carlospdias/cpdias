package br.com.cpdias.contact.seguranca;

import org.springframework.security.core.GrantedAuthority;

public class Perfil implements GrantedAuthority {
    private static final long serialVersionUID = 1L;
   
    private String nome;
    
    
    public Perfil(String nome) {
        super();
        this.nome = nome;
    }

    @Override
    public String getAuthority() {
        return nome;
    }
    
    public String getNome() {
        return nome;
    }


}
