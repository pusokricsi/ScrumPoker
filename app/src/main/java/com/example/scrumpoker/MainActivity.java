package com.example.scrumpoker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference mDatabaseReference;
    private Button joinSessionButton,createSessionButton,testButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicialize();

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

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test();
            }
        });

    }

    private void inicialize()
    {
        joinSessionButton = findViewById(R.id.joinSessionButton);
        createSessionButton = findViewById(R.id.createSessionButton);
        testButton = findViewById(R.id.testButton);
    }

    private void test()
    {
        FirebaseDatabaseHelper fbdb = new FirebaseDatabaseHelper();
        

    }

}
