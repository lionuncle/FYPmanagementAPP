package com.example.fypmanagementapp.Advisor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fypmanagementapp.Models.Advisor;
import com.example.fypmanagementapp.R;
import com.example.fypmanagementapp.Repository.Repository;

public class AddAdvisorNameActivity extends AppCompatActivity {
    EditText addAdvisorNameText;
    Button addAdvisorNamebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_advisor_name);
        addAdvisorNameText = findViewById(R.id.addAdvisorNameText);
        addAdvisorNamebtn = findViewById(R.id.addAdvisorNameBtn);

        addAdvisorNamebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Advisor a = new Advisor();
                a.setName(addAdvisorNameText.getText().toString());
                Repository r = Repository.getInstance();
                r.addAdvisorToSharedPref(a);
                Toast.makeText(getBaseContext(), "ADVISER :"+addAdvisorNameText.getText().toString()+ " ADDED", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
