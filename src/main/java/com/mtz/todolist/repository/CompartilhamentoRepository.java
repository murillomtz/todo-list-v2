package com.mtz.todolist.repository;

import com.mtz.todolist.model.CompartilhamentoTarefas;
import com.mtz.todolist.model.Tarefa;
import com.mtz.todolist.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompartilhamentoRepository extends JpaRepository<CompartilhamentoTarefas, Long> {

}