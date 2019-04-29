package com.interlink.todolist.repository;

import com.interlink.todolist.dto.Task;
import com.interlink.todolist.rowMapper.ListTaskRowMapper;
import com.interlink.todolist.rowMapper.TaskRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TodoListRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final ListTaskRowMapper listTaskRowMapper;
    private final TaskRowMapper taskRowMapper;

    @Autowired
    public TodoListRepository(NamedParameterJdbcTemplate jdbcTemplate,
                              ListTaskRowMapper listTaskRowMapper,
                              TaskRowMapper taskRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.listTaskRowMapper = listTaskRowMapper;
        this.taskRowMapper = taskRowMapper;
    }

    public void addListOfTask(Task task) {
        String sqlAddListTask = "INSERT INTO list_task(headline_of_list, date) VALUES(:headline_of_list, :date)";
        SqlParameterSource parameterAddListTask = new MapSqlParameterSource()
                .addValue("headline_of_list", task.getHeadlineOfList())
                .addValue("date", LocalDate.now());
        jdbcTemplate.update(sqlAddListTask, parameterAddListTask);
    }

    public void addTask(Task task, Integer idList) {
        String sqlAddTask = "INSERT INTO task(id_list, headline, title, date, done) VALUES(:id_list, :headline, :title, :date, :done)";
        SqlParameterSource parameterAddTask = new MapSqlParameterSource()
                .addValue("id_list", getListById(idList).getIdList())
                .addValue("headline", task.getHeadlineOfTask())
                .addValue("title", task.getTitleOfTask())
                .addValue("date", LocalDate.now())
                .addValue("done", false);
        jdbcTemplate.update(sqlAddTask, parameterAddTask);
    }

    public Task getListById(Integer idList) {
        try {
            String sql = "SELECT * FROM list_task WHERE id = :id";
            return jdbcTemplate.queryForObject(sql, new MapSqlParameterSource("id", idList), listTaskRowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void changeTaskIsDone(Integer idTask, Boolean valueDone) {
        String sqlChangeTaskIsDone = "UPDATE task SET done = :done WHERE id = :id";
        SqlParameterSource parameterChangeTaskIsDone = new MapSqlParameterSource()
                .addValue("done", valueDone)
                .addValue("id", idTask);
        jdbcTemplate.update(sqlChangeTaskIsDone, parameterChangeTaskIsDone);
    }

    public List<Task> getTask() {
        String sql = "SELECT * FROM task AS t INNER JOIN list_task AS lt ON t.id_list = lt.id";
        List<Task> orders = jdbcTemplate.query(sql, taskRowMapper);
        orders = orders.stream()
                .sorted(Comparator.comparing(Task::getIdTask))
                .collect(Collectors.toList());
        return orders;
    }

    public List<Task> getListOfTask() {
        String sql = "SELECT * FROM list_task";
        List<Task> orders = jdbcTemplate.query(sql, listTaskRowMapper);
        orders = orders.stream()
                .sorted(Comparator.comparing(Task::getIdList))
                .collect(Collectors.toList());
        return orders;
    }

    public void deleteTask(Integer idTask, Integer idList) {
        String sqlDeleteTask = "DELETE FROM task WHERE id = :id AND id_list = :id_list";
        jdbcTemplate.update(sqlDeleteTask, new MapSqlParameterSource()
                .addValue("id", idTask)
                .addValue("id_list", idList));
    }

    public void deleteListTask(Integer idList) {
        String sqlDeleteList = "DELETE FROM list_task WHERE id = :id";
        jdbcTemplate.update(sqlDeleteList, new MapSqlParameterSource("id", idList));
    }
}