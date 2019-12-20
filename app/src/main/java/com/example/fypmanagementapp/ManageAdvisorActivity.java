package com.example.fypmanagementapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ManageAdvisorActivity extends AppCompatActivity {

    Button addAdvisorBtn;

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

    }

}

