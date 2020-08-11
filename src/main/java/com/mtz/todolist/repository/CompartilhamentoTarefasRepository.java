package com.mtz.todolist.repository;

import com.mtz.todolist.model.CompartilhamentoTarefas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompartilhamentoTarefasRepository extends JpaRepository<CompartilhamentoTarefas, Long> {

}