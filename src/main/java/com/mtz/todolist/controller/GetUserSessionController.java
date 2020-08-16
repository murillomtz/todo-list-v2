package com.mtz.todolist.controller;

import java.io.Serializable;

import com.mtz.todolist.model.entidades.Usuario;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class GetUserSessionController implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Usuario usuario;

    public GetUserSessionController() {
        usuario = new Usuario();
        SecurityContext context = SecurityContextHolder.getContext();
        if (context instanceof SecurityContext) {
            Authentication authentication = context.getAuthentication();
            if (authentication instanceof Authentication) {
                usuario.setLogin(((User) authentication.getPrincipal()).getUsername());
            }
        }

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}