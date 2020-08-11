package com.mtz.todolist.service.serviceImp;

import java.util.List;

import com.mtz.todolist.model.CompartilhamentoTarefas;
import com.mtz.todolist.repository.CompartilhamentoRepository;
import com.mtz.todolist.service.CompartilhamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompartilhamentoServiceImp implements CompartilhamentoService {

    @Autowired
    CompartilhamentoRepository compartilhamentoRepository;

    @Override
    public List<CompartilhamentoTarefas> findAll() {
        return compartilhamentoRepository.findAll();
    }

    @Override
    public CompartilhamentoTarefas findByid(long id) {

        return compartilhamentoRepository.findById(id).get();
    }

    @Override
    public CompartilhamentoTarefas save(CompartilhamentoTarefas compartilhamentoTarefas) {

        return compartilhamentoRepository.save(compartilhamentoTarefas);
    }

    @Override
    public Long count() {

        return compartilhamentoRepository.count();
    }

    @Override
    public void delete(CompartilhamentoTarefas compartilhamentoTarefas) {
        compartilhamentoRepository.delete(compartilhamentoTarefas);

    }

    @Override
    public boolean existsById(long compartilhamentoTarefas) {

        return compartilhamentoRepository.existsById(compartilhamentoTarefas);
    }

}