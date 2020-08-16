package com.mtz.todolist.controller;

import java.util.List;

import javax.validation.Valid;

import com.mtz.todolist.model.entidades.Usuario;
import com.mtz.todolist.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public ModelAndView getUsuarios() {

        ModelAndView mv = new ModelAndView("usuarios");
        List<Usuario> usuarios = usuarioService.findAll();
        mv.addObject("usuarios", usuarios);
        return mv;
    }

    @RequestMapping
    // @RequestMapping(value = "/novatarefa", method = RequestMethod.GET)
    public Usuario getUsuariosByLogin(@PathVariable("login") String login) {

        // ModelAndView mv = new ModelAndView("/novatarefa");
        Usuario usuario = usuarioService.findByLogin(login);
        // mv.addObject("usuario", usuario);
        return usuario;
    }

    @RequestMapping(value = "/usuarios/{id}", method = RequestMethod.GET)
    public ModelAndView getUsuarioDetails(@PathVariable("id") long id) {

        ModelAndView mv = new ModelAndView("usuarioDetails");
        Usuario usuario = usuarioService.findByid(id);
        mv.addObject("usuario", usuario);
        return mv;
    }

    @RequestMapping(value = "/novausuario", method = RequestMethod.GET)
    public String getUsuarioForm() {

        return "usuariosForm";
    }

    @RequestMapping(value = "/novousuario", method = RequestMethod.POST)
    public String saveUsuario(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatorios foram preechidos!");
            return "redirect:/novausuario";
        }

        usuarioService.save(usuario);
        return "redirect:/usuarios";

    }

}