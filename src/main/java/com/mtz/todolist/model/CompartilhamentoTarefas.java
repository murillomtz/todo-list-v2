package com.mtz.todolist.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Entity
//@Table(name = "TB_COMPARTILHAMENTO")
public class CompartilhamentoTarefas implements Serializable {

    private static final long serialVersionUID = 1L;

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
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tarefa getTarefa() {
        return this.tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CompartilhamentoTarefas)) {
            return false;
        }
        CompartilhamentoTarefas compartilhamentoTarefas = (CompartilhamentoTarefas) o;
        return Objects.equals(usuario, compartilhamentoTarefas.usuario)
                && Objects.equals(tarefa, compartilhamentoTarefas.tarefa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, tarefa);
    }
}
