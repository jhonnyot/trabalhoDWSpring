/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.controladores;

import com.trabalhoDW.trabalhoDW.modelo.Hospedagem;
import com.trabalhoDW.trabalhoDW.modelo.Usuario;
import com.trabalhoDW.trabalhoDW.service.HospedagemService;
import com.trabalhoDW.trabalhoDW.service.UsuarioService;
import java.util.Calendar;
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
 * @author Salle
 */
@Controller
public class HospedagemController {

    @Autowired
    private HospedagemService hospedagemService;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/hospedeiro")
    public ModelAndView hospedeiroGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usuario usr = usuarioService.buscarPorId(Integer.parseInt(auth.getName()));
        Date dataInicial = new Date();
        Date dataFinal = new Date();
        dataInicial = Calendar.getInstance().getTime();
        dataFinal = Calendar.getInstance().getTime();
        Hospedagem hosp1 = new Hospedagem();
        hosp1.setDataInicial(dataInicial);
        hosp1.setDataFinal(dataFinal);
        hosp1.setIdHospedeiro(usr.getId());
        hosp1.setNumeroEsportistas(5);
        hosp1.setNumeroHospedes(5);
        hospedagemService.salvar(hosp1);        
        
        List<Hospedagem> solicitacoes = hospedagemService.buscarPorIdHospedeiro(usr.getId());
        ModelAndView mav = new ModelAndView("hospedeiro");
        mav.addObject("lista", solicitacoes);
        return mav;
    }

//    @PostMapping("/aceitar")
//    public ModelAndView hospedeiroPost(HttpServletRequest request, HttpServletResponse response) {
//
//    }
    @GetMapping("/hospedagem")
    public ModelAndView hospedagemGet() {
        return null;
    }

    @PostMapping("/hospedagem")
    public ModelAndView hospedagemPost(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

}
