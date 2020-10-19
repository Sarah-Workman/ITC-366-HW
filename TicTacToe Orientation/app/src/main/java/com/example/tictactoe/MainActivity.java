package com.example.tictactoe;

//In Version 0 of our TicTacToe app, we use the empty activity template and only setup the GUI.
// We use a 3 × 3 two-dimensional array of Buttons, in order to mirror the 3 × 3 two-dimensional array game in our Model
// the TicTacToe class.
// In order to keep things simple, we first place the View inside the Activity class,
// so the View and the Controller are in the same class. Later in the chapter,
// we separate the View from the Controller and place them in two different classes.

//We are assuming that two users will be playing on the same device against each other.
// Enabling game play does not just mean placing an X or an O on the grid of buttons at each turn.
// It also means enforcing the rules, such as not allowing someone to play twice at the same position on the grid,
// checking if one player won, indicating if the game is over.
// Our Model, the TicTacToe class, provides that functionality.
// In order to enable play, we add a TicTacToe object as an instance variable of our Activity class,
// and we call the methods of the TicTacToe class as and when needed.
// Play is happening inside the update method so we have to modify it.
// We also need to check if the game is over and, in that case, disable all the buttons.,

//We want to improve Version 2
// by showing the current state of the game at the bottom of the screen,

//In Version 4, we enable the player to play another game after the current one is over.
// When the game is over, we want a dialog box asking the user if he or she wants to play again to pop up.
// If the answer is yes, he or she can play again.
// If the answer is no,
// we exit the activity (in this case the app since there is only one activity).

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import android.widget.LinearLayout;



public class MainActivity extends AppCompatActivity {
    private Button[][] buttons = new Button[TicTacToe.SIDE][TicTacToe.SIDE];

    public static int ACTION_BAR_HEIGHT = 56; // vertical, in dp units
    private float pixelDensity;
    private boolean verticalDimensionsSet;
    public static int screenHeightInVP;
    private int spacingInVP;
    private boolean horizontalDimensionsSet;
    public static int screenHeightInHP;
    private int spacingInHP;
    private Configuration config;

    private LinearLayout ll1, ll2, ll3;
    private TicTacToe tttgame = new TicTacToe();

    private TextView Tv1;


    public static String MA = "MainActivity";
    private int actionBarHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.w(MA, "INSIDE onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GUI();
        tttgame = new TicTacToe();

        Log.w(MA, "INSIDE onCreate");


        Resources res = getResources();
        DisplayMetrics metrics = res.getDisplayMetrics();
        pixelDensity = metrics.density;

        Configuration config = getResources().getConfiguration();

        modifyLayout(config);




    }








    public void setLayoutMargins (int spacing) {

         Button[] barray1 = new Button[3];
         barray1[0] = (Button) buttons[0][0];
         barray1[1] = (Button) buttons[0][1];
         barray1[2] = (Button) buttons[0][2];
         Button[] aB1 = new Button[]{barray1[0], barray1[1], barray1[2],};
        // MarginLayoutParams params1
               //  = (MarginLayoutParams) aB2.getLayouParams();

         Button[] barray2 = new Button[3];
         barray1[0] = (Button) buttons[1][0];
         barray1[1] = (Button) buttons[1][1];
         barray1[2] = (Button) buttons[1][2];
         Button[] aB2 = new Button[]{barray1[0], barray1[1], barray1[2],};
        // MarginLayoutParams params2
                // = (MarginLayoutParams) aB3.getLayouParams();

         Button[] barray3 = new Button[3];
         barray2[0] = (Button) buttons[2][0];
         barray2[1] = (Button) buttons[2][1];
         barray2[2] = (Button) buttons[2][2];
         Button[] aB3 = new Button[]{barray2[0], barray2[1], barray2[2],};
        // ViewGroup.MarginLayoutParams params3
                // = (ViewGroup.MarginLayoutParams) aB3.getLayoutParams();


        // params1.setMargins(0, spacing, 0, 0);
        // params2.setMargins(0, spacing, 0, 0);
        // params3.setMargins(0, spacing, 0, 0);

     }
        @Override
        public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

          modifyLayout(newConfig);
    }


    public void modifyLayout(Configuration config) {
        if( config.orientation == Configuration.ORIENTATION_LANDSCAPE )
            setLayoutMargins( spacingInHP );
        else if (config.orientation == Configuration.ORIENTATION_PORTRAIT)
                setLayoutMargins(spacingInVP);
     }


    // Get width of the screen


    private void GUI() {

        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int w = size.x / TicTacToe.SIDE;


        ButtonHandler bh = new ButtonHandler();
        Log.w(MA, "INSIDE GUI");

        for (int row = 0; row < TicTacToe.SIDE; row++) {
            for (int col = 0; col < TicTacToe.SIDE; col++) {
                Log.w(MA, "ADD BUTTON ID TO LINEAR LAYOUT");
                String buttonID = "button_" + row + col;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[row][col] = findViewById(resID);
                buttons [row][col].setTextSize((int)(w * .2));
                buttons[row][col].setOnClickListener(bh);

            }
        }



    }//end of GUI



    private class ButtonHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            for (int row = 0; row < TicTacToe.SIDE; row++)
                for (int column = 0; column < TicTacToe.SIDE; column++)
                    if (v == buttons[row][column])
                        update(row, column);

        }
    }//end of ButtonHandler




    private void update(int row, int column) {
        Log.w("MainActivity", "Inside modifyLayout");

        if( config.orientation == Configuration.ORIENTATION_LANDSCAPE ){

            Tv1 = findViewById(R.id.tv1);
            int play = tttgame.play(row, column);

            if (play == 1)
                buttons[row][column].setText("A");
            else if (play == 2)
                buttons[row][column].setText("Z");
                if (tttgame.isGameOver()) {
                    Tv1.setBackgroundColor(Color.RED);
                    enableButtons(false);
                    Tv1.setText(tttgame.result());
                    showNewGameDialog();
                }
        } else if (config.orientation == Configuration.ORIENTATION_PORTRAIT) {

            int play = tttgame.play(row, column);
            if (play == 1)
                buttons[row][column].setText("X");
            else if (play == 2)
                buttons[row][column].setText("0");
                if (tttgame.isGameOver()) {
                    Tv1.setBackgroundColor(Color.RED);
                    enableButtons(false);
                    Tv1.setText(tttgame.result());
                    showNewGameDialog();
            }
        }
    }
        private void showNewGameDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("This is fun");
        alert.setMessage("Play agian ?");
        PlayDialog playAgain = new PlayDialog();
        alert.setPositiveButton("YES", playAgain);
        alert.setNegativeButton("NO", playAgain);
        alert.show();
     }
    private class PlayDialog implements DialogInterface.OnClickListener{

        @Override
        public void onClick(DialogInterface dialogInterface, int id) {
            //yes button
            if(id == -1) {
                tttgame.resetGame();
                enableButtons(true);
                resetButtons();
            }
            else if(id == -2){
                MainActivity.this.finish();
            }
        }
    }//end of PlayDialog

    private void resetButtons() {
        for(int row = 0; row < TicTacToe.SIDE; row++ )
            for( int col = 0; col < TicTacToe.SIDE; col++)
                buttons[row][col].setText("");
    }//end of resetButton

    private void enableButtons(boolean enabled) {
        for(int row = 0; row < TicTacToe.SIDE; row++ )
            for( int col = 0; col < TicTacToe.SIDE; col++)
                buttons[row][col].setEnabled(enabled);

    }//end of enableButtons

}//end of Main