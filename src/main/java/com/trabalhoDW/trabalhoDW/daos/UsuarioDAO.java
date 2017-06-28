/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.daos;

import com.trabalhoDW.trabalhoDW.modelo.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {

    @Query("SELECT u FROM Usuario u where u.nome = ?1")
    public Usuario buscarPorNome(String nome);

    @Query("SELECT u FROM Usuario u where u.id = ?1 and u.senha = ?2")
    public Usuario login(int id, String senha);

    @Query("SELECT u FROM Usuario u ORDER BY u.id DESC")
    public List<Usuario> retornaListaOrdenadoPorId();

    @Query(nativeQuery = true, value = "INSERT into usuario_amigos(usuario_id, amigos_id) values(?1,?2)")
    public void addAmigo(int idUsuario, int idAmigo);
}
