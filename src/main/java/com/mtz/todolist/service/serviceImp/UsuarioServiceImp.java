package com.mtz.todolist.service.serviceImp;

import java.util.List;

import com.mtz.todolist.model.Usuario;
import com.mtz.todolist.repository.UsuarioRepository;
import com.mtz.todolist.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findByid(long id) {
        return usuarioRepository.findById(id).get();
    }

    @Override
    public Usuario save(Usuario tarefa) {

        return usuarioRepository.save(tarefa);
    }

    @Override
    public Long count() {
        return usuarioRepository.count();
    }

    @Override
    public void delete(Usuario tarefa) {
        usuarioRepository.delete(tarefa);

    }

    @Override
    public boolean existsById(long tarefaId) {
        return usuarioRepository.existsById(tarefaId);
    }

}
