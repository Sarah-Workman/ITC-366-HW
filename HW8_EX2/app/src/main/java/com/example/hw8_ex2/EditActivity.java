package com.example.hw8_ex2;

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

public class EditActivity extends AppCompatActivity {
    
    DataBaseManager dbManager;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        dbManager = new DataBaseManager(this);
        updateView();
    }

    private void updateView() {

        ArrayList<Friends> friends = dbManager.selectAll();

        //Creating a ScrollView and GridLayout
        if(friends.size() >0){
            ScrollView scrollView = new ScrollView(this);
            GridLayout grid = new GridLayout(this);
            grid.setRowCount(friends.size());
            grid.setColumnCount(5);

            //Create Arrays of Components
            TextView[] ids = new TextView[friends.size()];
            EditText[][] namesAndPrices = new EditText[friends.size()][3];
            Button[] buttons = new Button[friends.size()];
            ButtonHandler bh = new ButtonHandler();

            //Retrieve the width of the screen
            Point size = new Point();
            getWindowManager().getDefaultDisplay().getSize(size);
            int width = size.x;

            //Create the textView for the friend ID
            int i = 0;

            for(Friends friend : friends){
                ids[i] = new TextView(this);
                ids[i].setGravity(Gravity.CENTER);
                ids[i].setText("" + friend.getId());


                //Create the EditText for the Friend's first name,
                // last name, and email
                namesAndPrices[i][0] = new EditText(this);
                namesAndPrices[i][1] = new EditText(this);
                namesAndPrices[i][2] = new EditText(this);

                namesAndPrices[i][0].setText(friend.getFirstName());
                namesAndPrices[i][1].setText("" + friend.getLastName());
                namesAndPrices[i][2].setText("" + friend.getEmail());
                namesAndPrices[i][2].setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

                namesAndPrices[i][0].setId(10 * friend.getId());
                namesAndPrices[i][1].setId(10 * friend.getId() + 1);
                namesAndPrices[i][2].setId(10 * friend.getId() + 2);

                //Create the button
                buttons[i] = new Button(this);
                buttons[i].setText("Update");
                buttons[i].setId(friend.getId());

                //Setup the EventHandler
                buttons[i].setOnClickListener(bh);

                //add the elements the the view.
                grid.addView(ids[i], width / 10,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                grid.addView(namesAndPrices[i][0], (int) (width * .12),
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                grid.addView(namesAndPrices[i][1], (int) (width * .15),
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                grid.addView(namesAndPrices[i][2], (int) (width * .38),
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                grid.addView(buttons[i], (int) (width * .35),
                        ViewGroup.LayoutParams.WRAP_CONTENT);

                i++;
            }
            scrollView.addView(grid);
            setContentView(scrollView);
            }
        }




    private class ButtonHandler implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int friendId = v.getId();
            EditText fNameET = findViewById(10 * friendId);
            EditText lNameET = findViewById(10 * friendId +1);
            EditText eMailET = findViewById(10 * friendId +2);


            String Fname = fNameET.getText().toString();
            String Lname = lNameET.getText().toString();
            String Email = eMailET.getText().toString();

            //update Friends in the database
            try{
                dbManager.updateById(friendId, Fname, Lname, Email);
                Toast.makeText(EditActivity.this, "Friend Updated",
                        Toast.LENGTH_SHORT).show();


                //update screen
                updateView();
            }catch (NumberFormatException nfe) {
                Toast.makeText(EditActivity.this,
                        "Email Error", Toast.LENGTH_LONG).show();
            }

        }
    }
}