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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author JP
 */
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
//    @RequestMapping("/usuarios")
//    public List<Usuario> usuarios() {
//        testeHibernate();
//        return usuarioService.listarTodos();
//    }
    
    @GetMapping("/usuarios")
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("usuarios");
        modelAndView.addObject("usuarios", usuarioService.listarTodos());
        modelAndView.addObject(new Usuario());
        return modelAndView;
    }
    @PostMapping("/usuarios")
	public String salvar(Usuario usuario) {
		this.usuarioService.salvaUsuario(usuario);
		return "redirect:/convidados";
	}


    public void testeHibernate() {

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
//
//        u1.inicializaAmigos();
//        u2.inicializaAmigos();
//        u3.inicializaAmigos();
//        u4.inicializaAmigos();
//        
//        usuarioService.addAmigo(u1.getId(), u2);
//        usuarioService.addAmigo(u2.getId(), u3);
//        usuarioService.addAmigo(u3.getId(), u4);

    }

    @RequestMapping("/usuario")
    public Usuario usuario(@RequestParam(value = "id", defaultValue = "0") int id) {
        return usuarioService.buscarPorId(id);
    }

}
