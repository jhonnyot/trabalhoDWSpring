/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.service;

import com.trabalhoDW.trabalhoDW.modelo.Usuario;
import com.trabalhoDW.trabalhoDW.daos.UsuarioDAO;
import com.trabalhoDW.trabalhoDW.modelo.Papel;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author guilherme
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;
    @Autowired
    private PapelService papelService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<Usuario> listarTodos() {
        return usuarioDAO.findAll();
    }

    public Usuario buscarPorId(int id) {
        return usuarioDAO.findOne(id);
    }

    public void addAmigo(int idUsuario, int idAmigo) {
        usuarioDAO.addAmigo(idUsuario, idAmigo);
    }

    public void salvaUsuario(Usuario usuario) {
        usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
        usuario.setAtivo(1);
        Papel papel = papelService.buscarPorPapel("USER");
        usuario.setPapel(new HashSet<Papel>(Arrays.asList(papel)));
        usuarioDAO.saveAndFlush(usuario);
    }

    public boolean loginValido(int id, String senha) {
        if (usuarioDAO.login(id, senha) != null) {
            return true;
        }
        return false;
    }
    public Usuario buscarPorNome(String nome){
        return usuarioDAO.buscarPorNome(nome);
    }
    public int retornaUltimoId() {
        if (!usuarioDAO.retornaListaOrdenadoPorId().isEmpty()) {
            return usuarioDAO.retornaListaOrdenadoPorId().get(0).getId();
        } else {
            return -1;
        }
    }

}
