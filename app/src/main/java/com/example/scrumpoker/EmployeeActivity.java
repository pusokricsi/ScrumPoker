package com.example.scrumpoker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EmployeeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        final Button customButton1 = findViewById(R.id.custom_button1);
        final TextView textView=findViewById(R.id.sendText);



        customButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EmployeeActivity.this, "Click", Toast.LENGTH_SHORT).show();
                textView.setText("4");

            }
        });

        final Button customButton2 = findViewById(R.id.custom_button2);


        customButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EmployeeActivity.this, "Click", Toast.LENGTH_SHORT).show();
            }
        });


        final Button customButton3 = findViewById(R.id.custom_button3);


        customButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EmployeeActivity.this, "Click", Toast.LENGTH_SHORT).show();
            }
        });

        final Button customButton4=findViewById(R.id.custom_button4);

        customButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EmployeeActivity.this, "Click", Toast.LENGTH_SHORT).show();
            }
        });

        final Button customButton5=findViewById(R.id.custom_button5);

        customButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EmployeeActivity.this, "Click", Toast.LENGTH_SHORT).show();
            }
        });

        final Button sendButton=findViewById(R.id.sendButton);



    }
}
