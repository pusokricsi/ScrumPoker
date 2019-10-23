package com.example.scrumpoker;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class JoinSessionActivity extends AppCompatActivity {

    private DatabaseReference mDatabaseReference;
    private EditText sessionEmployeNameEditText,sessionIdEditText;
    private Button joinButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_session);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference("SESSION");

        inicialize();

        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joinSession();
                Log.i("FBDB",sessionIdEditText.getText().toString()+" "+sessionEmployeNameEditText.getText().toString());
                Intent intent = new Intent(JoinSessionActivity.this,EmployeeActivity.class);
                startActivity(intent);
            }
        });

    }

    public void inicialize()
    {
        sessionEmployeNameEditText = findViewById(R.id.sessionEmployeNameEditText);
        sessionIdEditText = findViewById(R.id.sessionIdEditText);
        joinButton = findViewById(R.id.joinButton);
    }

    public void joinSession()
    {

        if (!sessionIdEditText.getText().toString().isEmpty() && !sessionEmployeNameEditText.getText().toString().isEmpty()) {
            mDatabaseReference.child(sessionIdEditText.getText().toString()).child("EMPLOYE").child(sessionEmployeNameEditText.getText().toString()).child("Employe_Name").setValue(sessionEmployeNameEditText.getText().toString());
        }else{
            Toast.makeText(JoinSessionActivity.this,"Complete the fields!",Toast.LENGTH_SHORT).show();
        }
    }
}
