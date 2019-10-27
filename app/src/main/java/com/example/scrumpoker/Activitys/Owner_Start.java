package com.example.scrumpoker.Activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.scrumpoker.Objects.Question;
import com.example.scrumpoker.Objects.Session;
import com.example.scrumpoker.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class Owner_Start extends AppCompatActivity {

    private DatabaseReference mDatabaseReference;
    private EditText newquestionEditText;
    private EditText NumberEmployees;
    private Button sendButton;
    private int lastKey;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_session);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("SESSION");
        inicialize();
        getSessionLastKey();
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createSession();
                Intent intent = new Intent(Owner_Start.this, Question.class);
                intent.putExtra("qustion",newquestionEditText.getText().toString());
                intent.putExtra("numberemployees",NumberEmployees.getText().toString());
                intent.putExtra("questionId",lastKey);
                startActivity(intent);
            }
        });

    }

    private void inicialize()
    {

        newquestionEditText = findViewById(R.id.newquestion);
        NumberEmployees =findViewById(R.id.numberEmployees);
        sendButton = findViewById(R.id.SendQuestion);

    }

    private void createSession()
    {
        getSessionLastKey();
        Log.i("FBDB","session_last_ID: "+getLastKey());

        mDatabaseReference.child(String.valueOf(++lastKey)).child("o").setValue(newquestionEditText.getText().toString());
        mDatabaseReference.child(String.valueOf(++lastKey)).child("o").setValue(NumberEmployees.getText().toString());
        mDatabaseReference.child(String.valueOf(lastKey)).child("sessionId").setValue(lastKey);
    }

    private void getSessionLastKey()
    {
        Query query = mDatabaseReference.orderByChild("Session_ID").limitToLast(1);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot child: dataSnapshot.getChildren())
                {
                    String key;
                    key = child.getKey();
                    Log.i("FBDB","session_last_ID: "+key);
                    try {
                        setLastKey(Integer.parseInt(key));
                    }catch (NumberFormatException e)
                    {
                        Log.i("FBDBERROR",e.toString());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.i("FBDBERROR",databaseError.toString());
            }
        });
    }

    public int getLastKey() {
        return lastKey;
    }

    public void setLastKey(int lastKey) {
        Log.i("FBDB","session_last_ID: "+lastKey);
        this.lastKey = lastKey;
    }
}
