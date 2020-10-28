package com.example.hw6_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

	int i = 0;



   	 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		 GUI();
	}//end of onCreate



	private void GUI(){

		ButtonHandler bh = new ButtonHandler();
		Button start = findViewById(R.id.control_btn);


		start.setOnClickListener(bh);

   	 }//end of GUI



		private class ButtonHandler implements View.OnClickListener {
			@Override
			public void onClick(View v) {

				i = ++i;
				colorChange(i);
				//Integer newValue = MainActivity.clikable(newNumber);


				

			}//end of onClick

		}//end of ButtonHandler

	public void colorChange(int i) {
		
				TextView Tv1 = (TextView)findViewById(R.id.Tv1);
                TextView Tv2 = (TextView)findViewById(R.id.Tv2);
                TextView Tv3 = (TextView)findViewById(R.id.Tv3);

		if (i == 1) {
			Tv1.setVisibility(View.INVISIBLE);
                	Tv2.setVisibility(View.VISIBLE);
		}
		if (i == 2) {
			Tv2.setVisibility(View.INVISIBLE);
                    	Tv3.setVisibility(View.VISIBLE);
			}
		if(i ==3) {
			Tv3.setVisibility(View.INVISIBLE);
			Tv1.setVisibility(View.VISIBLE);

		}
	}
	//
 }//end of Main


