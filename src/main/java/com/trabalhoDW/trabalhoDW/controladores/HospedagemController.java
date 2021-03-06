/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.controladores;

import com.trabalhoDW.trabalhoDW.modelo.Hospedagem;
import com.trabalhoDW.trabalhoDW.modelo.Nota;
import com.trabalhoDW.trabalhoDW.modelo.Usuario;
import com.trabalhoDW.trabalhoDW.service.HospedagemService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Salle
 */
@Controller
public class HospedagemController {

    @Autowired
    private HospedagemService hospedagemService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private NotaService notaService;

    @GetMapping("/hospedeiro")
    public ModelAndView hospedeiroGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usr = usuarioService.buscarPorId(Integer.parseInt(auth.getName()));
        List<Hospedagem> solicitacoes = hospedagemService.buscarPorIdHospedeiro(usr.getId());
        ModelAndView mav = new ModelAndView("hospedeiro");
        mav.addObject("lista", solicitacoes);
        return mav;
    }

    @GetMapping("/hospedagensAceitas")
    public ModelAndView hospedagensAceitasGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usr = usuarioService.buscarPorId(Integer.parseInt(auth.getName()));
        List<Hospedagem> solicitacoes = hospedagemService.buscarPorIdHospedeiro(usr.getId());
        ModelAndView mav = new ModelAndView("hospedagensAceitas");
        mav.addObject("lista", solicitacoes);
        return mav;
    }

    @PostMapping("/hospedagensAceitas")
    public ModelAndView avaliacao(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usr = usuarioService.buscarPorId(Integer.parseInt(auth.getName()));
        String notaHospedagem = request.getParameter("notaHospedagem");
        int hospId = Integer.parseInt(request.getParameter("hospedagemId"));
        Hospedagem h = hospedagemService.buscarPorId(hospId);
        Usuario user = usuarioService.buscarPorId(h.getIdHospede());
        Nota nota = usuarioService.buscaNotas(user.getId());
        if (user != null) {
            if (!notaHospedagem.equals("")) {
                nota.addNotaHospedagem(Long.parseLong(notaHospedagem));
                h.setAvaliado(true);
            }
            notaService.salvaNota(nota);

            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("redirect:/erros");
    }

    @PostMapping("/hospedeiro")
    public ModelAndView hospedeiroPost(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Hospedagem h = hospedagemService.buscarPorId(Integer.parseInt(request.getParameter("hospedagemId")));
        h.setAprovado(true);
        hospedagemService.salvar(h);
        ModelAndView mav = new ModelAndView("redirect:/hospedeiro");
        return mav;
    }

    @GetMapping("/hospedagem")
    public ModelAndView hospedagemGet() {
        ModelAndView mav = new ModelAndView("hospedagem");
        return mav;
    }

    @PostMapping(value = "/hospedagem", params = {"numeroHospedes", "numeroEsportistas", "dataInicial", "dataFinal", "nomeHospedeiro"})
    public ModelAndView hospedagemPost(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        int numeroHospedes = Integer.parseInt(request.getParameter("numeroHospedes"));
        int numeroEsportistas = Integer.parseInt(request.getParameter("numeroEsportistas"));
        Date dataInicial = new Date(request.getParameter("dataInicial"));
        Date dataFinal = new Date(request.getParameter("dataFinal"));
        String nomeHospedeiro = request.getParameter("nomeHospedeiro");
        Usuario u = usuarioService.buscarPorNome(nomeHospedeiro);
        Hospedagem hospedagem = new Hospedagem(numeroHospedes, numeroEsportistas, dataInicial, dataFinal);
        hospedagem.setIdHospedeiro(u.getId());
        hospedagem.setIdHospede(Integer.parseInt(auth.getName()));
        hospedagemService.salvar(hospedagem);
        ModelAndView mav = new ModelAndView("redirect:/home");
        return mav;
    }

    @PostMapping(value = "/hospedagem", params = "cidade")
    public ModelAndView buscaHospedagemPorCidadePost(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String cidade = request.getParameter("cidade");
        List<Usuario> usuariosPorCidade = usuarioService.listarPorCidade(cidade);
        ModelAndView mav = new ModelAndView();
        mav.addObject("usuariosPorCidade", usuariosPorCidade);
        mav.addObject("meuId", auth.getName());
        return mav;
    }

}
