package com.example.fypmanagementapp.Repository;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.fypmanagementapp.Models.Advisor;
import com.example.fypmanagementapp.Models.Project;
import com.example.fypmanagementapp.Models.Student;
import com.google.gson.Gson;

import java.util.LinkedList;

import static android.content.Context.MODE_PRIVATE;
import static com.example.fypmanagementapp.WhatAreYouActivity.mAdvisorPrefs;
import static com.example.fypmanagementapp.WhatAreYouActivity.mProjectPrefs;
import static com.example.fypmanagementapp.WhatAreYouActivity.mStudentPrefs;

public class Repository {

    private static Repository Instance;
    private SharedPreferences.Editor prefAdvisorEditor = mAdvisorPrefs.edit();
    private SharedPreferences.Editor prefStudentEditor = mStudentPrefs.edit();
    private SharedPreferences.Editor prefProjectEditor = mProjectPrefs.edit();
    private LinkedList<Advisor> mAdvisorList = new LinkedList<>();
    private LinkedList<Student> mStudentList = new LinkedList<>();
    private LinkedList<Project> mProjectList = new LinkedList<>();
    private Repository(){
        mAdvisorList = getAdvisorList();
        mStudentList = getStudentList();
        mProjectList = getProjectList();
    }

    public static Repository getInstance(){
        if (Instance == null){
            Instance = new Repository();
            return Instance;
        }
        else return Instance;
    }

//////////////***************PROJECT**********/////////////////////////////////////////////////////////////////
    public void addProjectToSharedPref(Project p){
        Gson gson = new Gson();
        String json = gson.toJson(p);
        int i = 1;
        String Checkjson = mProjectPrefs.getString(String.valueOf(i), null);
        while (Checkjson != null) {
            i++;
            Checkjson = mProjectPrefs.getString(String.valueOf(i), null);
        }
        prefProjectEditor.putString(String.valueOf(i), json);
        prefProjectEditor.commit();
    }
    public LinkedList<Project> getProjectList(){
        loadExistingProject();
        LinkedList<Project> pro = new LinkedList<>();
        pro = mProjectList;
        return pro;
    }
    private void loadExistingProject(){
        mProjectList = new LinkedList<>();
        Gson gson = new Gson();
        int i = 1;
        String Checkjson = mProjectPrefs.getString(String.valueOf(i), null);
        while (Checkjson != null) {
            Project temp = gson.fromJson(Checkjson, Project.class);
            this.mProjectList.add(temp);
            i++;
            Checkjson = mProjectPrefs.getString(String.valueOf(i), null);
        }
    }

////////////////////************STUDENT**********///////////////////////////////////////////////////////////////////////////
    public void addStudentToSharedPref(Student s){
        Gson gson = new Gson();
        String json = gson.toJson(s);
        int i = 1;
        String Checkjson = mStudentPrefs.getString(String.valueOf(i), null);
        while (Checkjson != null) {
            i++;
            Checkjson = mStudentPrefs.getString(String.valueOf(i), null);
        }
        prefStudentEditor.putString(String.valueOf(i), json);
        prefStudentEditor.commit();
    }

    public LinkedList<Student> getStudentList(){
        loadExistingStudent();
        return mStudentList;
    }
    private void loadExistingStudent(){
        mStudentList = new LinkedList<>();
        Gson gson = new Gson();
        int i = 1;
        String Checkjson = mStudentPrefs.getString(String.valueOf(i), null);
        while (Checkjson != null) {
            Student temp = gson.fromJson(Checkjson, Student.class);
                this.mStudentList.add(temp);
            i++;
            Checkjson = mStudentPrefs.getString(String.valueOf(i), null);
        }
    }
    public void saveNewStudentList(LinkedList<Student> newList, Context context) {
        SharedPreferences mPref = context.getSharedPreferences("STUDENT",MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = mPref.edit();
        for (int i=1; i <= newList.size();i++){
            prefEditor.remove(String.valueOf(i));
            prefEditor.commit();
        }
        for (int x=0; x<newList.size();x++){
            Student s = newList.get(x);
            Gson gson = new Gson();
            String json = gson.toJson(s);
            int i = 1;
            String Checkjson = mPref.getString(String.valueOf(i), null);
            while (Checkjson != null) {
                i++;
                Checkjson = mPref.getString(String.valueOf(i), null);
            }
            prefEditor.putString(String.valueOf(i), json);
            prefEditor.commit();
        }
        prefEditor.commit();
    }

////////////////////////////////////////////////************ADVISOR***********/////////////////////////////////////////////////////////////////////////////
    public void addAdvisorToSharedPref(Advisor a){
        Gson gson = new Gson();
        String json = gson.toJson(a);
        int i = 1;
        String Checkjson = mAdvisorPrefs.getString(String.valueOf(i), null);
        while (Checkjson != null) {
            i++;
            Checkjson = mAdvisorPrefs.getString(String.valueOf(i), null);
        }
        prefAdvisorEditor.putString(String.valueOf(i), json);
        prefAdvisorEditor.commit();

    }

    public LinkedList<Advisor> getAdvisorList(){
        loadExistingAdvisor();
        LinkedList<Advisor> temp = new LinkedList<>();
        temp = mAdvisorList;
        return temp;
    }
    private void loadExistingAdvisor() {

        mAdvisorList = new LinkedList<>();
        Gson gson = new Gson();
        int i = 1;
        String Checkjson = mAdvisorPrefs.getString(String.valueOf(i), null);
        while (Checkjson != null) {
            Advisor temp = gson.fromJson(Checkjson, Advisor.class);
            this.mAdvisorList.add(temp);
            i++;
            Checkjson = mAdvisorPrefs.getString(String.valueOf(i), null);
        }

    }
    public void saveNewAdvisorList(LinkedList<Advisor> newList, Context context) {
        SharedPreferences mPref = context.getSharedPreferences("ADVISOR",MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = mPref.edit();
        for (int i=1; i <= newList.size();i++){
            prefEditor.remove(String.valueOf(i));
            prefEditor.commit();
        }
        for (int x=0; x<newList.size();x++){
            Advisor a = newList.get(x);
            Gson gson = new Gson();
            String json = gson.toJson(a);
            int i = 1;
            String Checkjson = mPref.getString(String.valueOf(i), null);
            while (Checkjson != null) {
                i++;
                Checkjson = mPref.getString(String.valueOf(i), null);
            }
            prefEditor.putString(String.valueOf(i), json);
            prefEditor.commit();
        }
        prefEditor.commit();
    }
}
