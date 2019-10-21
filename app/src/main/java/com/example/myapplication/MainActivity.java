package com.example.myapplication;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
        int Count= 0;
        int guessCount = 0;
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
        String text_check = Num1.getText().toString();



        if(text_check.isEmpty()||text_check == null){

            RandomNumber.setText("Please enter a value between 1 - 6");
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



    }
    public void scoreBoard(View view){
        Count++;
        TextView scoreCard = this.findViewById(R.id.score);
        scoreCard.setText("Your Score: " + Count);
        TextView messageBox = this.findViewById(R.id.textView6);
        messageBox.setText("Congratulations! You earned +1 point");

    }
    public void notMatch (View view){
        TextView messageBox = this.findViewById(R.id.textView6);
        messageBox.setText("You Lose! You earned 0 points");
    }
}
