package com.example.fypmanagementapp.Models;

import java.util.UUID;

public class Student {
    private String name;
    private String id;
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
