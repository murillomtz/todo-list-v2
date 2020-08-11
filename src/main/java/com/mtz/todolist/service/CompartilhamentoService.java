package com.mtz.todolist.service;

import java.util.List;

import com.mtz.todolist.model.CompartilhamentoTarefas;

public interface CompartilhamentoService {

    List<CompartilhamentoTarefas> findAll();

    CompartilhamentoTarefas findByid(long id);

    CompartilhamentoTarefas save(CompartilhamentoTarefas compartilhamentoTarefas);

    Long count();

    void delete(CompartilhamentoTarefas compartilhamentoTarefas);

    boolean existsById(long compartilhamentoTarefas);
}