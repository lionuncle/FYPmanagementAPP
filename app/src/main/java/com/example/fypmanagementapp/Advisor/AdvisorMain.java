package com.example.fypmanagementapp.Advisor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.fypmanagementapp.Evaluation.ManageEvaluationsActivity;
import com.example.fypmanagementapp.MainActivity;
import com.example.fypmanagementapp.R;

public class AdvisorMain extends AppCompatActivity {

    LinearLayout  addEvaluationLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advisor_main);


        addEvaluationLayout = findViewById(R.id.addEvaluationLayout);

        addEvaluationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdvisorMain.this, ManageEvaluationsActivity.class));
            }
        });
    }
}
