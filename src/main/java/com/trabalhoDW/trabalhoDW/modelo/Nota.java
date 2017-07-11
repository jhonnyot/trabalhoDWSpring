/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

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
    private ArrayList<Long> notaConhecido;
    private ArrayList<Long> notaHospedagem;
    private ArrayList<Long> notaEsporte;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Usuario usuario;
    @OneToMany
    @PrimaryKeyJoinColumn
    private Set<Avaliacao> avaliacao;

    public void addNotaConhecido(long notaConhecido) {
        this.notaConhecido.add(notaConhecido);
    }

    public void addNotaHospedagem(long notaHospedagem) {
        this.notaHospedagem.add(notaHospedagem);
    }

    public void addNotaEsporte(long notaEsporte) {
        this.notaEsporte.add(notaEsporte);
    }

    public Nota() {
        this.notaConhecido = new ArrayList<>();
        this.notaEsporte = new ArrayList<>();
        this.notaHospedagem = new ArrayList<>();
    }

    public long getNotaConhecido() {
        long media = 0;
        if (this.notaConhecido.size() > 0) {
            for (Long iterador : notaConhecido) {
                media += iterador;
            }
            return media / notaConhecido.size();
        } else {
            return 0;
        }
    }

    public long getNotaHospedagem() {
        long media = 0;
        if (this.notaHospedagem.size() > 0) {
            for (Long iterador : notaHospedagem) {
                media += iterador;
            }
            return media / notaHospedagem.size();
        } else {
            return 0;
        }
    }

    public long getNotaEsporte() {
        long media = 0;
        if (this.notaEsporte.size() > 0) {
            for (Long iterador : notaEsporte) {
                media += iterador;
            }
            return media / notaEsporte.size();
        } else {
            return 0;
        }
    }

    public int getId() {
        return this.id;
    }

}
