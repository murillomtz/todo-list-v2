package com.mtz.todolist.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @NotBlank
    private String nome;

    @NotBlank
    @Column(unique = true)
    private String email;

    @JsonIgnore // Para nao tornar visivel a senha quando for puxar o perfil do cliente
    @NotBlank
    private String senha;

    private Boolean ativo;

    private Boolean adm;

    // Cascade para apagar as tarefas do DB quando excluir Usuario
    // Um usuário para varias tarefas.
    @ManyToMany
    @JoinTable(name = "compartilhamento", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "tarefa_id"))
    private List<Tarefa> tarefas = new ArrayList<>();

    // @OneToMany(mappedBy = "usuario")
    // private Set<CompartilhamentoTarefas> compUser = new HashSet<>();

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

    public List<Tarefa> getTarefas() {
        return this.tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    /*
     * public Set<CompartilhamentoTarefas> getCompUser() { return this.compUser; }
     * 
     * public void setCompUser(Set<CompartilhamentoTarefas> compUser) {
     * this.compUser = compUser; }
     */

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