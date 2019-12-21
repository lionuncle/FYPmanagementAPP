package com.example.fypmanagementapp.Models;

import java.util.UUID;

public class Student {
    private String name;
    private final String id;
    public Student(){
        id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }
}
