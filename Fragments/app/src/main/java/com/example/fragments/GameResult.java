package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class GameResult extends Fragment {

    TextView gameResultTv;


    public GameResult() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      setUpFragmentGUI(container);
      return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void setUpFragmentGUI(ViewGroup container) {


        if(gameResultTv == null){
            gameResultTv = new TextView(getActivity());
            gameResultTv.setGravity(Gravity.CENTER_HORIZONTAL);
            container.addView(gameResultTv);
        }

    }

    @Override
    public void onStart() {
        super.onStart();
     gameResultTv.setText("Good Luck");
    }

    public void setResult(String result) {
        gameResultTv.setText(result);
    }
}