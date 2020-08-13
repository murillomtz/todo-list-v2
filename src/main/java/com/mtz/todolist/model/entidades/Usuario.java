package com.mtz.todolist.model.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @NotBlank
    @Column(unique = true)
    private String login;

    @NotBlank(message = "O Nome é de preenchimento obrigatório.")
    private String nome;

    @NotBlank
    @Column(unique = true)
    private String email;

    @JsonIgnore
    @NotBlank
    private String senha;

    private Boolean ativo;

    private Boolean adm;

    @OneToMany(mappedBy = "usuario")
    private List<Tarefa> tarefasProprias = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<CompartilhamentoTarefas> tarefasCompartilhadas = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(Long idUser, String login, String nome, String email, String senha, Boolean ativo) {
        this.idUser = idUser;
        this.login = login;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
        this.adm = false;
    }

    public Long getId() {
        return this.idUser;
    }

    public void setId(Long idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean isAtivo() {
        return this.ativo;
    }

    public Boolean getAtivo() {
        return this.ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Boolean isAdm() {
        return this.adm;
    }

    public Boolean getAdm() {
        return this.adm;
    }

    public void setAdm(Boolean adm) {
        this.adm = adm;
    }

    public List<CompartilhamentoTarefas> getTarefasCompartilhadas() {
        return this.tarefasCompartilhadas;
    }

    public void setTarefasCompartilhadas(List<CompartilhamentoTarefas> tarefas) {
        this.tarefasCompartilhadas = tarefas;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getIdUser() {
        return idUser;
    }

    public List<Tarefa> getTarefasProprias() {
        return tarefasProprias;
    }

    public void setTarefasProprias(List<Tarefa> tarefasProprias) {
        this.tarefasProprias = tarefasProprias;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(idUser, usuario.idUser);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idUser);
    }

}