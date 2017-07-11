package com.abhimanyusharma.hewlett_packard_training;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadCastReceiver2 extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        String str = intent.getAction();
        Toast.makeText(context , "BroadcastReceiver got the message from OS", Toast.LENGTH_LONG).show();
        Toast.makeText(context , "Phone startup completed.", Toast.LENGTH_LONG).show();
    }
}
