package com.mtz.todolist.service.serviceImp;

import com.mtz.todolist.model.UsuarioSecurityModel;
import com.mtz.todolist.model.entidades.Usuario;
import com.mtz.todolist.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UsuarioChecked implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario user = usuarioService.findByLogin(login);

        if (user == null) {
            throw new BadCredentialsException("Usuario não encontrado no sistema!");
        }

        if (!user.isAtivo()) {
            throw new DisabledException("Usuário não está ativo no sistema! ");
        }
        return new UsuarioSecurityModel(login, user.getSenha(), user.getAtivo(), accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    ///public boolean buscarHoleUsuario

}