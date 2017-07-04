/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.daos;

import com.trabalhoDW.trabalhoDW.modelo.Hospedagem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Salle
 */
@Repository
public interface HospedagemDAO extends JpaRepository<Hospedagem, Integer> {

    @Query("SELECT h from Hospedagem h where h.idHospedeiro = ?1")
    public List<Hospedagem> buscarPorIdHospedeiro(int idHospedeiro);
}
