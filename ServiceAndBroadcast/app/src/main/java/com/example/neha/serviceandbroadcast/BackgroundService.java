package com.example.neha.serviceandbroadcast;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;



/**
 * Created by neha on 12/24/16.
 */

public class BackgroundService extends Service
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        Toast.makeText(this, "Count Down started. Run.", Toast.LENGTH_SHORT).show();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        // Always write code here.
        CountDownTimer countDownTimer = new CountDownTimer(30000, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.d("TAG", "Tick Tock. Bomb Deployed.");
            }

            @Override
            public void onFinish() {
                Log.d("TAG", "Boom!!!");
                // Stop a service on its own.
                stopSelf();
            }
        };
        // countDownTimer.start();


        Reciever receiver = new Reciever();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_HEADSET_PLUG);

        registerReceiver(receiver, intentFilter);


        return START_STICKY;
    }


        @Override
        public IBinder onBind (Intent intent)
        {
            return null;
        }
    }
