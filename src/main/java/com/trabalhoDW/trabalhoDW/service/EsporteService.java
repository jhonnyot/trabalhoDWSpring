/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.service;

import com.trabalhoDW.trabalhoDW.daos.EsporteDAO;
import com.trabalhoDW.trabalhoDW.modelo.Esporte;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author guilherme
 */
@Service
public class EsporteService {

    @Autowired
    private EsporteDAO esporteDAO;

    public List<Esporte> listarPorIdSolicitado(int idSolicitado) {
        return esporteDAO.buscarPorIdSolicitado(idSolicitado);
    }

    public Esporte buscarPorId(int id) {
        return esporteDAO.findOne(id);
    }
    public Esporte salvar(Esporte e){
        return esporteDAO.save(e);
    }
}
