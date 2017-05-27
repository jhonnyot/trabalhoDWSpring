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
    
public List<Usuario> listarTodos(){
    return usuarioDAO.findAll();
}
public Usuario buscarPorId(int id){
    return usuarioDAO.findOne(id);
}
public void salvaUsuario(Usuario usuario){
    usuarioDAO.save(usuario);
}    


}
