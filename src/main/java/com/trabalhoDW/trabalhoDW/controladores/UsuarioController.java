/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.controladores;

import com.trabalhoDW.trabalhoDW.modelo.Usuario;
import com.trabalhoDW.trabalhoDW.service.UsuarioService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author guilherme
 */
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    private int usrToAdd;

    @RequestMapping("/usuario")
    public Usuario usuario(@RequestParam(value = "id", defaultValue = "0") int id) {
        return usuarioService.buscarPorId(id);
    }

    @RequestMapping("/buscar")
    public ModelAndView buscar(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usr = usuarioService.buscarPorId(Integer.parseInt(auth.getName()));
        String nome = request.getParameter("nome");
        Usuario usuario = usuarioService.buscarPorNome(nome);
        ModelAndView mav = new ModelAndView();
        mav.addObject("usrName", "Olá, " + usr.getNome() + "!");
        if (usuario == null) {
            mav.addObject("notFound", true);
            return mav;
        } else {
            mav.addObject("usuario", usuario);
            mav.addObject("notFound", false);
            this.usrToAdd = usuario.getId();
        }
        return mav;
    }
    
    @PostMapping("/addAmg")
    public ModelAndView addAmg() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usr = usuarioService.buscarPorId(Integer.parseInt(auth.getName()));
        usuarioService.addAmigo(usr.getId(), usrToAdd);
        return new ModelAndView("redirect:/amigos");
    }

}
