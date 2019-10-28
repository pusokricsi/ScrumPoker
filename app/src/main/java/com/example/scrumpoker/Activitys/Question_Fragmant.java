package com.example.scrumpoker.Activitys;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.scrumpoker.R;


public class Question_Fragmant extends Fragment  {

    private static final  String TEXT="text";
    private String mText;
    private Question_Fragmant.OnFragmentInteractionListener mListener;
    private TextView questionText;
    private  TextView employeesNumber;
    private Button buttonFragment;
    private int counter=0;

    public Question_Fragmant() {
    }


    public static Question_Fragmant newInstance(String text) {
        Question_Fragmant fragment = new Question_Fragmant();
        Bundle args = new Bundle();
        args.putString(TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mText = getArguments().getString(TEXT);

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    View view=inflater.inflate(R.layout.fragment_question__fragmant,container,false);
        buttonFragment=view.findViewById(R.id.buttonPolls);
        questionText=view.findViewById(R.id.questionView);
        questionText.setText(mText);
        questionText.requestFocus();


          buttonFragment.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if(counter!=0)
                  {
                      ////ki iratni a felhasznalokat es a szavazasukat
                  }else{
                      employeesNumber=v.findViewById(R.id.error);
                      employeesNumber.setText("Not everyone voted!");

                  }
              }
          });


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Question_Fragmant.OnFragmentInteractionListener) {
            mListener = (Question_Fragmant.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
