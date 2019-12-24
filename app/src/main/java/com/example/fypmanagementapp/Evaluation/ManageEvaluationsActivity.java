package com.example.fypmanagementapp.Evaluation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.fypmanagementapp.R;
import com.example.fypmanagementapp.Repository.Repository;
import com.example.fypmanagementapp.Student.ManageStudentActivity;

public class ManageEvaluationsActivity extends AppCompatActivity {

    ListView mlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_evaluations);
        mlist = findViewById(R.id.evaluationStudentList);
        mlist.setAdapter(new list(ManageEvaluationsActivity.this, Repository.getInstance().getStudentList()));
        mlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(ManageEvaluationsActivity.this,addEvaluationActivity.class);
                i.putExtra("evaluationClickId",Repository.getInstance().getStudentList().get(position).getId());
                startActivity(i);
            }
        });
    }
}
