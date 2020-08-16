package com.mtz.todolist.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthenticationController {

    // Dexei apenas o mapeamento da uri que define como padrão método GET

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /// criar um coletor de erro parecido savetaerfa
}