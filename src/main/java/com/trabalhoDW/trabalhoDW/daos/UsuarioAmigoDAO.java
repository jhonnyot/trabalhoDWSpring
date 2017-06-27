///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.trabalhoDW.trabalhoDW.daos;
//
//import com.trabalhoDW.trabalhoDW.modelo.Usuario;
//import java.io.Serializable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
///**
// *
// * @author guilherme
// */
//@Repository
//public interface UsuarioAmigoDAO extends JpaRepository<Usuario, Integer>{
//    
//    @Query("update usuario_amigos u set u.usuario_id= ?1 where u.amigos_id = ?2")
//    public void adicionaAmigos(int idUsuario, int idAmigo);
//}
