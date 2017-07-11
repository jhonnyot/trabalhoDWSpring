/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.controladores;

import com.trabalhoDW.trabalhoDW.modelo.Esporte;
import com.trabalhoDW.trabalhoDW.modelo.Hospedagem;
import com.trabalhoDW.trabalhoDW.modelo.Usuario;
import com.trabalhoDW.trabalhoDW.service.EsporteService;
import com.trabalhoDW.trabalhoDW.service.UsuarioService;
import java.util.Date;
import java.util.List;
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
 * @author guilherme
 */
@Controller
public class EsporteController {

    @Autowired
    private EsporteService esporteService;
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/solicitacoesEsporte")
    public ModelAndView solicitacoesGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usr = usuarioService.buscarPorId(Integer.parseInt(auth.getName()));
        List<Esporte> solicitacoes = esporteService.listarPorIdSolicitado(usr.getId());
        ModelAndView mav = new ModelAndView("solicitacoesEsporte");
        mav.addObject("lista", solicitacoes);
        return mav;
    }

    @PostMapping("/aceitar")
    public ModelAndView solicitacoesPost(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Esporte e = esporteService.buscarPorId(Integer.parseInt(request.getParameter("solicitacaoId")));
        e.setAprovado(true);
        esporteService.salvar(e);
        ModelAndView mav = new ModelAndView("redirect:/solicitacoesEsporte");
        return mav;
    }

    @GetMapping("/solicitaEsporte")
    public ModelAndView solicitaGet() {
        ModelAndView mav = new ModelAndView("solicitaEsporte");
        return mav;
    }

    @PostMapping("/solicitaEsporte")
    public ModelAndView solicitaPost(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String nomeAlvo = request.getParameter("nomeAlvo");
        Date dataInicial = new Date(request.getParameter("dataInicial"));
        Usuario u = usuarioService.buscarPorNome(nomeAlvo);
        int idSolicitante = usuarioService.buscarPorId(Integer.parseInt(auth.getName())).getId();
        String nomeSolicitante = usuarioService.buscarPorId(idSolicitante).getNome();
        int idSolicitado = u.getId();
        Esporte esporte = new Esporte(dataInicial, idSolicitante, idSolicitado, nomeSolicitante);
        esporteService.salvar(esporte);
        ModelAndView mav = new ModelAndView("redirect:/home");
        return mav;
    }
}
