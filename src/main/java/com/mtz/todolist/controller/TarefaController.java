package com.mtz.todolist.controller;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.mtz.todolist.model.entidades.CompartilhamentoTarefas;
import com.mtz.todolist.model.entidades.Tarefa;
import com.mtz.todolist.model.entidades.Usuario;
import com.mtz.todolist.repository.CompartilhamentoTarefasRepository;
import com.mtz.todolist.service.CompartilhamentoTarefasService;
import com.mtz.todolist.service.TarefaService;
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
public class TarefaController {

    @Autowired
    TarefaService tarefaService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    UsuarioController usuarioController;

    @Autowired
    CompartilhamentoTarefasService compartilhamentoTarefasService;

    @Autowired
    CompartilhamentoTarefasRepository compartilhamentoTarefasRepository;

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

    @RequestMapping(value = "/editartarefa/{id}", method = RequestMethod.GET)
    public ModelAndView getEditarTarefa(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("editarTarefa");

        Tarefa tarefa = tarefaService.findByid(id);
        mv.addObject("tarefa", tarefa);
        return mv;
    }

    @RequestMapping(value = "/novatarefa", method = RequestMethod.GET)
    public String getTarefaForm() {

        return "tarefasForm";

    }

    @Transactional // Por conta da transição de usuario e tarefa
    @RequestMapping(value = "/novatarefa", method = RequestMethod.POST)
    public String saveTarefa(@Valid Tarefa tarefa, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatorios foram preechidos!");
            //oilll
            GetUserSessionController gsc = new GetUserSessionController();
            return "redirect:/novatarefa";
        }

        tarefa.setData(LocalDate.now());

        GetUserSessionController gsc = new GetUserSessionController();
        // Seta o ADM para todas as tarefas
        Usuario usuarioADIM = usuarioController.getUsuariosByLogin("admin");
        Usuario usuario = usuarioController.getUsuariosByLogin(gsc.getUsuario().getLogin());

        CompartilhamentoTarefas c1 = new CompartilhamentoTarefas(null, usuarioADIM, tarefa);
        System.out.println("++++++usuarioADIM+++++" + usuarioADIM);
        System.out.println("++++++tarefa+++++" + tarefa.toString());
        // If(usuarioADIM != usuario){ addcompartilhadas}
        usuarioADIM.getTarefasCompartilhadas().add(c1);
        tarefa.getCompartilhamentos().add(c1);
        compartilhamentoTarefasRepository.save(c1);

        tarefa.setUsuario(usuario);
        tarefaService.save(tarefa);
        return "redirect:/tarefas";

    }

}