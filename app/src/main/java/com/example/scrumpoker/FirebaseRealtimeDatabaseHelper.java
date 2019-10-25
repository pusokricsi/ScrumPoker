package com.example.scrumpoker;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class FirebaseRealtimeDatabaseHelper {
    private DatabaseReference mDatabaseReference;
    private Query query;
    private String test;
    private Session session;


    public FirebaseRealtimeDatabaseHelper() {
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("SESSION");
        session = new Session();
        getDatabaseSessionData();
    }

    public FirebaseRealtimeDatabaseHelper(String test) {
        this.test = test;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public void getDatabaseSessionData(){
        query = mDatabaseReference.child("1");
        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String key = dataSnapshot.getKey();
                Log.i("FBDB","onChildAdded "+dataSnapshot.getKey());
                if (key.equals("ownerName"))
                {
                    session.setOwnerName(dataSnapshot.getValue().toString());
                    Log.i("FBDB","onChildAdded/ownerName: "+dataSnapshot.getValue());
                }
                if (key.equals("sessionId"))
                {
                    session.setSessionId(dataSnapshot.getValue().toString());
                    Log.i("FBDB","onChildAdded/sessionId: "+dataSnapshot.getValue());
                }
                if (key.equals("sessionName"))
                {
                    session.setSessionName(dataSnapshot.getValue().toString());
                    Log.i("FBDB","onChildAdded/sessionName: "+dataSnapshot.getValue());
                }
                if (key.equals("Questions"))
                {

                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                String key = dataSnapshot.getKey();
                Log.i("FBDB","onChildAdded "+dataSnapshot.getKey());
                if (key.equals("ownerName"))
                {
                    session.setOwnerName(dataSnapshot.getValue().toString());
                    Log.i("FBDB","onChildAdded/ownerName: "+dataSnapshot.getValue());
                }
                if (key.equals("sessionId"))
                {
                    session.setSessionId(dataSnapshot.getValue().toString());
                    Log.i("FBDB","onChildAdded/sessionId: "+dataSnapshot.getValue());
                }
                if (key.equals("sessionName"))
                {
                    session.setSessionName(dataSnapshot.getValue().toString());
                    Log.i("FBDB","onChildAdded/sessionName: "+dataSnapshot.getValue());
                }
                if (key.equals("Questions"))
                {

                }
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void addQuestion(String sessionId, Question question)
    {
        mDatabaseReference.child(sessionId).child("Questions").child(question.getQuestionId()).setValue(question);
    }
}
