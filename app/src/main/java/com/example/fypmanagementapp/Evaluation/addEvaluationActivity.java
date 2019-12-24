package com.example.fypmanagementapp.Evaluation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fypmanagementapp.Models.Student;
import com.example.fypmanagementapp.R;
import com.example.fypmanagementapp.Repository.Repository;
import com.example.fypmanagementapp.Student.StudentDetailActivity;

import java.util.LinkedList;

public class addEvaluationActivity extends AppCompatActivity {

    Button add;
    EditText marks;
    TextView name;
    Student s;
    String stdNameId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_evaluation);

        name = findViewById(R.id.stdNameEvaluation);
        marks = findViewById(R.id.addStudentNameTextEvaluation);
        add = findViewById(R.id.addStudentNameBtnEvaluation);

        stdNameId = getIntent().getStringExtra("evaluationClickId");
        s = new Student();
        try {
            for (int i = 0; i< Repository.getInstance().getStudentList().size(); i++)
                if (Repository.getInstance().getStudentList().get(i).getId().equals(stdNameId))
                    s = Repository.getInstance().getStudentList().get(i);
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s.setMarks(Integer.valueOf(marks.getText().toString()));
                Toast.makeText(addEvaluationActivity.this, marks.getText().toString()+" marks given to "+s.getName(), Toast.LENGTH_SHORT).show();
                int position =0;
                for (int i = 0; i< Repository.getInstance().getStudentList().size(); i++)
                    if (Repository.getInstance().getStudentList().get(i).getId().equals(stdNameId))
                        position = i;
                LinkedList<Student> newList = new LinkedList<>();
                newList = Repository.getInstance().getStudentList();
                newList.get(position).setMarks(Integer.valueOf(marks.getText().toString()));
                Repository.getInstance().saveNewStudentList(newList,addEvaluationActivity.this);
            }
        });

    }
}
