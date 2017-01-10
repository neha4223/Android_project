package com.example.neha.serviceandbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by neha on 12/25/16.
 */

public class Reciever extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Toast.makeText(context, "Headphone connected or disconnected.", Toast.LENGTH_SHORT).show();

    }
}
