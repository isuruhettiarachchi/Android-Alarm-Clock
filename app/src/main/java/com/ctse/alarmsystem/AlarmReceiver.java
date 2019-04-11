package com.ctse.alarmsystem;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm fired", Toast.LENGTH_LONG).show();
        System.out.println("Alarm Fired");
        Log.i("broadcast receiver", "Alarm Fired");
    }
}
