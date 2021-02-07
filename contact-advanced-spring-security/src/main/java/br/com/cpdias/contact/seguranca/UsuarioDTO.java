package br.com.cpdias.contact.seguranca;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO {
    
    private String id;
    private String nome;
    private String senha;
    private int idSecao;
    private String siglaSecao;
    private boolean isChefe;
    private boolean  isSubChefe;
    private boolean isAtivo;
    
    
    private List<Perfil>extrairPerfis(){
        List<Perfil>perfis = new ArrayList<>();
        if (isChefe()) {
            perfis.add(new Perfil("ROLE_CHEFE_SECAO"));
        }
        if (isSubChefe()) {
            perfis.add(new Perfil("ROLE_SUB_CHEFE_SECAO"));
        }
        perfis.add(new Perfil("ROLE_AUTENTICADO")); //perfil padrão para entrar na aplicação.
        return perfis;
    }
    
    public  List<Perfil> getPerfis() {
        return extrairPerfis();
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public int  getIdSecao() {
        return idSecao;
    }
    public void setIdSecao(int idSecao) {
        this.idSecao = idSecao;
    }
    public String getSiglaSecao() {
        return siglaSecao;
    }
    public void setSiglaSecao(String siglaSecao) {
        this.siglaSecao = siglaSecao;
    }
    public boolean isChefe() {
        return isChefe;
    }
    public void setChefe(boolean isChefe) {
        this.isChefe = isChefe;
    }
    public boolean isSubChefe() {
        return isSubChefe;
    }
    public void setSubChefe(boolean isSubChefe) {
        this.isSubChefe = isSubChefe;
    }
    public boolean isAtivo() {
        return isAtivo;
    }
    public void setAtivo(boolean isAtivo) {
        this.isAtivo = isAtivo;
    }
    
    
}
