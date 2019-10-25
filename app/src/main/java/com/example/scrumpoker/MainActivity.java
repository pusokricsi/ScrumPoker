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

        fbdb = new FirebaseRealtimeDatabaseHelper();

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

   /* public void test()
    {
        //Log.i("FBDB","Main: "+fbdb.getSession().getOwnerName());
        fbdb.addQuestion("2",new Question("2","KEcske","Kecsk??"));
    }*/









    private void test(){
        Log.i("FBDB",fbdb.getSession().toString());




    //fbdb = new FirebaseDatabaseHelper();


        /*fbdb.getQuestionLastKey("1");
        new CountDownTimer(200, 100) {
            public void onFinish() {
                Log.i("FBDB","test: "+fbdb.getLastKey());    //AZ UTOLSO QUESTION ID LEKERDEZESE
            }

            public void onTick(long millisUntilFinished) {

            }
        }.start();*/

        //Question question = new Question("3","awdawf","wafaw");
        //mDatabaseReference.child("1").child("Questions").child(question.getQuestionId()).setValue(question);

        /*Query query = mDatabaseReference.child("4");

        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Log.i("FBDB","Enter Query");
                test[0] = dataSnapshot.getValue().toString();
                Log.i("FBDB", test[0]);
                Log.i("FBDB","Exit Query");
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


        Log.i("FBDB", "Test method: "+test[0]);*/

    }

}
