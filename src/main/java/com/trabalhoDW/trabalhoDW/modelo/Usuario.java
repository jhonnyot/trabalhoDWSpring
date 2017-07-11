/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author guilherme
 */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "usuario_id")
    private int id;
    private String senha;
    private String telefone;
    private String endereco;
    private String email;
    private String nome;
    private int ativo;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_papel", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "papel_id"))
    private Set<Papel> papel;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "hospedagem", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "hospedagem_id"))
    private Set<Hospedagem> hospedagens;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Usuario> amigos;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Usuario> amigoshospedados;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Usuario> amigosEsportes;
    @OneToOne(cascade = CascadeType.ALL)
    private Nota nota;
    private boolean isDisponivel;
    private String pais;
    private String cidade;

    public Usuario() {
    }

    public Usuario(String telefone, String endereco, String email, String nome, String senha) {
        this.telefone = telefone; 
        this.endereco = endereco;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }

    public Usuario(String senha, String telefone, String endereco, String email, String nome, String pais, String cidade, boolean isDisponivel) {
        this.senha = senha;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.nome = nome;
        this.pais = pais;
        this.cidade = cidade;
        this.isDisponivel = isDisponivel;
    }

    public int getId() {
        return id;
    }

    public void inicializaAmigos() {
        amigos = new ArrayList<>();
    }


    public void adicionaAmigo(Usuario usuario) {
        amigos.add(usuario);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public Set<Papel> getPapel() {
        return papel;
    }

    public void setPapel(Set<Papel> papel) {
        this.papel = papel;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Usuario> amigos) {
        this.amigos = amigos;
    }
    
    public void setNota(Nota nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.id, other.id);
    }
}
