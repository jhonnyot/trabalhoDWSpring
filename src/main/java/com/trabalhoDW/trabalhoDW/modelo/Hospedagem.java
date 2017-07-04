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
    private int numeroHospedeiros;
    private int numeroEspostistas;
    @Type(type="date")
    private Date dataInicial;
    @Type(type="date")
    private Date dataFinal;
    private boolean aprovado;
    
}
