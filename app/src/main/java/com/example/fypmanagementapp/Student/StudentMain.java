package com.example.fypmanagementapp.Student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.fypmanagementapp.Evaluation.ManageEvaluationsActivity;
import com.example.fypmanagementapp.Evaluation.list;
import com.example.fypmanagementapp.R;
import com.example.fypmanagementapp.Repository.Repository;

public class StudentMain extends AppCompatActivity {

    ListView mlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main);
        mlist = findViewById(R.id.studentMainList);
        mlist.setAdapter(new list(StudentMain.this, Repository.getInstance().getStudentList()));
    }
}
