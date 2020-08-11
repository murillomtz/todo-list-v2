package com.mtz.todolist.utils;

import com.mtz.todolist.model.CompartilhamentoTarefas;
import com.mtz.todolist.model.Tarefa;
import com.mtz.todolist.model.Usuario;
import com.mtz.todolist.repository.CompartilhamentoTarefasRepository;
import com.mtz.todolist.repository.TarefaRepository;
import com.mtz.todolist.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    private final TarefaRepository tarefaRepository;

    private final UsuarioRepository usuarioRepository;

    private final CompartilhamentoTarefasRepository compartilhamentoRepository;

    public DummyData(TarefaRepository tarefaRepository, UsuarioRepository usuarioRepository, CompartilhamentoTarefasRepository compartilhamentoRepository) {
        this.tarefaRepository = tarefaRepository;
        this.usuarioRepository = usuarioRepository;
        this.compartilhamentoRepository = compartilhamentoRepository;
    }

    @PostConstruct
    public void savePosts() {

        List<Usuario> usuarios = new ArrayList<>();
        Usuario user1 = new Usuario(null, "mtz1", "Murillo", "murillo@gmail.com", "123", true);
        user1.setAdm(true);
        Usuario user2 = new Usuario(null, "mtz2", "Lavinha", "lavinha@gmail.com", "123", true);
        Usuario user3 = new Usuario(null, "mtz3", "Arthur", "arthur@gmail.com", "123", false);
        Usuario user4 = new Usuario(null, "mtz4", "Kaca", "kace@gmail.com", "123", true);
        Usuario user5 = new Usuario(null, "mtz5", "Olivia", "olivia@gmail.com", "123", false);

        List<Tarefa> tarefas = new ArrayList<>();
        Tarefa t1 = new Tarefa(null, "Tarefa 1", "Descrição da tarefa 1", LocalDate.now(), false, user1);
        Tarefa t2 = new Tarefa(null, "Tarefa 2", "Descrição da tarefa 2", LocalDate.now(), true, user1);
        Tarefa t3 = new Tarefa(null, "Tarefa 3", "Descrição da tarefa 3", LocalDate.now(), false, user2);
        Tarefa t4 = new Tarefa(null, "Tarefa 4", "Descrição da tarefa 4", LocalDate.now(), true, user3);
        Tarefa t5 = new Tarefa(null, "Tarefa 5", "Descrição da tarefa 5", LocalDate.now(), false, user4);

        List<CompartilhamentoTarefas> compartilhamentos = new ArrayList<>();
        CompartilhamentoTarefas ct1 = new CompartilhamentoTarefas(null, user1, t1);
        CompartilhamentoTarefas ct2 = new CompartilhamentoTarefas(null, user1, t2);
        CompartilhamentoTarefas ct3 = new CompartilhamentoTarefas(null, user2, t3);
        CompartilhamentoTarefas ct4 = new CompartilhamentoTarefas(null, user3, t4);
        CompartilhamentoTarefas ct5 = new CompartilhamentoTarefas(null, user4, t5);

        compartilhamentos.add(ct1);
        compartilhamentos.add(ct2);
        compartilhamentos.add(ct3);
        compartilhamentos.add(ct4);
        compartilhamentos.add(ct5);

        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);
        usuarios.add(user4);
        usuarios.add(user5);

        tarefas.add(t1);
        tarefas.add(t2);
        tarefas.add(t3);
        tarefas.add(t4);
        tarefas.add(t5);

        for (Usuario user : usuarios) {
            Usuario postSaved = usuarioRepository.save(user);
            System.out.println(postSaved.getId());
        }

        for (Tarefa task : tarefas) {
            Tarefa ps = tarefaRepository.save(task);
            System.out.println(ps.getId());
        }

        for (CompartilhamentoTarefas task : compartilhamentos) {
            CompartilhamentoTarefas ps = compartilhamentoRepository.save(task);
            System.out.println(ps.getId());
        }

    }

}