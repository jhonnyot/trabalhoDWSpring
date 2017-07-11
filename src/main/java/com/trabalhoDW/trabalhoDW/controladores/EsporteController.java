/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.controladores;

import com.trabalhoDW.trabalhoDW.modelo.Esporte;
import com.trabalhoDW.trabalhoDW.modelo.Nota;
import com.trabalhoDW.trabalhoDW.modelo.Usuario;
import com.trabalhoDW.trabalhoDW.service.EsporteService;
import com.trabalhoDW.trabalhoDW.service.NotaService;
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
    @Autowired
    private NotaService notaService;

    @GetMapping("/solicitacoesEsporte")
    public ModelAndView solicitacoesGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usr = usuarioService.buscarPorId(Integer.parseInt(auth.getName()));
        List<Esporte> solicitacoes = esporteService.listarPorIdSolicitado(usr.getId());
        ModelAndView mav = new ModelAndView("solicitacoesEsporte");
        mav.addObject("lista", solicitacoes);
        return mav;
    }

    @PostMapping("/esportesAceitos")
    public ModelAndView avaliacao(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usr = usuarioService.buscarPorId(Integer.parseInt(auth.getName()));
        String notaEsporte = request.getParameter("notaEsporte");
        String usuario = request.getParameter("username");
        Usuario user = usuarioService.buscarPorNome(usuario);
        Nota nota = usuarioService.buscaNotas(usr.getId());
        if (user != null) {
            if (!notaEsporte.equals("")) {
                nota.addNotaEsporte(Long.parseLong(notaEsporte));
            }
            notaService.salvaNota(nota);

            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("redirect:/erros");
    }


    @GetMapping("/esportesAceitos")
    public ModelAndView esportesAceitosGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usr = usuarioService.buscarPorId(Integer.parseInt(auth.getName()));
        List<Esporte> solicitacoes = esporteService.listarPorIdSolicitado(usr.getId());
        ModelAndView mav = new ModelAndView("esportesAceitos");
        mav.addObject("lista", solicitacoes);
        return mav;
    }

    @PostMapping("/solicitacoesEsporte")
    public ModelAndView solicitacoesPost(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Esporte e = esporteService.buscarPorId(Integer.parseInt(request.getParameter("EsporteId")));
        e.setAprovado(true);
        esporteService.salvar(e);
        ModelAndView mav = new ModelAndView("solicitacoesEsporte");
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
        int idSolicitado = u.getId();
        Esporte esporte = new Esporte(dataInicial, idSolicitante, idSolicitado);
        esporteService.salvar(esporte);
        ModelAndView mav = new ModelAndView("home");
        return mav;
    }
}
