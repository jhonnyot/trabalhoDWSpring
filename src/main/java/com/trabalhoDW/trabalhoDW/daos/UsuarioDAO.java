/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trabalhoDW.trabalhoDW.daos;

import com.trabalhoDW.trabalhoDW.modelo.Nota;
import com.trabalhoDW.trabalhoDW.modelo.Usuario;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
    
    @Query("SELECT n from Usuario u, Nota n where n.id = u.nota and u.id = ?1")
    public Nota buscaNotas(int idUser);
    
    @Query("SELECT u from Usuario u where u.cidade like %?1%")
    public List<Usuario> listarPorCidade(String cidade);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO usuario_amigos(usuario_usuario_id, amigos_usuario_id) values(?1,?2)", nativeQuery = true)
    public void addAmigo(int idUsuario, int idAmigo);
}
