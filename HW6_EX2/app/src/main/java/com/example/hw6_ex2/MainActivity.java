package com.example.hw6_ex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

                Button change = (Button) findViewById(R.id.button);

                if (newValue == 1) {
                    change.setBackgroundColor(Color.GREEN);
                    change.setText("Green Light");
                    
                } else if (newValue == 2) {

                    change.setBackgroundColor(Color.YELLOW);
                    change.setText("Yellow Light");
                }


            }
        });
    }
}


