/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.controladores;

import com.trabalhoDW.trabalhoDW.modelo.Papel;
import com.trabalhoDW.trabalhoDW.modelo.Usuario;
import com.trabalhoDW.trabalhoDW.service.UsuarioService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Salle
 */
@Controller
public class CadastroUserController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private LoginController loginController;

    @GetMapping("/sucessoCadastroUser")
    public ModelAndView sucessoCadastro() {
        ModelAndView modelAndView = new ModelAndView("sucessoCadastroUser");
        Usuario usuario = usuarioService.buscarPorId(usuarioService.retornaUltimoId());
        modelAndView.addObject("user", usuario.getId());
        modelAndView.addObject("isLogado", loginController.isLogado());
        return modelAndView;
    }

    @GetMapping("/cadastroUser")
    public ModelAndView mostraCadastroUsuario() {
        ModelAndView modelAndView = new ModelAndView("cadastroUser");
        modelAndView.addObject("userid", usuarioService.retornaUltimoId());
        modelAndView.addObject("isLogado", loginController.isLogado());
        return modelAndView;
    }   

    @PostMapping("/cadastroUser")
    public ModelAndView cadastroUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        response.setContentType("text/html;charset=UTF-8");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");
        String senha = request.getParameter("senha");

        boolean nomeIsValid = (nome != null && !nome.equals(""));
        boolean telefoneIsValid = (telefone != null && !telefone.equals(""));
        boolean emailIsValid = (email != null && !email.equals(""));
        boolean enderecoIsValid = (endereco != null && !endereco.equals(""));
        boolean senhaIsValid = (senha != null && !senha.equals(""));

        boolean cadastroIsValid = nomeIsValid && telefoneIsValid && emailIsValid && enderecoIsValid && senhaIsValid;

        if (cadastroIsValid) {
            Usuario usuario = new Usuario(telefone, endereco, email, nome, senha);
            usuarioService.salvaUsuario(usuario);
            return new ModelAndView("redirect:/sucessoCadastroUser");
        }
        return new ModelAndView("redirect:/erros");
    }
}
