package com.example.neha.explicit_intent;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import static android.app.ActivityOptions.makeSceneTransitionAnimation;

public class MainActivity extends AppCompatActivity
{
    private Button btnStartNewActivit;
    private ImageView imgPhotu;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         /*
        * There are two types of Intents:
        * 1. Implicit Intent - If the Source Activity and Destination Activity, both are in different
        *                      applications, then it is known as Implicit Intent.
        *
        * 2. Explicit Intent - If the Source Activity and Destination Activity, both are from same
        *                      application, then it is Explicit Intent.
        *
        * */
          btnStartNewActivit=(Button)findViewById(R.id.btnStartNewActivity);
          imgPhotu=(ImageView)findViewById(R.id.imgPhotu);

        btnStartNewActivit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                    ActivityOptionsCompat activityOptionsCompat= ActivityOptionsCompat
                       .makeSceneTransitionAnimation(MainActivity.this,imgPhotu,"IMAGE_ANIM");

                // Here we will start a new Activity
                Intent intent = new Intent(MainActivity.this, Second_Activity.class);
                intent.putExtra("WISH", "Happy New Year ");    // Send data to Destination Activity
                intent.putExtra("TIME", 2017);    // Send Integer Value
                ActivityCompat.startActivity(MainActivity.this, intent, activityOptionsCompat.toBundle());
            }
        });
    }
}
