/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.controladores;

import com.trabalhoDW.trabalhoDW.modelo.Usuario;
import com.trabalhoDW.trabalhoDW.service.UsuarioService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Salle
 */
@Controller
public class LoginController extends HttpServlet {

    private boolean logado;
    @Autowired
    private UsuarioService usuarioService;

    public boolean isLogado() {
        return logado;
    }

    @PostMapping("/cabecalhoLogin")
    public ModelAndView logar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("userId"));
        String senha = request.getParameter("senha");

        Usuario user = usuarioService.buscarPorId(id);
        if (user != null && (senha == null ? user.getSenha() == null : senha.equals(user.getSenha()))) {
//            request.getSession().setAttribute("userId", user);
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home");
//            if (dispatcher != null) {
//                dispatcher.forward(request, response);
//                logado = true;
//            }
            ModelAndView mav = new ModelAndView("redirect:/home");
            mav.addObject("user", user.getNome());
            return mav;
        } else {
            String erro = "Login incorreto. Tente de novo... ";
//            request.setAttribute("erro", erro);
//
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index");
//            if (dispatcher != null) {
//                dispatcher.forward(request, response);
//                logado = false;
//            }
            return new ModelAndView("redirect:/erros");

        }
    }

}
