/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.service;

import com.trabalhoDW.trabalhoDW.modelo.Usuario;
import com.trabalhoDW.trabalhoDW.daos.UsuarioDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JP
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    public List<Usuario> listarTodos() {
        return usuarioDAO.findAll();
    }

    public Usuario buscarPorId(int id) {
        return usuarioDAO.findOne(id);
    }

    public void addAmigo(int idUsuario, Usuario amigo) {
        Usuario usuario = buscarPorId(idUsuario);
        usuario.adicionaAmigo(amigo);
    }

    public void salvaUsuario(Usuario usuario) {
        usuarioDAO.saveAndFlush(usuario);
    }

    public boolean loginValido(int id, String senha) {
        if (usuarioDAO.login(id, senha) != null) {
            return true;
        }
        return false;
    }

    public int retornaId() {
        if (!usuarioDAO.retornaId().isEmpty()) {
            return usuarioDAO.retornaId().get(0).getId();
        } else {
            return -1;
        }
    }

}
