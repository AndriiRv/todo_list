package com.interlink.todolist.dto;

import java.util.Date;

public class Task {
    private Integer idTask;
    private Integer idList;
    private String headlineOfTask;
    private String headlineOfList;
    private String titleOfTask;
    private Date date;
    private Boolean done;

    public Integer getIdTask() {
        return idTask;
    }

    public void setIdTask(Integer idTask) {
        this.idTask = idTask;
    }

    public Integer getIdList() {
        return idList;
    }

    public void setIdList(Integer idList) {
        this.idList = idList;
    }

    public String getHeadlineOfTask() {
        return headlineOfTask;
    }

    public void setHeadlineOfTask(String headlineOfTask) {
        this.headlineOfTask = headlineOfTask;
    }

    public String getHeadlineOfList() {
        return headlineOfList;
    }

    public void setHeadlineOfList(String headlineOfList) {
        this.headlineOfList = headlineOfList;
    }

    public String getTitleOfTask() {
        return titleOfTask;
    }

    public void setTitleOfTask(String titleOfTask) {
        this.titleOfTask = titleOfTask;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}