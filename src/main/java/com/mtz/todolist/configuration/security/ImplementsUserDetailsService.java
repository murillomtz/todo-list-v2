package com.mtz.todolist.configuration.security;

import com.mtz.todolist.model.entidades.Usuario;
import com.mtz.todolist.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository ur;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = ur.findByLogin(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario não encontrado");
        }
        System.out.println("Nre user" + new User(usuario.getLogin(), usuario.getPassword(), true, true, true, usuario.getAtivo(),
        usuario.getAuthorities()));
        return new User(usuario.getLogin(), usuario.getPassword(), true, true, true, usuario.getAtivo(),
                usuario.getAuthorities());
    }

}