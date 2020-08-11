package com.mtz.todolist.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_COMPARTILHAMENTO")
public class CompartilhamentoTarefas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "tarefa_id")
    private Tarefa tarefa;

    public CompartilhamentoTarefas() {
    }

    public CompartilhamentoTarefas(Long id, Usuario usuario, Tarefa tarefa) {
        this.id = id;
        this.usuario = usuario;
        this.tarefa = tarefa;
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }
}
