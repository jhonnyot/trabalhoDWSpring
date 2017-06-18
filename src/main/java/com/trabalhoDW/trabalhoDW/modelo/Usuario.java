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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author sti
 */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int id;
//    private String CPF;
    private String senha;
    private String telefone;
    private String endereco;
    private String email;
    private String nome;
    @OneToMany
    private List<Usuario> amigos;

    public Usuario() {
    }

    public Usuario(String telefone, String endereco, String email, String nome, String senha) {
//        this.CPF = CPF;
        this.telefone = telefone; 
        this.endereco = endereco;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }
    public void inicializaAmigos(){
        amigos = new ArrayList<>();
    }
    public void adicionaAmigo(Usuario usuario){
        amigos.add(usuario);
    }
    public void setId(int id) {
        this.id = id;
    }

//    public String getCPF() {
//        return CPF;
//    }
//
//    public void setCPF(String CPF) {
//        this.CPF = CPF;
//    }

    public String getSenha() {
        return senha;
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
