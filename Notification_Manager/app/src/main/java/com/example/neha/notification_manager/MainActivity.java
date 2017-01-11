package com.example.neha.notification_manager;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    private Button btnShowNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowNotification = (Button)findViewById(R.id.btnShowNotification);
        btnShowNotification.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                // Create a Notification
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
                builder.setContentTitle("Happy New Year 2017");
                builder.setContentText("Bye bye 2016. Welcome 2017");
                builder.setSmallIcon(R.drawable.ic_alarm_on_black_24dp);
                builder.setColor(Color.RED);
                builder.setOngoing(true);
                builder.setPriority(Notification.PRIORITY_MAX);

                // Click listener for Notification

                Intent intent = new Intent(MainActivity.this, MainActivity.class);

                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 3132, intent, 0);
                builder.setContentIntent(pendingIntent);

                builder.addAction(R.drawable.ic_alarm_on_black_24dp, "Read", null);

                //show Notification
                notificationManager.notify(3132,builder.build());
            }
        });
    }
}
