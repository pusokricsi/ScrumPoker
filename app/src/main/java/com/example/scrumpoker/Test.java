package com.example.scrumpoker;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Test extends AppCompatActivity {
    private EditText text1,text2,text3,text4;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        inicialize();
        final FirebaseRealtimeDatabaseHelper fbdb = new FirebaseRealtimeDatabaseHelper("2");  //SessionID Inteltel jon at

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("FBDB",text1.getText().toString()+" "+text2.toString()+" "+text3.toString());
                int a = fbdb.getSession().getQuestions().size();
                fbdb.addQuestion("2",new Question(String.valueOf(a+1),text1.getText().toString(),text2.getText().toString()));   //QUESTION HOZZAADAS


                //fbdb.addQuestionRating("2",text1.getText().toString(),text2.toString(),text3.toString());
                //fbdb.addQuestionRating("2","kurva1","1","10");
            }
        });
    }

    public void inicialize()
    {
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        button = findViewById(R.id.button);
    }
}
