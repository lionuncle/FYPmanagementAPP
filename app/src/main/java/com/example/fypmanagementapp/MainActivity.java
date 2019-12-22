package com.example.fypmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.fypmanagementapp.Advisor.ManageAdvisorActivity;
import com.example.fypmanagementapp.Evaluation.ManageEvaluationsActivity;
import com.example.fypmanagementapp.Project.ManageProjectsActivity;
import com.example.fypmanagementapp.Student.ManageStudentActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout addAdvisorLayout, addStudentLayout, addProjectsLayout, addEvaluationLayout;
    public static SharedPreferences mAdvisorPrefs,mStudentPrefs,mProjectPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdvisorPrefs = getSharedPreferences("ADVISOR",MODE_PRIVATE);
        mStudentPrefs = getSharedPreferences("STUDENT",MODE_PRIVATE);
        mProjectPrefs = getSharedPreferences("PROJECT",MODE_PRIVATE);




        setContentView(R.layout.activity_main);
        addAdvisorLayout = findViewById(R.id.addAdvisorLayout);
        addStudentLayout = findViewById(R.id.addStudentLayout);
        addProjectsLayout = findViewById(R.id.addProjectLayout);
        addEvaluationLayout = findViewById(R.id.addEvaluationLayout);

        addAdvisorLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    startActivity(new Intent(MainActivity.this, ManageAdvisorActivity.class));
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        addStudentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ManageStudentActivity.class));
            }
        });
        addProjectsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ManageProjectsActivity.class));
            }
        });
        addEvaluationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ManageEvaluationsActivity.class));
            }
        });


    }
}
