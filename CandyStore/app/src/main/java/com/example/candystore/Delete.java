package com.example.candystore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

public class Delete extends AppCompatActivity {

    private DatabaseManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = new DatabaseManager(this);
        updateView();
    }

    //build the view dynamically with all candies
    private void updateView() {
        ArrayList<Candy> candies = dbManager.selectAll();
        RelativeLayout layout = new RelativeLayout(this);
        ScrollView scrollView = new ScrollView(this);
        RadioGroup group = new RadioGroup(this);
        for (Candy candy : candies) {
            RadioButton rb = new RadioButton(this);
            rb.setId(candy.getId());
            rb.setText(candy.toString());
            group.addView(rb);
        }

        //inside of main still
        //set up event handling
        RadioButtonHandler rbh = new RadioButtonHandler();
        group.setOnCheckedChangeListener(rbh);


        //create a back button

        Button backButton = new Button(this);
        backButton.setText("Back");

        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Delete.this.finish();

            }
        });

        //add a back button at the bottom of the View
        scrollView.addView(group);
        layout.addView(scrollView);

        // add back button at bottom
        RelativeLayout.LayoutParams params
                = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.setMargins(0, 0, 0, 50);
        layout.addView(backButton, params);

        setContentView(layout);
    }
        private class RadioButtonHandler implements RadioGroup.OnCheckedChangeListener {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                dbManager.deleteById(checkedId);
                Toast.makeText(Delete.this, "Candy deleted",
                        Toast.LENGTH_SHORT).show();

                // update screen
                updateView();
            }
        }
    }//end of Main

