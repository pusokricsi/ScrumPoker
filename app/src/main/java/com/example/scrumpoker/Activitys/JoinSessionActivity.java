package com.example.scrumpoker.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scrumpoker.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class JoinSessionActivity extends AppCompatActivity {

    private DatabaseReference mDatabaseReference;
    private EditText sessionEmployeNameEditText,sessionIdEditText;
    private Button joinButton;
    public static final String EXTRA_EMPLOYEE_NAME = "com.example.scrumpoker.Employee";
    public static final String EXTRA_SESSION_ID = "com.example.scrumpoker.ID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_session);


        mDatabaseReference = FirebaseDatabase.getInstance().getReference("SESSION");

        inicialize();

      /*  joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joinSession();
                Intent intent = new Intent(JoinSessionActivity.this,EmployeeActivity.class);
                intent.putExtra(EXTRA_EMPLOYEE_NAME,sessionEmployeNameEditText.getText().toString());
                intent.putExtra(EXTRA_SESSION_ID,sessionIdEditText.getText().toString());
                startActivity(intent);
            }
        });*/

    }

    public void joinButton (View view){
        joinSession();
        Intent intent = new Intent(JoinSessionActivity.this,EmployeeActivity.class);
        intent.putExtra(EXTRA_EMPLOYEE_NAME,sessionEmployeNameEditText.getText().toString());
        intent.putExtra(EXTRA_SESSION_ID,sessionIdEditText.getText().toString());
        startActivity(intent);
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
            mDatabaseReference.child(sessionIdEditText.getText().toString()).child("Employees").child(sessionEmployeNameEditText.getText().toString()).child("employeeName").setValue(sessionEmployeNameEditText.getText().toString());
        }else{
            Toast.makeText(JoinSessionActivity.this,"Complete the fields!",Toast.LENGTH_SHORT).show();
        }
    }
}
