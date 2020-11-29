package com.example.backgroundthreadhomework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private boolean running;
    private boolean wasRunning;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {

            // Get the previous state of the stopwatch
            // if the activity has been
            // destroyed and recreated.

            running
                    = savedInstanceState
                    .getBoolean("running");
            wasRunning
                    = savedInstanceState
                    .getBoolean("wasRunning");


        }
            runTimer();
     }
    @Override
    public void onSaveInstanceState(
            Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState
                .putBoolean("running", running);
        savedInstanceState
                .putBoolean("wasRunning", wasRunning);
    }



    // If the activity is resumed,
    // start the counter
    // again if it was running previously.
    @Override
    protected void onResume()
    {
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }


    public void start(View view) {
        Log.w("MainActivity", "On click start selected");
        //count starts
        running = true;



    }

    public void stop(View view) {
        Log.w("MainActivity", "On click stop selected");
        //count stops
        running = false;
    }
    private void runTimer() {
        final Handler handler = new Handler();

        final TextView tv = findViewById(R.id.tv);

        handler.post(new Runnable() {


            @Override
            public void run() {


                String sNumber = tv.getText().toString();
                Integer number = Integer.parseInt(sNumber);
                if (running) {
                    Integer newNumber = ++number;
                    tv.setText(Integer.toString(newNumber));
                }
                handler.postDelayed(this, 500);
            }



        });

    }

}

