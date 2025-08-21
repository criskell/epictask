package com.criskell.epictask.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.criskell.epictask.model.Task;

@Controller
@RequestMapping("/tasks")
class TaskController {
    @GetMapping
    public String list(Model model) {
        var tasks = List.of(
                new Task(1L, "Aprender ELF", "Aprender o formato de executáveis do Linux", 0, 0),
                new Task(2L, "Aprender Monad Transformers", "Aprender como compor entre diferentes monads", 0, 0),
                new Task(3L, "Aprender árvores B+Tree",
                        "Aprender como funciona as árvores utilizadas por índices em bancos de dados", 0, 0),
                new Task(4L, "Aprender árvore AVL", "Aprender como funciona a árvore AVL", 0, 0));

        model.addAttribute("tasks", tasks);

        return "tasks/index";
    }
}