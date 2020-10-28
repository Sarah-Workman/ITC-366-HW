package com.example.hw6_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {





   	 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		 GUI();
	}



	private void GUI(){

		ButtonHandler bh = new ButtonHandler();
		Button start = findViewById(R.id.control_btn);


		start.setOnClickListener(bh);

   	 }



		private class ButtonHandler implements View.OnClickListener {
			@Override
			public void onClick(View v) {

				Button change = (Button) findViewById(R.id.button);

				Integer newValue = MainActivity.clikable(newNumber);


				//change based on value
				if (newValue == 1){
					change.setBackgroundColor(Color.GREEN);
					change.setText("Green Light");

				}else if(newValue == 2){
					change.setBackgroundColor(Color.YELLOW);
					change.setText("Yellow Light");
				}


				}
			}




	private static Integer clikable(int newNumber) {

		if (newNumber == 0) {
			++newNumber;
			return newNumber;
		} else if (newNumber == 1){
		1 + ++newNumber;
	}
	}//end of cliclable
 }




