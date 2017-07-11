package com.abhimanyusharma.hewlett_packard_training;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyBroadCastReceiver1 extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Bundle bundle = intent.getExtras();
        if (bundle != null)
        {   String state = bundle.getString("state");  //TelephonyManager.EXTRA_STATE
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING))
            {   String str = "Please receive karooo....";
                Toast.makeText(context, str, Toast.LENGTH_LONG).show();
                Toast.makeText(context, TelephonyManager.EXTRA_STATE_RINGING, Toast.LENGTH_LONG).show();
            }
        }
    }

}
