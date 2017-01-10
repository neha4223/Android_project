package com.example.neha.firebasedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity
{
    private EditText etxNewUsername, etxNewPassword, etxRePassword, etxNewEmail;
    private Button btnCreateAccount;

    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnCreateAccount = (Button) findViewById(R.id.btnCreateAccount);
        etxNewUsername = (EditText) findViewById(R.id.etxNewUsername);
        etxNewPassword = (EditText) findViewById(R.id.etxNewPassword);
        etxRePassword = (EditText) findViewById(R.id.etxRePassword);
        etxNewEmail = (EditText) findViewById(R.id.etxNewEmail);

        btnCreateAccount.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String username = etxNewUsername.getText().toString();
                String password = etxNewPassword.getText().toString();
                String rePassword = etxRePassword.getText().toString();
                String email = etxNewEmail.getText().toString();

                // Create Key
                String key = username + "USERX";

                // Check for Same passwords
                if (!password.equals(rePassword))
                {
                    etxNewPassword.setError("Password does not match");
                    etxRePassword.setError("Password does not match");
                    return;
                }

                // These two lines of code will point to Root of Firebase DB
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = firebaseDatabase.getReference();

                DatabaseReference keyChildDBR = databaseReference.child("UserDetails").child(key);
                keyChildDBR.child("Username").setValue(username);
                keyChildDBR.child("Password").setValue(password);
                keyChildDBR.child("Email").setValue(email)
                        .addOnSuccessListener(new OnSuccessListener<Void>()
                        {
                            @Override
                            public void onSuccess(Void aVoid)
                            {
                                Toast.makeText(SignUpActivity.this, "Account Created", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}
