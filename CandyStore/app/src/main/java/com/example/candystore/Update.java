package com.example.candystore;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Update extends AppCompatActivity {
    DatabaseManager dbManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbManager = new DatabaseManager(this);
        updateView();


    }

    //Build View Dynamically .
    private void updateView() {

        ArrayList<Candy> candies = dbManager.selectAll();

        //Create a ScrollView & Gridlayout
        if (candies.size() > 0) {

            ScrollView scrollView = new ScrollView(this);
            GridLayout grid = new GridLayout(this);
            grid.setRowCount(candies.size());
            grid.setColumnCount(4);

            //Create Arrays of Components
            TextView[] ids = new TextView[candies.size()];
            EditText[][] namesAndPrices = new EditText[candies.size()][2];
            Button[] buttons = new Button[candies.size()];
            ButtonHandler bh = new ButtonHandler();

            //Retrieve the width of the screen
            Point size = new Point();
            getWindowManager().getDefaultDisplay().getSize(size);
            int width = size.x;

            //Create the textView for the candy ID
            int i = 0;

            for (Candy candy : candies) {

                ids[i] = new TextView(this);
                ids[i].setGravity(Gravity.CENTER);
                ids[i].setText("" + candy.getId());

                //Create the EditTexts for the candy's name & price
                namesAndPrices[i][0] = new EditText(this);
                namesAndPrices[i][1] = new EditText(this);
                namesAndPrices[i][0].setText(candy.getName());
                namesAndPrices[i][1].setText("" + candy.getPrice());
                namesAndPrices[i][1]
                        .setInputType(InputType.TYPE_CLASS_NUMBER);
                namesAndPrices[i][0].setId(10 * candy.getId());
                namesAndPrices[i][1].setId(10 * candy.getId() + 1);

                //Create the button
                buttons[i] = new Button(this);
                buttons[i].setText("Update");
                buttons[i].setId(candy.getId());

                //Setup the EventHandler
                buttons[i].setOnClickListener(bh);

                //add the elements the the view.
                grid.addView(ids[i], width / 10,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                grid.addView(namesAndPrices[i][0], (int) (width * .4),
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                grid.addView(namesAndPrices[i][1], (int) (width * .15),
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                grid.addView(buttons[i], (int) (width * .35),
                        ViewGroup.LayoutParams.WRAP_CONTENT);

                i++;
            }
            scrollView.addView(grid);
            setContentView(scrollView);
        }
    }

        private class ButtonHandler implements View.OnClickListener {

            @Override
            public void onClick(View v) {
                //Retrieve name and price of the candy
                int candyId = v.getId();
                EditText nameET = findViewById(10 * candyId);
                EditText priceET = findViewById(10 * candyId + 1);
                String name = nameET.getText().toString();
                String priceString = priceET.getText().toString();

                //update candy in the database
                try {
                    double price = Double.parseDouble(priceString);
                    dbManager.updateById(candyId, name, price);
                    Toast.makeText(Update.this, "Candy updated",
                            Toast.LENGTH_SHORT).show();

                    //update screen
                    updateView();

                } catch (NumberFormatException nfe) {
                    Toast.makeText(Update.this,
                            "Price error", Toast.LENGTH_LONG).show();
                }
            }
        }
    }