package com.example.fypmanagementapp.Advisor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.fypmanagementapp.R;
import com.example.fypmanagementapp.Repository.Repository;

import java.util.concurrent.locks.ReentrantLock;

public class ManageAdvisorActivity extends AppCompatActivity {

    Button addAdvisorBtn;
    ListView advisorList;
    AdvisorAdapter advisorAdapter;

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

        advisorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ManageAdvisorActivity.this,advisorDetailActivity.class);
                i.putExtra("id", Repository.getInstance().getAdvisorList().get(position).getId());
                startActivity(i);
            }
        });


    }

}

