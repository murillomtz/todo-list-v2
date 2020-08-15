package com.mtz.todolist.model.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable, UserDetails {

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

    @OneToMany(mappedBy = "usuario")
    private List<Tarefa> tarefasProprias = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<CompartilhamentoTarefas> tarefasCompartilhadas = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "login"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "nomeRole"))
    List<Role> roles = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(Long idUser, String login, String nome, String email, String senha, Boolean ativo) {
        this.idUser = idUser;
        this.login = login;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
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

    public List<CompartilhamentoTarefas> getTarefasCompartilhadas() {
        return this.tarefasCompartilhadas;
    }

    public void setTarefasCompartilhadas(List<CompartilhamentoTarefas> tarefas) {
        this.tarefasCompartilhadas = tarefas;
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

    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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

    /* UserDetails Implementação */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return this.roles;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return ativo;
    }

    @Override
    public String toString() {
        return "{" + " login='" + getLogin() + "'" + ", nome='" + getNome() + "'" + ", roles='" + getRoles() + "'"
                + "}";
    }

}