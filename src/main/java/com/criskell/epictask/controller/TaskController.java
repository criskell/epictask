package com.criskell.epictask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.criskell.epictask.model.Task;
import com.criskell.epictask.repository.TaskRepository;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        return "tasks/index";
    }

    @GetMapping("/form")
    public String showForm() {
        return "tasks/form";
    }

    @PostMapping("/form")
    public String create(Task task, RedirectAttributes redirect) {
        taskRepository.save(task);
        redirect.addFlashAttribute("message", "Tarefa cadastrada com sucesso!");
        return "redirect:/tasks";
    }
}