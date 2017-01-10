package com.example.neha.firebasedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity
{
    private Button btnLogin, btnSignup;
    private EditText etxUsername, etxPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // Chat App: https://www.youtube.com/watch?v=wVCz1a3ogqk
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnSignup = (Button)findViewById(R.id.btnSignUp);
        etxUsername = (EditText)findViewById(R.id.etxUserName);
        etxPassword = (EditText)findViewById(R.id.etxPassword);

        btnSignup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                 final String username = etxUsername.getText().toString();
                final String password = etxPassword.getText().toString();

                String key = username + "USERX";

                FirebaseDatabase firebaseDatabase =  FirebaseDatabase.getInstance();
             DatabaseReference rootDBR = firebaseDatabase.getReference();

                DatabaseReference childDBR = rootDBR.child("UserDetails").child(key);

                childDBR.addValueEventListener(new ValueEventListener()
                {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot)
                    {

                        //Here
                        String serverUsername = dataSnapshot.child("Username").getValue().toString();
                        String serverPassword = dataSnapshot.child("Password").getValue().toString();

                        //Compare
                        if (serverUsername.equals(username) && serverPassword.equals(password))
                        {
                            Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                           Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                        Log.d("TAG", "" + dataSnapshot.toString());
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError)
                    {
                        Toast.makeText(MainActivity.this, "Connection Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
