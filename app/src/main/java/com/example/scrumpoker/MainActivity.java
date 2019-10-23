package com.example.scrumpoker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button joinSessionButton,createSessionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicialize();
        //hhhhhcxc

        joinSessionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,JoinSessionActivity.class);
                startActivity(intent);
            }
        });

        createSessionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CreateSessionActivity.class);
                startActivity(intent);
            }
        });

    }

    private void inicialize()
    {
        joinSessionButton = findViewById(R.id.joinSessionButton);
        createSessionButton = findViewById(R.id.createSessionButton);
    }
}
