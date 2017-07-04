/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.service;

import com.trabalhoDW.trabalhoDW.daos.HospedagemDAO;
import com.trabalhoDW.trabalhoDW.modelo.Hospedagem;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Salle
 */
@Service
public class HospedagemService {

    @Autowired
    private HospedagemDAO hospedagemDAO;

    public List<Hospedagem> buscarPorIdHospedeiro(int idHospedeiro) {
        return hospedagemDAO.buscarPorIdHospedeiro(idHospedeiro);
    }

    public Hospedagem salvar(Hospedagem h) {
        return hospedagemDAO.save(h);
    }
}
