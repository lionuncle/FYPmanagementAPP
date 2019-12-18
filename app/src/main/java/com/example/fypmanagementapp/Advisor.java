package com.example.fypmanagementapp;

import java.util.UUID;

public class Advisor {
    private String name;
    private final String id;
    public Advisor(){
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
