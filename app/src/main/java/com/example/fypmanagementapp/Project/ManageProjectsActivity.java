package com.example.fypmanagementapp.Project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.fypmanagementapp.R;
import com.example.fypmanagementapp.Repository.Repository;

import java.util.List;

public class ManageProjectsActivity extends AppCompatActivity {

    Button addProjectBtn;
    ListView projectList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_projects);

        addProjectBtn = findViewById(R.id.addProjectButton);
        projectList = findViewById(R.id.projectList);

        addProjectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManageProjectsActivity.this,addProjectActivity.class));
            }
        });

        projectAdapter adapter = new projectAdapter(this, Repository.getInstance().getProjectList());
        projectList.setAdapter(adapter);

    }
}
