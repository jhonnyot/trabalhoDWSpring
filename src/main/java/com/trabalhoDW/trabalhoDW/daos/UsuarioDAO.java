/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.daos;

import com.trabalhoDW.trabalhoDW.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JP
 */
@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {
    @Query("SELECT u FROM Usuario u where u.nome = ?1")
    public Usuario buscarPorNome(String nome);
}
