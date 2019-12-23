package com.example.fypmanagementapp.Models;

import java.util.UUID;

public class Advisor {
    private String name;
    private String id;
    private String projectId = null;
    public Advisor(){
            id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public final String getTYPE() {
        return "Advisor";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getId() {
        return id;
    }
}
