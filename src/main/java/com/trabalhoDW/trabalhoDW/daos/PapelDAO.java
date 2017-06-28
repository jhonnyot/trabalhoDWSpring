/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.daos;
import com.trabalhoDW.trabalhoDW.modelo.Papel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Salle
 */
@Repository
public interface PapelDAO extends JpaRepository<Papel, Integer> {
    
    @Query("SELECT p from Papel p where p.papel=?1")
    public Papel buscarPorPapel(String papel);
}
