/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
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
    private Integer id;
    private String CPF;
    private String telefone;
    private String endereco;
    private String email;
    private String nome;

    @OneToMany
    private List<Usuario> amigos;

    public Usuario() {
    }

    public Usuario(String CPF, String telefone, String endereco, String email, String nome) {
        this.CPF = CPF;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.nome = nome;
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
