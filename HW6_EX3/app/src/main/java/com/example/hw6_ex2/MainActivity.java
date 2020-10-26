package com.example.hw6_ex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    int newNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = (Button) findViewById(R.id.control_btn);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer newValue = MyHelper.clikable(newNumber);

                TextView Tv1 = (TextView)findViewById(R.id.Tv1);
                TextView Tv2 = (TextView)findViewById(R.id.Tv2);
                TextView Tv3 = (TextView)findViewById(R.id.Tv3);

                if (newValue == 1) {
                Tv1.setVisibility(View.INVISIBLE);
                Tv2.setVisibility(View.VISIBLE);

                    
                } else if (newValue == 2) {
                    Tv2.setVisibility(View.INVISIBLE);
                    Tv3.setVisibility(View.VISIBLE);
                }


            }
        });
    }
}


