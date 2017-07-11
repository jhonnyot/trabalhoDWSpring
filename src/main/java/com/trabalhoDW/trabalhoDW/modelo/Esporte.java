/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.Type;

/**
 *
 * @author guilherme
 */
@Entity
public class Esporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "esporte_id")
    private int id;
    private String nome = "Surf";
    @Type(type = "date")
    private Date data;
    private String nomeSolicitante;
    private int idSolicitante;
    private int idSolicitado;
    private boolean aprovado;

    public Esporte() {
    }

    public Esporte(Date data, int idSolicitante, int idSolicitado, String nome) {
        this.data = data;
        this.idSolicitante = idSolicitante;
        this.idSolicitado = idSolicitado;
        this.nomeSolicitante = nome;
    }

    public String getNomeSolicitante() {
        return nomeSolicitante;
    }

    public int getId() {
        return id;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
