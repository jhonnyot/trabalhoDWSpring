/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.controladores;

import com.trabalhoDW.trabalhoDW.modelo.Usuario;
import com.trabalhoDW.trabalhoDW.service.NotaService;
import com.trabalhoDW.trabalhoDW.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author guilherme
 */
@Controller
public class HomeController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private NotaService notaService;
    
    @RequestMapping(value = {"/index", "/", ""})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("home");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usr = usuarioService.buscarPorId(Integer.parseInt(auth.getName()));
        mav.addObject("userName", "Bem-vindo, " + usr.getNome() + "!");
        mav.addObject("notaHospedagem", "Nota de Hospedagem: " + usuarioService.buscaNotas(usr.getId()).getNotaHospedagem());
        mav.addObject("notaAmigo", "Nota de Conhecidos: " + usuarioService.buscaNotas(usr.getId()).getNotaConhecido());
        mav.addObject("notaEsporte", "Nota de Prática Esportiva: " + usuarioService.buscaNotas(usr.getId()).getNotaEsporte());
        mav.setViewName("/home");
        return mav;
    }

}
