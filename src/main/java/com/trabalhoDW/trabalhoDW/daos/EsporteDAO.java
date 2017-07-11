/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.daos;

import com.trabalhoDW.trabalhoDW.modelo.Esporte;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author guilherme
 */
@Repository
public interface EsporteDAO extends JpaRepository<Esporte, Integer> {

    @Query("SELECT e from Esporte e where e.idSolicitado = ?1")
    public List<Esporte> buscarPorIdSolicitado(int idSolicitado);
    

}
