package com.example.fypmanagementapp.Student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fypmanagementapp.Advisor.advisorDetailActivity;
import com.example.fypmanagementapp.Advisor.selectProjectList;
import com.example.fypmanagementapp.Models.Advisor;
import com.example.fypmanagementapp.Models.Student;
import com.example.fypmanagementapp.Project.addProjectActivity;
import com.example.fypmanagementapp.R;
import com.example.fypmanagementapp.Repository.Repository;

import java.util.LinkedList;

public class StudentDetailActivity extends AppCompatActivity {

    TextView name;
    Button assignProject;
    private ListView listView;
    Student s;
    String studentClickedId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        studentClickedId = getIntent().getStringExtra("stdId");

        s = new Student();

        try {
            for (int i = 0; i< Repository.getInstance().getStudentList().size(); i++)
                if (Repository.getInstance().getStudentList().get(i).getId().equals(studentClickedId))
                    s = Repository.getInstance().getStudentList().get(i);
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }


        name = findViewById(R.id.studentNameTop);
        name.setText(s.getName());

        listView = findViewById(R.id.projectSelectListForStudent);
        StudentSelectProjectList adapter = new StudentSelectProjectList(StudentDetailActivity.this,Repository.getInstance().getProjectList());
        listView.setAdapter(adapter);
        assignProject = findViewById(R.id.btnAssignProjectToStudent);
        assignProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(advisorDetailActivity.this, "Touch", Toast.LENGTH_SHORT).show();
                listView.setVisibility(View.VISIBLE);
                if (Repository.getInstance().getProjectList().size() < 1) {
                    Toast.makeText(StudentDetailActivity.this, "No project to show, addd prject", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(StudentDetailActivity.this, addProjectActivity.class));
                }
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedProjectId = Repository.getInstance().getProjectList().get(position).getId();
                LinkedList<Student> newList = new LinkedList<>();
                newList = Repository.getInstance().getStudentList();
                newList.get(position).setProjectId(selectedProjectId);

                Repository.getInstance().saveNewStudentList(newList,StudentDetailActivity.this);
                Toast.makeText(StudentDetailActivity.this, "Project: '"+Repository.getInstance()
                        .getProjectList().get(position)
                        .getTitle()+ "' To student '" + s.getName()+"' ", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
