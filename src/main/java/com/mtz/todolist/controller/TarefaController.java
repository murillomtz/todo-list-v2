package com.mtz.todolist.controller;

import java.util.List;

import com.mtz.todolist.model.Tarefa;
import com.mtz.todolist.service.TarefaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TarefaController {

    @Autowired
    TarefaService tarefaService;

    @RequestMapping(value = "/tarefas", method = RequestMethod.GET)
    public ModelAndView getTarefas() {
        
        ModelAndView mv = new ModelAndView("tarefas");
        List<Tarefa> tarefas = tarefaService.findAll();
        mv.addObject("tarefas", tarefas);        
        return mv;
    }

    @RequestMapping(value = "/novatarefa", method = RequestMethod.GET)
    public ModelAndView getTarefaForm() {       
        //retorenra "novaTarefaForm"
        return null;
    }
}