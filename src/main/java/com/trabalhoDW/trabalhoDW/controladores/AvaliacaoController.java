/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.controladores;

import com.trabalhoDW.trabalhoDW.modelo.Usuario;
import com.trabalhoDW.trabalhoDW.service.NotaService;
import com.trabalhoDW.trabalhoDW.service.UsuarioService;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Salle
 */
public class AvaliacaoController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private NotaService notaService;

    @GetMapping("/avaliacoes")
    public ModelAndView mostraPagAvaliacao() {
        ModelAndView mav = new ModelAndView("avaliacoes");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usr = usuarioService.buscarPorId(Integer.parseInt(auth.getName()));
        return mav;
    }

    @PostMapping("/avaliacoes")
    public ModelAndView avaliacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usr = usuarioService.buscarPorId(Integer.parseInt(auth.getName()));
        response.setContentType("text/html;charset=UTF-8");
        String notaHospedagem = request.getParameter("notaHospedagem");
        String notaEsporte = request.getParameter("notaEsporte");
        String notaConhecido = request.getParameter("notaConhecido");
        String usuario = request.getParameter("username");
        Usuario user = usuarioService.buscarPorNome(usuario);
        if (user != null) {
            if (!notaConhecido.equals("")) {
                usuarioService.buscaNotas().addNotaConhecido(Long.parseLong(notaConhecido));
            }
            if (!notaHospedagem.equals("")) {
                usuarioService.buscaNotas().addNotaHospedagem(Long.parseLong(notaHospedagem));
            }
            if (!notaEsporte.equals("")) {
                usuarioService.buscaNotas().addNotaEsporte(Long.parseLong(notaEsporte));
            }
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("redirect:/erros");
    }

}
