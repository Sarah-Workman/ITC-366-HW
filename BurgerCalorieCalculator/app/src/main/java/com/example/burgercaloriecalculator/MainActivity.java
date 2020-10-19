package com.example.burgercaloriecalculator;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompatSideChannelService;

public class MainActivity extends AppCompatActivity {
    // TASK 1: DECLARE UI OBJECTS TO BE REFERENCED
    private RadioGroup pattyRG1;
    private RadioGroup cheeseRG2;
    private CheckBox prosciuttoC;
    private TextView tv1;
    private SeekBar sauceC;

    // TASK 2: DECLARE VARIABLES FOR COMPUTING CALORIES
    private Burger burger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        burger = new Burger();
        initialize();

        registerChangeListener();
    }

    // TASK 5: GET REFERENCE TO EACH OF THE UI COMPONENTS
    public void initialize() {
        pattyRG1 = findViewById(R.id.Rbutton_group1);
        cheeseRG2 = findViewById(R.id.Rbutton_group2);
        prosciuttoC = findViewById(R.id.checkBox1);
        tv1 = findViewById(R.id.tv);
        sauceC = findViewById(R.id.Seek1);
    }

    public void registerChangeListener() {
        pattyRG1.setOnCheckedChangeListener(foodListener);
        prosciuttoC.setOnClickListener(baconListener);
        cheeseRG2.setOnCheckedChangeListener(foodListener);
        sauceC.setOnSeekBarChangeListener(sauceListener);
    }

    private RadioGroup.OnCheckedChangeListener foodListener = new OnCheckedChangeListener() {

        public void onCheckedChanged(RadioGroup rbGroup, int radioId) {
            RadioButton rb = findViewById(radioId);
            String btn = rb.getText().toString();

            switch (btn) {
                case "Beef Patty": //BeefPatty
                    burger.setPattyCalories(Burger.BEEF);
                    break;

                case "Lamb Patty": //LambPatty
                    burger.setPattyCalories(Burger.LAMB);
                    break;

                case "Ostrich Patty": //Ostrich Patty
                    burger.setPattyCalories(Burger.OSTRICH);
                    break;
                case "Asiago Cheese": //Asiago Cheese
                    burger.setCheeseCalories(Burger.ASIAGO);
                    break;
                case "Creme Fraich": //Creme Fraich
                    burger.setCheeseCalories(Burger.CREME_FRAICH);
                    break;
            }

            displayCalories();

        }
    };


        private OnClickListener baconListener = new OnClickListener(){
            public void onClick(View v){
                if(((CheckBox)v).isChecked())
                    burger.setProsciuttoCalories(Burger.PROSCIUTTO);
                else
                    burger.clearProsciuttoCalories();


                displayCalories();

            }
        };
        private OnSeekBarChangeListener sauceListener = new OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                burger.setSauceCalories(seekBar.getProgress());
                //sauceCal = seekBar.getprogress();
                displayCalories();
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        };

        private void displayCalories(){
            String calorieText ="Calories: " + burger.getTotalCalories();
            tv1.setText(calorieText);
            }

         @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.my, menu);
                return true;
            }

         @Override
            public boolean onOptionsItemSelected(MenuItem item) {
             // Handle action bar item clicks here. The action bar will
             // automatically handle clicks on the Home/Up button, so long
             // as you specify a parent activity in AndroidManifest.xml.
             int id = item.getItemId();
             if (id == R.id.action_settings) {
                 return true;
             }
             return super.onOptionsItemSelected(item);
         }
}

