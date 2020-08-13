package com.mtz.todolist.service;

import java.util.List;

import com.mtz.todolist.model.entidades.Usuario;

public interface UsuarioService {

    List<Usuario> findAll();

    Usuario findByid(long id);

    Usuario save(Usuario usuario);

    Long count();

    void delete(Usuario usuario);

    boolean existsById(long usuarioId);

    Usuario findByLogin(String login);

}