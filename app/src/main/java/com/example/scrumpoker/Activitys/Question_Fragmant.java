package com.example.scrumpoker.Activitys;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.scrumpoker.R;


public class Question_Fragmant extends Fragment {

    private TextView this_question;

    public Question_Fragmant() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_question__fragmant,container,false);
        inicialize();
        Bundle b3=getArguments();
        String question=b3.getString("question");
        this_question.setText("question");

        return v;
    }

    private void inicialize()
    {
        this_question= getView().findViewById(R.id.questionView);
    }
}
