package com.interlink.todolist.service;

import com.interlink.todolist.repository.TodoListRepository;
import com.interlink.todolist.dto.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {
    private final TodoListRepository todoListRepository;

    @Autowired
    public TodoListService(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    public void addTask(Task task, Integer idList) {
        todoListRepository.addTask(task, idList);
    }

    public Task getListById(Integer idList) {
        return todoListRepository.getListById(idList);
    }

    public void addListOfTask(Task task) {
        todoListRepository.addListOfTask(task);
    }

    public List<Task> getListOfTask() {
        return todoListRepository.getListOfTask();
    }

    public void changeTaskIsDone(Integer idTask, Boolean valueDone) {
        todoListRepository.changeTaskIsDone(idTask, valueDone);
    }

    public List<Task> getTask() {
        return todoListRepository.getTask();
    }

    public void deleteTask(Integer idTask, Integer idList) {
        todoListRepository.deleteTask(idTask, idList);
    }

    public void deleteListTask(Integer idList) {
        todoListRepository.deleteListTask(idList);
    }
}