package com.example.fypmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fypmanagementapp.Advisor.AdvisorMain;
import com.example.fypmanagementapp.Models.Advisor;
import com.example.fypmanagementapp.Student.StudentMain;

public class WhatAreYouActivity extends AppCompatActivity {
    public static SharedPreferences mAdvisorPrefs,mStudentPrefs,mProjectPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_are_you);
        showAlertDialog();
        mAdvisorPrefs = getSharedPreferences("ADVISOR",MODE_PRIVATE);
        mStudentPrefs = getSharedPreferences("STUDENT",MODE_PRIVATE);
        mProjectPrefs = getSharedPreferences("PROJECT",MODE_PRIVATE);

    }
    private void showAlertDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(WhatAreYouActivity.this);
        alertDialog.setTitle("WHO ARE YOU");
        alertDialog.setCancelable(false);
        String[] items = {"ADMIN","STUDENT","ADVISER"};
        int checkedItem = 1;
        alertDialog.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        startActivity(new Intent(WhatAreYouActivity.this,LoginActivity.class));
                        //Toast.makeText(getApplicationContext(), "Clicked on ADMIN", Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        startActivity(new Intent(WhatAreYouActivity.this, StudentMain.class));
                        //Toast.makeText(getApplicationContext(), "Clicked on STUDENT", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        startActivity(new Intent(WhatAreYouActivity.this, AdvisorMain.class));
                        //Toast.makeText(getApplicationContext(), "Clicked on ADVISER", Toast.LENGTH_LONG).show();
                        break;

                }
            }
        });
        AlertDialog alert = alertDialog.create();
        alert.setCanceledOnTouchOutside(false);
        alert.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        showAlertDialog();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showAlertDialog();
    }
}
