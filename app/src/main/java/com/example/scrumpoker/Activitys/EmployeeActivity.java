package com.example.scrumpoker.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.scrumpoker.Objects.FirebaseRealtimeDatabaseHelper;
import com.example.scrumpoker.Objects.Question;
import com.example.scrumpoker.R;

public class EmployeeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        Intent intent= getIntent();
        String employeeName = intent.getStringExtra(JoinSessionActivity.EXTRA_EMPLOYEE_NAME);
        String sessionID = intent.getStringExtra(JoinSessionActivity.EXTRA_SESSION_ID);




        final Button customButton1 = findViewById(R.id.custom_button1);
        final TextView textView=findViewById(R.id.sendText);
        final EditText questionText = findViewById(R.id.questionText);




        customButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EmployeeActivity.this, "Click", Toast.LENGTH_SHORT).show();
                textView.setText("1");

            }
        });

        final Button customButton2 = findViewById(R.id.custom_button2);


        customButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EmployeeActivity.this, "Click", Toast.LENGTH_SHORT).show();
                textView.setText("2");
            }
        });


        final Button customButton3 = findViewById(R.id.custom_button3);


        customButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EmployeeActivity.this, "Click", Toast.LENGTH_SHORT).show();
                textView.setText("3");
            }
        });

        final Button customButton4=findViewById(R.id.custom_button4);

        customButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EmployeeActivity.this, "Click", Toast.LENGTH_SHORT).show();
                textView.setText("4");
            }
        });

        final Button customButton5=findViewById(R.id.custom_button5);

        customButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EmployeeActivity.this, "Click", Toast.LENGTH_SHORT).show();
                textView.setText("5");
            }
        });

        final Button sendButton=findViewById(R.id.sendButton);



    }
}
