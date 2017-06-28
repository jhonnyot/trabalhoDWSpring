/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author guilherme
 */
@Entity
public class Nota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private int id;
    @ElementCollection
    private List<Long> notaConhecido;
    @ElementCollection
    private List<Long> notaHospedagem;
    @ElementCollection
    private List<Long> notaEsporte;
    @OneToOne
    private Usuario usuario;

    public Nota() {
    }

    private long getNotaConhecido() {
        long media = 0;
        for (Long iterador : notaConhecido) {
            media += iterador;
        }
        return media / notaConhecido.size();
    }

    private long getNotaHospedagem() {
        long media = 0;
        for (Long iterador : notaHospedagem) {
            media += iterador;
        }
        return media / notaHospedagem.size();
    }

    private long getNotaEsporte() {
        long media = 0;
        for (Long iterador : notaEsporte) {
            media += iterador;
        }
        return media / notaEsporte.size();
    }

}
