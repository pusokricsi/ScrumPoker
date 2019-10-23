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
    public int lastKey;

    public FirebaseDatabaseHelper() {
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("SESSION");
    }

    public void addQuestion(String sessionId, Question question)
    {
        mDatabaseReference.child(sessionId).child("Questions").child(question.getQuestionId()).setValue(question);
    }

    public void getQuestionLastKey(String sessionId)
    {
        query = mDatabaseReference.child(sessionId).child("Questions").orderByChild("questionId").limitToLast(1);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot child: dataSnapshot.getChildren())
                {
                    String key;
                    key = (String) child.child("questionId").getValue();
                    Log.i("FBDB","session_last_ID: "+key);
                    try {
                        lastKey = Integer.parseInt(key);
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

}
