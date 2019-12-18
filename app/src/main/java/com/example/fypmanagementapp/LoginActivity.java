package com.example.fypmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText textUserName;
    EditText textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.login);
        textUserName = findViewById(R.id.usernameTextView);
        textPassword = findViewById(R.id.passwordTextView);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textUserName.getText().toString().equals("admin")){
                    if (textPassword.getText().toString().equals("admin")){
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }
                }
            }
        });
    }
}
