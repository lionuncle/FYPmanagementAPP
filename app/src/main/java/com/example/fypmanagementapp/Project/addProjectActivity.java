package com.example.fypmanagementapp.Project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fypmanagementapp.Models.Project;
import com.example.fypmanagementapp.Models.Student;
import com.example.fypmanagementapp.R;
import com.example.fypmanagementapp.Repository.Repository;

public class addProjectActivity extends AppCompatActivity {

    Button addBtn;
    TextView projectName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_project);

        addBtn = findViewById(R.id.addProjectNameBtn);
        projectName = findViewById(R.id.addProjectNameText);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Project p = new Project();
                p.setTitle(projectName.getText().toString());
                Repository r = Repository.getInstance();
                r.addProjectToSharedPref(p);
                Toast.makeText(getBaseContext(), "PROJECT :"+projectName.getText().toString()+ " ADDED", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
