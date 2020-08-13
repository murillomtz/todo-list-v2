package com.mtz.todolist.service.serviceImp;

import com.mtz.todolist.model.entidades.CompartilhamentoTarefas;
import com.mtz.todolist.repository.CompartilhamentoTarefasRepository;
import com.mtz.todolist.service.CompartilhamentoTarefasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompartilhamentoTarefasServiceImp implements CompartilhamentoTarefasService {

    @Autowired
    CompartilhamentoTarefasRepository compartilhamentoRepository;

    @Override
    public List<CompartilhamentoTarefas> findAll() {
        return compartilhamentoRepository.findAll();
    }

    @Override
    public CompartilhamentoTarefas findByid(long id) {
        return compartilhamentoRepository.findById(id).get();
    }

    @Override
    public CompartilhamentoTarefas save(CompartilhamentoTarefas compartilhamento) {

        return compartilhamentoRepository.save(compartilhamento);
    }

    @Override
    public Long count() {
        return compartilhamentoRepository.count();
    }

    @Override
    public void delete(CompartilhamentoTarefas compartilhamento) {
        compartilhamentoRepository.delete(compartilhamento);

    }

    @Override
    public boolean existsById(long compartilhamentoId) {
        return compartilhamentoRepository.existsById(compartilhamentoId);
    }

}
