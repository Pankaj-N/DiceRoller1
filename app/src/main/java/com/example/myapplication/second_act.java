package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class second_act extends AppCompatActivity {

    ArrayList<String>pankaj=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_act);
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


        pankaj.add("If you could go anywhere in the world, where would you go?");
        pankaj.add("If you were stranded on a desert island, what three things would you want to take with you?\n");
        pankaj.add("If you could eat only one food for the rest of your life, what would that be?");
        pankaj.add("If you won a million dollars, what is the first thing you would buy?\n");
        pankaj.add("If you could spaned the day with one fictional character, who would it be?");
        pankaj.add("If you found a magic lantern and a genie gave you three wishes, what would you wish?");

        Random hi = new Random();
        int randText = hi.nextInt(6);
        TextView Question = this.findViewById(R.id.textView4);
        Question.setText(Question.getText() + pankaj.get(randText));


    }

    public void cancel_and_save (View view){
        Intent i =new Intent(second_act.this,MainActivity.class);
        startActivity(i);
    }


}
