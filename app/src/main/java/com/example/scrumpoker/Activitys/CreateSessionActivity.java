package com.example.scrumpoker.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.scrumpoker.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class CreateSessionActivity extends AppCompatActivity {

    private DatabaseReference mDatabaseReference;
    private EditText sessionOwnerNameEditText, sessionNameEditText;
    private Button createButton;
    private int lastKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_session);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("SESSION");
        inicialize();
        getSessionLastKey();
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createSession();
                Log.i("FBDB","Create "+getLastKey());
                Intent intent = new Intent(CreateSessionActivity.this, Owner_Start.class);
                intent.putExtra("com.example.scrumpoker.ownerName",sessionOwnerNameEditText.getText().toString());
                intent.putExtra("com.example.scrumpoker.sessionId",1);
                startActivity(intent);
            }
        });

    }

    private void inicialize()
    {

        sessionOwnerNameEditText = findViewById(R.id.sessionOwnerNameEditText);
        sessionNameEditText = findViewById(R.id.sessionNameEditText);
        createButton = findViewById(R.id.createButton);

    }

    private void createSession()
    {
        getSessionLastKey();
        Log.i("FBDB","session_last_ID: "+getLastKey());

        mDatabaseReference.child(String.valueOf(++lastKey)).child("ownerName").setValue(sessionOwnerNameEditText.getText().toString());
        mDatabaseReference.child(String.valueOf(lastKey)).child("sessionName").setValue(sessionNameEditText.getText().toString());
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
