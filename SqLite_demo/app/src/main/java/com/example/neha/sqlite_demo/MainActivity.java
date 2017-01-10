package com.example.neha.sqlite_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Button btnSaveToDB,btnViewData;
    private EditText etxName, etxNumber, etxEmail, etxCity;
    private SQLiteDatabaseHelper sqLiteDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSaveToDB=(Button)findViewById(R.id.btnSave);
        btnViewData=(Button)findViewById(R.id.btnViewData);
        etxName=(EditText)findViewById(R.id.etxName);
        etxNumber=(EditText)findViewById(R.id.etxNumber);
        etxEmail=(EditText)findViewById(R.id.etxEmail);
        etxCity=(EditText)findViewById(R.id.etxCity);


        sqLiteDatabaseHelper=new SQLiteDatabaseHelper(
                MainActivity.this,"Pass Anything",
                null,
                500);

        sqLiteDatabaseHelper.getWritableDatabase();

        btnSaveToDB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String name=etxName.getText().toString();
                String number=etxNumber.getText().toString();
                String email=etxEmail.getText().toString();
                String city=etxCity.getText().toString();

               boolean flag= sqLiteDatabaseHelper.addStudentDetails(name,number,email,city);

                if (flag)
                    Toast.makeText(MainActivity.this,"Data Saved", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"Failed to Save Data", Toast.LENGTH_SHORT).show();
            }
        });
btnViewData.setOnClickListener(new View.OnClickListener()
{
    @Override
    public void onClick(View v)
    {
        Intent viewDataIntent=new Intent(MainActivity.this,ViewContact.class);
        startActivity(viewDataIntent);
    }
});

    }
}
