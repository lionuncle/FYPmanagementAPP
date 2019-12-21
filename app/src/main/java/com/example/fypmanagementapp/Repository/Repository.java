package com.example.fypmanagementapp.Repository;

import android.content.SharedPreferences;

import com.example.fypmanagementapp.Models.Advisor;
import com.google.gson.Gson;

import java.util.LinkedList;

import static com.example.fypmanagementapp.MainActivity.mPrefs;

public class Repository {

    private static Repository Instance;
    private SharedPreferences.Editor prefEditor = mPrefs.edit();
    private LinkedList<Advisor> mAdvisorList = new LinkedList<>();
    private Repository(){
        mAdvisorList = getAdvisorList();
    }

    public static Repository getInstance(){
        if (Instance == null){
            Instance = new Repository();
            return Instance;
        }
        else return Instance;
    }

    public void addAdvisorToSharedPref(Advisor a){
        Gson gson = new Gson();
        String json = gson.toJson(a);
        int i = 1;
        String Checkjson = mPrefs.getString(String.valueOf(i), null);
        while (Checkjson != null) {
            i++;
            Checkjson = mPrefs.getString(String.valueOf(i), null);
        }
        prefEditor.putString(String.valueOf(i), json);
        prefEditor.commit();

    }
    public LinkedList<Advisor> getAdvisorList(){
        loadExistingData();
        LinkedList<Advisor> temp = new LinkedList<>();
        temp = mAdvisorList;
        return temp;

    }
    private void loadExistingData() {

        mAdvisorList = new LinkedList<>();
        Gson gson = new Gson();
        int i = 1;
        String Checkjson = mPrefs.getString(String.valueOf(i), null);
        while (Checkjson != null) {
            Advisor temp = gson.fromJson(Checkjson, Advisor.class);
            this.mAdvisorList.add(temp);
            i++;
            Checkjson = mPrefs.getString(String.valueOf(i), null);
        }

    }
}
