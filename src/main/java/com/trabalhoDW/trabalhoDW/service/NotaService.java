/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.service;

import com.trabalhoDW.trabalhoDW.daos.NotaDAO;
import com.trabalhoDW.trabalhoDW.modelo.Nota;
import org.springframework.stereotype.Service;

/**
 *
 * @author JP
 */
@Service
public class NotaService {

    private NotaDAO notaDAO;

    public void notaPorUsuario(long idUsuario, int idNota) {
        Nota nota = buscarPorId(idNota);
    }

    public Nota buscarPorId(int id) {
        return notaDAO.findOne(id);
    }
}