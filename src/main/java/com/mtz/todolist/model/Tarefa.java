package com.mtz.todolist.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "TB_TAREFA")
public class Tarefa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate data;

    private Boolean concluida;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // @ElementCollection(fetch = FetchType.EAGER) // GARATIA Q QUANDO BUSCAR OS
    // CLIENTES NO BD, SEJA BUSCADO O PERFIL
    @ElementCollection
    @CollectionTable(name = "COMPARTILHAMENTOS")
    // @JoinColumn(name = "TAREFA_ID") */) // CRIA UMA TABELA
    // COM O ID E
    // ID_USUARIO
    // @Column(name = "COMP")

    // @JoinTable(name = "COMPARTILHAMENTOS", joinColumns = @JoinColumn(name =
    // "TAREFA_ID"), inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private Set<Long> compartilhamentos = new HashSet<>();

    public Tarefa() {
    }

    public Tarefa(Long id, String titulo, String descricao, LocalDate data, Boolean concluida) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.concluida = concluida;
    }

    public Tarefa(Long id, String titulo, String descricao, LocalDate data, Boolean concluida, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.concluida = concluida;
        this.usuario = usuario;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Boolean isConcluida() {
        return this.concluida;
    }

    public Boolean getConcluida() {
        return this.concluida;
    }

    public void setConcluida(Boolean concluida) {
        this.concluida = concluida;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Long> getCompartilhamentos() {
        return this.compartilhamentos;
    }

    public void setCompartilhamentos(Set<Long> compartilhamentos) {
        this.compartilhamentos = compartilhamentos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Tarefa)) {
            return false;
        }
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(id, tarefa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}