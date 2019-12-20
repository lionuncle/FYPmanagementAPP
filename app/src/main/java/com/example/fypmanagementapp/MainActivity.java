package com.example.fypmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout addAdvisorLayout, addStudentLayout, addProjectsLayout, addEvaluationLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addAdvisorLayout = findViewById(R.id.addAdvisorLayout);
        addStudentLayout = findViewById(R.id.addStudentLayout);
        addProjectsLayout = findViewById(R.id.addProjectLayout);
        addEvaluationLayout = findViewById(R.id.addEvaluationLayout);

        addAdvisorLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ManageAdvisorActivity.class));
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
