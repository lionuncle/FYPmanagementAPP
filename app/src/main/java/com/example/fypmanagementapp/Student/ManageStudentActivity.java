package com.example.fypmanagementapp.Student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fypmanagementapp.R;
import com.example.fypmanagementapp.Repository.Repository;

public class ManageStudentActivity extends AppCompatActivity {

    Button addStdBtn;
    ListView studentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_student);

        addStdBtn = findViewById(R.id.addStudentButton);
        studentList = findViewById(R.id.studentList);

        addStdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManageStudentActivity.this, addStudentActivity.class));
            }
        });

        studentAdapter adapter = new studentAdapter(ManageStudentActivity.this, Repository.getInstance().getStudentList());
        studentList.setAdapter(adapter);

        studentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ManageStudentActivity.this,StudentDetailActivity.class);
                i.putExtra("stdId",Repository.getInstance().getStudentList().get(position).getId());
                startActivity(i);
                //Toast.makeText(ManageStudentActivity.this, Repository.getInstance().getStudentList().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
