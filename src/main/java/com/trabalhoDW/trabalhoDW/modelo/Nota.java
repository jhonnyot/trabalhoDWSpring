/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author JP
 */
@Entity
public class Nota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private long id;
    private List<Long> notaConhecido;
    private List<Long> notaHospedagem;
    private List<Long> notaEsporte;
    @OneToOne
    private Usuario usuario;

    private long getNotaConhecido() {
        long media = 0;
        for (Long l : notaConhecido) {
            media += l;
        }
        return media / notaConhecido.size();
    }

    private long getNotaHospedagem() {
        long media = 0;
        for (Long l : notaHospedagem) {
            media += l;
        }
        return media / notaHospedagem.size();
    }

    private long getNotaEsporte() {
        long media = 0;
        for (Long l : notaEsporte) {
            media += l;
        }
        return media / notaEsporte.size();
    }

}
