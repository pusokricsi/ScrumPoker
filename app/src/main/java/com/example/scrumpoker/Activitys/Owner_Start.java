package com.example.scrumpoker.Activitys;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.scrumpoker.Objects.FirebaseRealtimeDatabaseHelper;
import com.example.scrumpoker.R;


public class Owner_Start extends AppCompatActivity implements Question_Fragmant.OnFragmentInteractionListener{

    private EditText newquestionEditText;
    private Button sendButton;
    private Button exitOwner;
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
    String s1 = intent.getStringExtra("com.example.scrumpoker.ownerName");
    int s2 = intent.getIntExtra("com.example.scrumpoker.sessionId",-1);
    Log.i("FBDB","SessionId: "+s2);
    Log.i("FBDB","SessionOwner: "+s1);
    fbdb = new FirebaseRealtimeDatabaseHelper(String.valueOf(s2));
    Log.i("FBDB","BAJVAN");
    owner.setText(fbdb.getSession().getOwnerName());
    Log.i("FBDB","BAJVAN"+fbdb.getSession().getOwnerName());


    fragmentContainer = (FrameLayout) findViewById(R.id.questionFragmant);

    sendButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String text = newquestionEditText.getText().toString();
            openFragment(text);
            String Text=newquestionEditText.getText().toString();
            if(Text.isEmpty()){
                Toast.makeText(getApplicationContext(),"Already Empty !!!",Toast.LENGTH_SHORT).show();
            }else{
                newquestionEditText.setText("");
            }

        }
    });

    exitOwner.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           Intent intent=new Intent(Owner_Start.this,CreateSessionActivity.class);
            startActivity(intent);
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
        exitOwner=findViewById(R.id.exit);
        owner=findViewById(R.id.Owner);

    }


}