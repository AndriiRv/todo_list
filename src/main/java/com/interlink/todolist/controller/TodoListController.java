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
        todoListService.addTask(task, idList);
        return "redirect:/";
    }

    @RequestMapping(value = "/doDoneUndone/idTask={idTask}/doneUndone={done}", method = RequestMethod.GET)
    public String changeDoneInTask(@PathVariable int idTask, @PathVariable boolean done) {
        todoListService.changeTaskIsDone(idTask, done);
        return "redirect:/";
    }

    @RequestMapping(value = "/doChangeTitleInTask/idTask={idTask}/titleOfTask={titleOfTask}", method = RequestMethod.GET)
    public String changeTitleInTask(@PathVariable int idTask, @PathVariable String titleOfTask) {
        String nameOfTable = "task";
        String id = "id";
        String nameOfColumn = "title";
        todoListService.changeHeadlineAndTitleInTaskAndListOfTask(nameOfTable, id, idTask, nameOfColumn, titleOfTask);
        return "redirect:/";
    }

    @RequestMapping(value = "/doChangeHeadlineInTask/idTask={idTask}/headlineOfTask={headlineOfTask}", method = RequestMethod.GET)
    public String changeHeadlineInTask(@PathVariable int idTask, @PathVariable String headlineOfTask) {
        String nameOfTable = "task";
        String id = "id";
        String nameOfColumn = "headline";
        todoListService.changeHeadlineAndTitleInTaskAndListOfTask(nameOfTable, id, idTask, nameOfColumn, headlineOfTask);
        return "redirect:/";
    }

    @RequestMapping(value = "/doChangeHeadlineInListOfTask/idList={idList}/headlineInListOfTask={headlineInListOfTask}", method = RequestMethod.GET)
    public String changeHeadlineInListOfTask(@PathVariable int idList, @PathVariable String headlineInListOfTask) {
        String nameOfTable = "list_task";
        String id = "id";
        String nameOfColumn = "headline_of_list";
        todoListService.changeHeadlineAndTitleInTaskAndListOfTask(nameOfTable, id, idList, nameOfColumn, headlineInListOfTask);
        return "redirect:/";
    }

    @RequestMapping(value = "/doDeleteTask/idTask={idTask}/idList={idList}", method = RequestMethod.GET)
    public String deleteTask(@PathVariable int idTask, @PathVariable int idList) {
        todoListService.deleteTask(idTask, idList);
        return "redirect:/";
    }

    @RequestMapping(value = "/doDeleteListTask/idList={idList}", method = RequestMethod.GET)
    public String deleteListTask(@PathVariable int idList) {
        todoListService.deleteListOfTask(idList);
        return "redirect:/";
    }
}