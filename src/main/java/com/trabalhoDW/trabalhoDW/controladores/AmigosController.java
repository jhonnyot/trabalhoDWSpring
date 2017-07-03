/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.controladores;

import com.trabalhoDW.trabalhoDW.modelo.Usuario;
import com.trabalhoDW.trabalhoDW.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Salle
 */
@Controller
public class AmigosController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/amigos")
    public ModelAndView amigos() {
        ModelAndView mav = new ModelAndView("amigos");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usr = usuarioService.buscarPorId(Integer.parseInt(auth.getName()));
//        int i = 0;
//        for (Usuario user : usr.getAmigos()) {
//            String nomeAmigos = "Usr";
//            mav.addObject(nomeAmigos.concat(Integer.toString(i)), user.getNome());
//            i++;
//        }
//        mav.addObject("qtdAmigos", i);
        mav.addObject("amigos", usr.getAmigos());
        return mav;
    }
}
