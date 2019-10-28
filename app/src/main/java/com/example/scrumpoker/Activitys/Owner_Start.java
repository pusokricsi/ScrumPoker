package com.example.scrumpoker.Activitys;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.scrumpoker.Objects.FirebaseRealtimeDatabaseHelper;
import com.example.scrumpoker.R;


public class Owner_Start extends AppCompatActivity implements Question_Fragmant.OnFragmentInteractionListener{

    private EditText newquestionEditText;
    private Button sendButton;
    private TextView owner;
    private FrameLayout fragmentContainer;
    FirebaseRealtimeDatabaseHelper fbdb;

@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_owner__start);
    inicialize();
    owner = findViewById(R.id.Owner);
    Intent intent = getIntent();
    String s1 = intent.getStringExtra("ownerName");
    owner.setText(s1);
    String s2 = intent.getStringExtra("sessionId");
    fbdb = new FirebaseRealtimeDatabaseHelper("14");
    /*while (fbdb.getSession().getOwnerName().equals(null))
    {
        Log.i("FBDB","BAJVAN");
    }
    Log.i("FBDB",fbdb.getSession().getOwnerName());
    try {
        Thread.sleep(200);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    //owner.setText(s1);*/


    fragmentContainer = (FrameLayout) findViewById(R.id.questionFragmant);
    sendButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String text = newquestionEditText.getText().toString();
            openFragment(text);

        }
    });
}
    public void openFragment(String text)
    {
        Question_Fragmant fragment=Question_Fragmant.newInstance(text);
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        transaction.addToBackStack(null);
        transaction.add(R.id.questionFragmant,fragment,"Question_Fragmant").commit();
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @SuppressLint("MissingSuperCall")
    protected void onStart() {
        super.onStart();

    }

    private void inicialize()
    {

        newquestionEditText = findViewById(R.id.newquestion);
        sendButton = findViewById(R.id.SendQuestion);
        owner=findViewById(R.id.Owner);

    }


}
