package com.example.fypmanagementapp.Advisor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.fypmanagementapp.R;
import com.example.fypmanagementapp.Repository.Repository;

public class ManageAdvisorActivity extends AppCompatActivity {

    Button addAdvisorBtn;
    ListView advisorList;
    AdvisorAdapter advisorAdapter;
    PopupMenu menu;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_advisor);

        addAdvisorBtn = findViewById(R.id.addAdvisorBtn);
        addAdvisorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManageAdvisorActivity.this, AddAdvisorNameActivity.class));
            }
        });

        advisorList = findViewById(R.id.advisorList);
        advisorAdapter = new AdvisorAdapter(ManageAdvisorActivity.this, Repository.getInstance().getAdvisorList());
        advisorList.setAdapter(advisorAdapter);


    }

}

