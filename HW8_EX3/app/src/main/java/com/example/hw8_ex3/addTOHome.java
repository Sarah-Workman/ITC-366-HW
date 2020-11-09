package com.example.hw8_ex3;

import android.os.Bundle;;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class addTOHome extends AppCompatActivity {
    private DataBaseManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = new DataBaseManager(this);
        updateView();
    }
    private void updateView() {

    ArrayList<TOdo> todos = dbManager.selectAll();
    RelativeLayout layout = new RelativeLayout(this);
    ScrollView scrollView = new ScrollView(this);

    RadioGroup group = new RadioGroup(this);
        for(TOdo todo : todos) {
        RadioButton rb = new RadioButton(this);
        rb.setId(todo.getId());
        rb.setText(todo.toString());
        group.addView(rb);
    }


    setContentView(layout);

    }
}



