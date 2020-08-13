package com.mtz.todolist.service;

import com.mtz.todolist.model.entidades.CompartilhamentoTarefas;

import java.util.List;

public interface CompartilhamentoTarefasService {

    List<CompartilhamentoTarefas> findAll();

    CompartilhamentoTarefas findByid(long id);

    CompartilhamentoTarefas save(CompartilhamentoTarefas compartilhamentoTarefas);

    Long count();

    void delete(CompartilhamentoTarefas compartilhamentoTarefas);

    boolean existsById(long compartilhamentoTarefasId);

}