/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.daos;

import com.trabalhoDW.trabalhoDW.modelo.Nota;
import com.trabalhoDW.trabalhoDW.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author guilherme
 */
@Repository
public interface NotaDAO extends JpaRepository<Nota, Integer> {
    @Query("SELECT n FROM Nota n where n.usuario = ?1")
    public Nota getNotaUsuario(Usuario usuario);
}
