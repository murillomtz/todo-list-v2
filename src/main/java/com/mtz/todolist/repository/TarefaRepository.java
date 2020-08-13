package com.mtz.todolist.repository;

import com.mtz.todolist.model.entidades.Tarefa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}