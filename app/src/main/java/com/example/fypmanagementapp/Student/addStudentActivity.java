package com.example.fypmanagementapp.Student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fypmanagementapp.Models.Advisor;
import com.example.fypmanagementapp.Models.Student;
import com.example.fypmanagementapp.R;
import com.example.fypmanagementapp.Repository.Repository;

public class addStudentActivity extends AppCompatActivity {

    Button addStudentNameBtn;
    TextView addStudentNameText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        addStudentNameText = findViewById(R.id.addStudentNameText);
        addStudentNameBtn = findViewById(R.id.addStudentNameBtn);

        addStudentNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student s = new Student();
                s.setName(addStudentNameText.getText().toString());
                Repository r = Repository.getInstance();
                r.addStudentToSharedPref(s);
                Toast.makeText(getBaseContext(), "STUDENT :"+addStudentNameText.getText().toString()+ " ADDED", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
