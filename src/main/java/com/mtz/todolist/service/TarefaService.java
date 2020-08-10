package com.mtz.todolist.service;

import java.util.List;

import com.mtz.todolist.model.Tarefa;

public interface TarefaService {

    List<Tarefa> findAll();

    Tarefa findByid(long id);

    Tarefa save(Tarefa tarefa);

    Long count();

    void delete(Tarefa tarefa);

    boolean existsById(long tarefaId);

}