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
 * @author Conv DACC
 */
@Entity
public class Hospedagem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "hospedagem_id")
    private int id;
    private int idHospedeiro;
    private int numeroHospedes;
    private int numeroEsportistas;
    @Type(type = "date")
    private Date dataInicial;
    @Type(type = "date")
    private Date dataFinal;
    private boolean aprovado;

    public Hospedagem() {
    }

    public Hospedagem(int numeroHospedes, int numeroEsportistas, Date dataInicial, Date dataFinal) {
        this.numeroHospedes = numeroHospedes;
        this.numeroEsportistas = numeroEsportistas;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHospedeiro() {
        return idHospedeiro;
    }

    public void setIdHospedeiro(int idHospedeiro) {
        this.idHospedeiro = idHospedeiro;
    }

    public int getNumeroHospedes() {
        return numeroHospedes;
    }

    public void setNumeroHospedes(int numeroHospedes) {
        this.numeroHospedes = numeroHospedes;
    }

    public int getNumeroEsportistas() {
        return numeroEsportistas;
    }

    public void setNumeroEsportistas(int numeroEsportistas) {
        this.numeroEsportistas = numeroEsportistas;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

}
