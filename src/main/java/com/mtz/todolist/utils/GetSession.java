/*package com.mtz.todolist.utils;

import com.mtz.todolist.model.Usuario;

import java.io.Serializable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class GetSession implements Serializable {

    private Usuario usuario;

    public UsuarioController(){
		usuario = new Usuario();
		SecurityContext context = SecurityContextHolder.getContext();
		if(context instanceof SecurityContext)
		{
			Authentication authentication = context.getAuthentication();
			if(authentication instanceof Authentication)
			{
				 usuario.setLogin(((User)authentication.getPrincipal()).getUsername());
			}
		}
		
    }

    /*
     * Após isso, basta instanciar um objeto da seguinte forma
     * 
     * UsuarioControler uc = new UsuarioControler();
     * 
     * String usuario = uc.getUsuario().getLogin();
     */
