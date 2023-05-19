package br.com.treinaweb.twtodos.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.treinaweb.twtodos.repositories.TodoRepository;

@Controller
public class HomeController {

    private final TodoRepository todoRepository;

    public HomeController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/")
    public ModelAndView home() {
        var modelAndView = new ModelAndView("home");
        modelAndView.addObject("nome", "Wesley Gado");
        var alunos = List.of("Cleyson Lima", "Weslley Gado", "Elton Fonseca", "Anna Beatriz");
        modelAndView.addObject("alunos", alunos);
        modelAndView.addObject("ehProgramador", false);


        var todos = todoRepository.findAll();
        System.out.println(todos);

        return modelAndView;
    }
    
}
