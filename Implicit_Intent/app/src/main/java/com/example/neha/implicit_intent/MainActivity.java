package com.example.neha.implicit_intent;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import static com.example.neha.implicit_intent.R.id.imgPhotu;

public class MainActivity extends AppCompatActivity
{
    private EditText etxMessage;
    private Button btnSend;
    private Button btnStartNewActivity;
    private ImageView imgPhotu;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // Figure out How to send Image to WhatsApp?
        // Figure out How your App can receive Images?
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etxMessage=(EditText)findViewById(R.id.etxMessage);
        btnSend=(Button)findViewById(R.id.btnSend);
        btnStartNewActivity=(Button)findViewById(R.id.btnStartNewActivity);
        imgPhotu=(ImageView)findViewById(R.id.imgPhotu);

        btnStartNewActivity.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ActivityOptionsCompat activityOptions =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(
                                MainActivity.this,
                                imgPhotu,
                                "IMAGE_ANIM");

                // Here we will start a new Activity
                Intent intent = new Intent(MainActivity.this, Second_Activity.class);
                intent.putExtra("WISH", "Good Morning ");    // Send data to Destination Activity
                intent.putExtra("TIME", 9);    // Send Integer Value
                ActivityCompat.startActivity(MainActivity.this, intent, activityOptions.toBundle());
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String message = etxMessage.getText().toString();

                Intent implicitIntent = new Intent(Intent.ACTION_SEND);
                implicitIntent.putExtra(Intent.EXTRA_TEXT, message);
                implicitIntent.setType("text/plain");
               // implicitIntent.setPackage("com.whatsapp");
                startActivity(implicitIntent);
            }
        });
        // Code to Receive from Other Apps
        Intent intent = getIntent();
        String otherAppMessage = intent.getStringExtra(Intent.EXTRA_TEXT);
        etxMessage.setText(otherAppMessage);
    }
}
