package com.example.neha.explicit_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Second_Activity extends AppCompatActivity
{
     private TextView txtWish;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);

        txtWish=(TextView)findViewById(R.id.txtWish); // Init TextView
        Intent intent=getIntent();
        String data=intent.getStringExtra("WISH");
       int time= intent.getIntExtra("TIME",12);
        txtWish.setText(data + time);    // Set data to txtWish
    }
}
