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

    LinearLayout addAdvisorLayout, addStudentLayout, addProjectsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





        setContentView(R.layout.activity_main);
        addAdvisorLayout = findViewById(R.id.addAdvisorLayout);
        addStudentLayout = findViewById(R.id.addStudentLayout);
        addProjectsLayout = findViewById(R.id.addProjectLayout);
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



    }
}
