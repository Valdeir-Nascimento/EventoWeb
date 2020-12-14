package com.eventoweb.controller;

import com.eventoweb.domain.Evento;
import com.eventoweb.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EventoController {

    @Autowired
    private EventoRepository repository;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/cadastrarEvento")
    public String form() {
        return "evento/form-evento";
    }

    @PostMapping(value = "/cadastrarEvento")
    public String form(Evento evento) {
        repository.save(evento);
        return "redirect:/eventos";
    }

    @GetMapping("/eventos")
    public ModelAndView getEventos() {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Evento> eventoList = repository.findAll();
        modelAndView.addObject("eventos", eventoList);
        return modelAndView;
    }

}
