package com.example.hw6_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


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
		Button change = (Button) findViewById(R.id.button);


		if (i == 1) {
			change.setBackgroundColor(Color.GREEN);
			change.setText("Green Light");
		}
		if (i == 2) {
				change.setBackgroundColor(Color.YELLOW);
				change.setText("Yellow Light");
			}


	}
	//
 }//end of Main




