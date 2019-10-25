package com.example.scrumpoker;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference mDatabaseReference;
    private Button joinSessionButton,createSessionButton,testButton;
    FirebaseRealtimeDatabaseHelper fbdb;
    final ArrayList<Question> questions = new ArrayList<>();
    final String[] test = new String[1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicialize();


        mDatabaseReference = FirebaseDatabase.getInstance().getReference("SESSION");

        fbdb = new FirebaseRealtimeDatabaseHelper("1");

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

    private void test(){
        Log.i("FBDB",fbdb.getSession().toString());
        Intent intent = new Intent(MainActivity.this,Test.class);
        startActivity(intent);
    }

}
