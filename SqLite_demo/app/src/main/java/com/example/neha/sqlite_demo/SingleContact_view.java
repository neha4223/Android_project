package com.example.neha.sqlite_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SingleContact_view extends AppCompatActivity
{
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_contact_view);

        textView=(TextView)findViewById(R.id.txtDetails);


        Intent intent = getIntent();
        String name = intent.getStringExtra("SELECTED_NAME");

        SQLiteDatabaseHelper sqLiteDatabaseHelper =new SQLiteDatabaseHelper(this, null, null,0);
        StringBuilder stringBuilder =sqLiteDatabaseHelper.getSingleContact(name);

      // textView.setText();

        Toast.makeText(this, "" + stringBuilder.toString(), Toast.LENGTH_SHORT).show();
    }
}
