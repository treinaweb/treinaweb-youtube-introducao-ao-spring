package br.com.treinaweb.twtodos.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.treinaweb.twtodos.repositories.TodoRepository;

@Controller
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/")
    public ModelAndView list() {
        return new ModelAndView(
            "todo/list", 
            Map.of("todos", todoRepository.findAll())
        );
    }
    
}
