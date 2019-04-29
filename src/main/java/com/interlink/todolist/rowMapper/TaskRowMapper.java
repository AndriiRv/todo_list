package com.interlink.todolist.rowMapper;

import com.interlink.todolist.dto.Task;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TaskRowMapper implements RowMapper<Task> {

    @Override
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
        Task task = new Task();
        task.setIdTask(rs.getInt("id"));
        task.setIdList(rs.getInt("id_list"));
        task.setHeadlineOfList(rs.getString("headline_of_list"));
        task.setHeadlineOfTask(rs.getString("headline"));
        task.setTitleOfTask(rs.getString("title"));
        task.setDate(rs.getDate("date"));
        task.setDone(rs.getBoolean("done"));
        return task;
    }
}
