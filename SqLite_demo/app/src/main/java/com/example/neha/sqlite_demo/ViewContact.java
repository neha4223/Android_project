package com.example.neha.sqlite_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewContact extends AppCompatActivity
{
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_contact);

        SQLiteDatabaseHelper sqLiteDatabaseHelper = new SQLiteDatabaseHelper(
                this,null,null,332);
        ArrayList<String> arrayList = sqLiteDatabaseHelper.getFirsNames();


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                ViewContact.this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                arrayList
        );
        listView =(ListView)findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedName = parent.getItemAtPosition(position).toString();

                Intent singleContactIntent=new Intent(ViewContact.this, SingleContact_view.class);

                singleContactIntent.putExtra("SELECTED_NAME", selectedName);
                startActivity(singleContactIntent);
            }
        });
    }
}
