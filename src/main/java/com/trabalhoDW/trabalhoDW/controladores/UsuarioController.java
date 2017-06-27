/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.controladores;

import com.trabalhoDW.trabalhoDW.modelo.Usuario;
import com.trabalhoDW.trabalhoDW.service.UsuarioService;
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
public class UsuarioController  {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/usuarios")
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("usuarios");
        modelAndView.addObject(new Usuario());
        return modelAndView;
    }
  
    @PostMapping("/usuarios")
    public String salvar(Usuario usuario) {
        this.usuarioService.salvaUsuario(usuario);
        return "redirect:/convidados";
    }

    @RequestMapping("/usuario")
    public Usuario usuario(@RequestParam(value = "id", defaultValue = "0") int id) {
        return usuarioService.buscarPorId(id);
    }

}
