/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.controladores;

import com.trabalhoDW.trabalhoDW.modelo.Nota;
import com.trabalhoDW.trabalhoDW.modelo.Usuario;
import com.trabalhoDW.trabalhoDW.service.NotaService;
import com.trabalhoDW.trabalhoDW.service.UsuarioService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Salle
 */
@Controller
public class AmigosController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private NotaService notaService;

    @GetMapping("/amigos")
    public ModelAndView amigos() {
        ModelAndView mav = new ModelAndView("amigos");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usr = usuarioService.buscarPorId(Integer.parseInt(auth.getName()));
        mav.addObject("amigos", usr.getAmigos());
        return mav;
    }

    @PostMapping("/amigos")
    public ModelAndView avaliacao(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario avaliador = usuarioService.buscarPorId(Integer.parseInt(auth.getName()));
        String notaConhecido = request.getParameter("notaConhecido");
        String usuario = request.getParameter("username");
        Usuario avaliado = usuarioService.buscarPorNome(usuario);
        Nota nota = usuarioService.buscaNotas(avaliado.getId());

        if (avaliado != null) {
            if (!notaConhecido.equals("")) {
                nota.addNotaConhecido(Long.parseLong(notaConhecido));
                avaliado.setAvaliado(true);
            }
            notaService.salvaNota(nota);

            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("redirect:/erros");
    }
}
