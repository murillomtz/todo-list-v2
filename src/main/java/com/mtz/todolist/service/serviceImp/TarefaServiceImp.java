package com.mtz.todolist.service.serviceImp;

import java.util.List;

import com.mtz.todolist.model.entidades.Tarefa;
import com.mtz.todolist.repository.TarefaRepository;
import com.mtz.todolist.service.TarefaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaServiceImp implements TarefaService {

    @Autowired
    TarefaRepository tarefaRepository;

    @Override
    public List<Tarefa> findAll() {
        return tarefaRepository.findAll();
    }

    @Override
    public Tarefa findByid(long id) {
        return tarefaRepository.findById(id).get();
    }

    @Override
    public Tarefa save(Tarefa tarefa) {

        return tarefaRepository.save(tarefa);
    }

    @Override
    public Long count() {
        return tarefaRepository.count();
    }

    @Override
    public void delete(Tarefa tarefa) {
        tarefaRepository.delete(tarefa);

    }

    @Override
    public boolean existsById(long tarefaId) {
        return tarefaRepository.existsById(tarefaId);
    }

}