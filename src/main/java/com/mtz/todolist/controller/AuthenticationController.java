package com.mtz.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationController {

	// Dexei apenas o mapeamento da uri que define como padrão método GET 
	
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}