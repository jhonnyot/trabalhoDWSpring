/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.service;

import com.trabalhoDW.trabalhoDW.daos.NotaDAO;
import com.trabalhoDW.trabalhoDW.modelo.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author guilherme
 */
@Service
public class NotaService {

    @Autowired
    private NotaDAO notaDAO;
    @Autowired
    private UsuarioService usuarioService;

    public Nota notaPorUsuario(int idUsuario) {
        Nota nota = notaDAO.getNotaUsuario(usuarioService.buscarPorId(idUsuario));
        return nota;
    }

    public Nota notaPorId(int idNota) {
        Nota nota = notaDAO.findOne(idNota);
        return nota;
    }

    public void salvaNota(Nota nota) {
        notaDAO.saveAndFlush(nota);
    }
}
