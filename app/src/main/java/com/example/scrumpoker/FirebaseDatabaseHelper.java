package com.example.scrumpoker;



import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class FirebaseDatabaseHelper {
    private DatabaseReference mDatabaseReference;
    private Query query;
    private int lastKey;

    public FirebaseDatabaseHelper() {
        FirebaseDatabase.getInstance().getReference("SESSION").keepSynced(true);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("SESSION");
    }

    public void addQuestion(String sessionId, Question question)
    {
        mDatabaseReference.child(sessionId).child("Questions").child(question.getQuestionId()).setValue(question);
    }

    public void getQuestionLastKey (String sessionId)
    {
        Query query = mDatabaseReference.child(sessionId).child("Question").orderByKey().limitToLast(1);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                setLastKey(1);
                Log.i("FBDB","getQuestionLastKey");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public int getLastKey() {
        return lastKey;
    }

    public void setLastKey(int lastKey) {
        this.lastKey = lastKey;
    }
}
