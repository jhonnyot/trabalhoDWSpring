/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.controladores;

import com.trabalhoDW.trabalhoDW.modelo.Usuario;
import com.trabalhoDW.trabalhoDW.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JP
 */
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/usuarios")
    public void usuarios() {

        Usuario u1 = new Usuario();
        Usuario u2 = new Usuario();
        Usuario u3 = new Usuario();
        Usuario u4 = new Usuario();

        u1.setNome("Guilherme");
        u2.setNome("Joao");
        u3.setNome("Campos");
        u4.setNome("Salle");

        usuarioService.salvaUsuario(u1);
        usuarioService.salvaUsuario(u2);
        usuarioService.salvaUsuario(u3);
        usuarioService.salvaUsuario(u4);

        List<Usuario> users = usuarioService.listarTodos();
        for (Usuario u : users) {
            string(u);
        }
    }

    public String string(Usuario u) {
        return u.getNome();
    }

    @RequestMapping("/usuario")
    public Usuario usuario(@RequestParam(value = "id", defaultValue = "0") int id) {
        return usuarioService.buscarPorId(id);
    }

}
