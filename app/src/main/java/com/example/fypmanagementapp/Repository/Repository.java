package com.example.fypmanagementapp.Repository;

import android.content.SharedPreferences;

import com.example.fypmanagementapp.Models.Advisor;
import com.example.fypmanagementapp.Models.Project;
import com.example.fypmanagementapp.Models.Student;
import com.google.gson.Gson;

import java.util.LinkedList;

import static com.example.fypmanagementapp.MainActivity.mAdvisorPrefs;
import static com.example.fypmanagementapp.MainActivity.mStudentPrefs;
import static com.example.fypmanagementapp.MainActivity.mProjectPrefs;

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
}
