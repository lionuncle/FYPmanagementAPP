package com.example.fypmanagementapp;

public class Repository {

    private static Repository Instance;
    private Repository(){

    }
    public static Repository getInstance(){
        if (Instance == null){
            Instance = new Repository();
            return Instance;
        }
        else return Instance;
    }

    public void addAdvisorToSharedPref(Advisor a){

    }
}
