package com.example.scrumpoker;



import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class FirebaseDatabaseHelper {
    private DatabaseReference mDatabaseReference;
    private Query query;

    public FirebaseDatabaseHelper() {
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("SESSION");
    }

    public void addQuestion(String sessionId, Question question)
    {
        mDatabaseReference.child(sessionId).child("Question").child(question.getQuestionId()).setValue(question);
    }
}
