package com.example.scrumpoker.Activitys;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.scrumpoker.Objects.FirebaseRealtimeDatabaseHelper;
import com.example.scrumpoker.R;


public class Owner_Start extends AppCompatActivity {

    private EditText newquestionEditText;
    private Button sendButton;
    private TextView owner;
    FirebaseRealtimeDatabaseHelper fbdb;

@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_owner__start);
    inicialize();
    owner = findViewById(R.id.Owner);
    Intent intent = getIntent();
    String s1 = intent.getStringExtra("ownerName");
    String s2 = intent.getStringExtra("sessionId");
    fbdb = new FirebaseRealtimeDatabaseHelper("1");

    //owner.setText(s1);

    FragmentManager manager = getSupportFragmentManager();
    final FragmentTransaction question_t = manager.beginTransaction();
    final Question_Fragmant m4 = new Question_Fragmant();

    sendButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Bundle b2 = new Bundle();
            b2.putString("question", newquestionEditText.getText().toString());
            m4.setArguments(b2);
            question_t.add(R.id.questionView, m4);
            question_t.commit();
        }
    });
}


    @SuppressLint("MissingSuperCall")
    protected void onStart() {
        super.onStart();
        owner.setText(fbdb.getSession().getOwnerName());
    }

    private void inicialize()
    {

        newquestionEditText = findViewById(R.id.newquestion);
        sendButton = findViewById(R.id.SendQuestion);
        owner=findViewById(R.id.Owner);

    }


}
