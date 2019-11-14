package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
        int Count= 0;  //score count
        int guessCount = 0; //guesscount
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void OnClick(View view){
        TextView RandomNumber = this.findViewById(R.id.textView);
        EditText Num1 = this.findViewById(R.id.editText2);

        try {
            //app wont crash if the input box is empty
            String text_check = Num1.getText().toString();
            int Num3 = Integer.parseInt(Num1.getText().toString());




           if(Num3 == 0 || Num3 >=7){

                RandomNumber.setText("Please enter a value between 1 - 6");//displays this
            }
            else{

                guessCount++;
                TextView tv = this.findViewById(R.id.num00);
                TextView guessCounter = this.findViewById(R.id.textView3);
                Random r = new Random();

                int randNum = r.nextInt(7-1)+1;
                int Num2 = Integer.parseInt(Num1.getText().toString());

                if(Num2 == randNum){
                    scoreBoard(view);
                }

                if(Num2 != randNum){
                    notMatch(view);
                }

                String CompGen = String.valueOf(randNum);

                tv.setText("Computer Number: \r" + CompGen);
                RandomNumber.setText("Your Number: \r" + Num2);
                guessCounter.setText("Guess Counter: \n" + guessCount);

            }
        } catch (Exception ex){
            Log.e("Error!", "Error!", ex);

        }


    }
    public void scoreBoard(View view){
        Count++;
        TextView scoreCard = this.findViewById(R.id.score);
        scoreCard.setText("Your Score: " + Count);
        TextView messageBox = this.findViewById(R.id.textView6);
        messageBox.setText("Congratulations! You earned +1 point");
        Button Lucky1 = (Button) findViewById(R.id.Button);
        Lucky1.setVisibility(View.INVISIBLE);
        Button Lucky = (Button) findViewById(R.id.button);
        Lucky.setVisibility(View.VISIBLE);

    }
    public void notMatch (View view){
        TextView messageBox = this.findViewById(R.id.textView6);
        messageBox.setText("You Lose! You earned 0 points");
    }
    public void roll_the_dice(View view){
        Intent myIntent = new Intent (MainActivity.this, second_act.class);
        startActivity(myIntent);

        }


}

