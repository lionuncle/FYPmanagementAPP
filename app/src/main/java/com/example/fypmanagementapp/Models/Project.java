package com.example.fypmanagementapp.Models;

import java.util.UUID;

public class Project {
    private String title;
    private final String id;
    public Project(){
        id = UUID.randomUUID().toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }
}
