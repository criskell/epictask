package com.criskell.epictask.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.criskell.epictask.model.Task;

@Controller
@RequestMapping("/tasks")
class TaskController {
    private List<Task> tasks = new ArrayList<>(List.of(
        new Task(1L, "Aprender ELF", "Aprender o formato de executáveis do Linux", 0, 0),
        new Task(2L, "Aprender Monad Transformers", "Aprender como compor entre diferentes monads", 0, 0),
        new Task(3L, "Aprender árvores B+Tree",
                "Aprender como funciona as árvores utilizadas por índices em bancos de dados", 0, 0),
        new Task(4L, "Aprender árvore AVL", "Aprender como funciona a árvore AVL", 0, 0)));

    @GetMapping
    public String list(Model model) {
        model.addAttribute("tasks", tasks);

        return "tasks/index";
    }

    @GetMapping("/form")
    public String showForm() {
        return "tasks/form";
    }

    @PostMapping("/form")
    public String create(Task task, RedirectAttributes redirect) {
        tasks.add(task);
        redirect.addFlashAttribute("message", "Tarefa cadastrada com sucesso!");
        return "redirect:/tasks";
    }
}