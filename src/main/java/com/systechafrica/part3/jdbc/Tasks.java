package com.systechafrica.part3.jdbc;

import java.time.LocalDate;

public class Tasks {
    private String id;
    private String title;
    private LocalDate start_date;
    private LocalDate due_date;
    private int status;
    private int priority;
    private String description;

    public Tasks(String id, String title, LocalDate start_date, LocalDate due_date, int status, int priority,
            String description) {
        this.id = id;
        this.title = title;
        this.start_date = start_date;
        this.due_date = due_date;
        this.status = status;
        this.priority = priority;
        this.description = description;
    }
    public Tasks( String title, LocalDate start_date, LocalDate due_date, int status, int priority,
            String description) {
        this.title = title;
        this.start_date = start_date;
        this.due_date = due_date;
        this.status = status;
        this.priority = priority;
        this.description = description;
    }
    public Tasks(){

    }
   
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public LocalDate getStart_date() {
        return start_date;
    }
    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }
    public LocalDate getDue_date() {
        return due_date;
    }
    public void setDue_date(LocalDate due_date) {
        this.due_date = due_date;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "Tasks [id=" + id + ", title=" + title + ", start_date=" + start_date + ", due_date=" + due_date
                + ", status=" + status + ", priority=" + priority + ", description=" + description + "]";
    }
    
        
}
