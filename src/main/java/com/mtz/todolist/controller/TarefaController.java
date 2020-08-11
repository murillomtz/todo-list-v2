package com.mtz.todolist.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import com.mtz.todolist.model.Tarefa;
import com.mtz.todolist.service.TarefaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping(value = "/tarefas/{id}", method = RequestMethod.GET)
    public ModelAndView getTarefaDetails(@PathVariable("id") long id) {

        ModelAndView mv = new ModelAndView("tarefaDetails");
        Tarefa tarefa = tarefaService.findByid(id);
        mv.addObject("tarefa", tarefa);
        return mv;
    }

    @RequestMapping(value = "/novatarefa", method = RequestMethod.GET)
    public String getTarefaForm() {

        return "tarefasForm";
    }

    @RequestMapping(value = "/novatarefa", method = RequestMethod.POST)
    public String saveTarefa(@Valid Tarefa tarefa, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatorios foram preechidos!");
            return "redirect:/novatarefa";
        }

        tarefa.setData(LocalDate.now());
        tarefaService.save(tarefa);
        return "redirect:/tarefas";

    }
}