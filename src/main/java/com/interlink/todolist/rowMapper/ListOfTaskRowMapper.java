package com.interlink.todolist.rowMapper;

import com.interlink.todolist.dto.Task;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ListOfTaskRowMapper implements RowMapper<Task> {

    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        Task task = new Task();
        task.setIdList(rs.getInt("id"));
        task.setHeadlineOfList(rs.getString("headline_of_list"));
        task.setDate(rs.getDate("date"));
        return task;
    }
}