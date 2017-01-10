package com.example.neha.serviceandbroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity

{
    private Button startActivity, registerReciever;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity=(Button)findViewById(R.id.startActivity);
        startActivity.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // Start a service
                Intent serviceIntent=new Intent(MainActivity.this, BackgroundService.class);
                startService(serviceIntent);


            }
        });
        registerReciever = (Button) findViewById(R.id.registerReciever);
        registerReciever.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Reciever receiver = new Reciever();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

                registerReceiver(receiver, intentFilter);
            }
        });


        /*CountDownTimer countDownTimer = new CountDownTimer(60000, 2000)
        {
            @Override
            public void onTick(long millisUntilFinished)
            {
                Log.d("TAG", "Tick Tock. Bomb Deployed.");
            }

            @Override
            public void onFinish()
            {
                Log.d("TAG", "Boom!!!");
            }
        };

        countDownTimer.start();*/
    }
}


