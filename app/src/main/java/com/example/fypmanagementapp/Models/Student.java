package com.example.fypmanagementapp.Models;

import java.util.UUID;

public class Student {
    private String name;
    private String id;
    private String projectId = null;
    private int marks = -1;

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Student(){
        id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }
    public final String getTYPE() {
        return "Student";
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }
}
