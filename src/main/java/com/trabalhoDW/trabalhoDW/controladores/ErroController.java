/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Salle
 */
@Controller
public class ErroController {
    @Autowired
    private LoginController loginController;
    @RequestMapping("/erros")
    public ModelAndView erro(){
        ModelAndView modelAndView = new ModelAndView("erros");
        modelAndView.addObject("isLogado", loginController.isLogado());
        return modelAndView;
    }
}
