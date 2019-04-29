package com.interlink.todolist.controller;

import com.interlink.todolist.service.TodoListService;
import com.interlink.todolist.dto.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoListController {
    private final TodoListService todoListService;

    @Autowired
    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getTask(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("taskList", todoListService.getTask());
        model.addAttribute("listOfTask", todoListService.getListOfTask());
        return "index.html";
    }

    @RequestMapping(value = "/addListOfTask", method = RequestMethod.POST)
    public String saveListOfTask(Task task) {
        todoListService.addListOfTask(task);
        return "redirect:/";
    }

    @RequestMapping(value = "/addTask", method = RequestMethod.POST)
    public String saveTask(Task task, @RequestParam Integer idList) {
        todoListService.getListById(idList);
        todoListService.addTask(task, idList);
        return "redirect:/";
    }

    @RequestMapping(value = "/doDoneUndone/idTask={idTask}/doneUndone={done}", method = RequestMethod.GET)
    public String changeDoneInTask(@PathVariable int idTask, @PathVariable boolean done) {
        todoListService.changeTaskIsDone(idTask, done);
        return "redirect:/";
    }

    @RequestMapping(value = "/doDeleteTask/idTask={idTask}/idList={idList}", method = RequestMethod.GET)
    public String deleteTask(@PathVariable int idTask, @PathVariable int idList) {
        todoListService.deleteTask(idTask, idList);
        return "redirect:/";
    }

    @RequestMapping(value = "/doDeleteListTask/idList={idList}", method = RequestMethod.GET)
    public String deleteListTask(@PathVariable int idList) {
        todoListService.deleteListTask(idList);
        return "redirect:/";
    }
}