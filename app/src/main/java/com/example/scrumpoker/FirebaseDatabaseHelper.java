package com.example.scrumpoker;


import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.Nullable;

public class FirebaseDatabaseHelper {
    private DatabaseReference mDatabaseReference;
    private Query query;
    private String lastKey;
    private Question question;

    public FirebaseDatabaseHelper() {
        FirebaseDatabase.getInstance().getReference("SESSION");
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("SESSION");
    }

    //UJ KERDES
    public void addQuestion(String sessionId, Question question)
    {
        mDatabaseReference.child(sessionId).child("Questions").child(question.getQuestionId()).setValue(question);
    }

    //KERDES UTOLSO ID LEKERDEZES
    public void getQuestionLastKey (String sessionId)
    {
        Query query = mDatabaseReference.child(sessionId).child("Questions").orderByKey().limitToLast(1);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot child: dataSnapshot.getChildren())
                {
                    setLastKey(child.getKey());
                    Log.i("FBDB","session_last_ID: ch: "+child.getKey());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public String getLastKey() {
        return lastKey;
    }

    public void setLastKey(String lastKey) {
        this.lastKey = lastKey;
    }

    public void getQuestion(String sessionId)
    {
        Query query = mDatabaseReference.child(sessionId).child("Questions");

        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                if (dataSnapshot.getValue() != null)
                {
                    setQuestion(dataSnapshot.getValue(Question.class));
                    Log.i("FBDB",getQuestion().toString());
                }
                Log.i("FBDB","MAKESOMTHING");
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
