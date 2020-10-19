package com.example.countingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView number_1 = findViewById(R.id.number);
                String stringValue = number_1.getText().toString();
                Integer newNumber = Integer.parseInt(stringValue);
                Integer newValue = MyHelper.clikable(newNumber);
                number_1.setText(newValue.toString());

            }
        });







    }
}