package com.example.fypmanagementapp.Models;

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

    public final String getTYPE() {
        return "Advisor";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }
}
