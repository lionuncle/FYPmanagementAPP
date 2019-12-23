package com.example.fypmanagementapp.Models;

import java.util.UUID;

public class Project {
    private String title;
    private String id;
    public Project(){
            id = UUID.randomUUID().toString();
    }

    public String getTitle() {
        return title;
    }
    public final String getTYPE() {
        return "Project";
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }
}
