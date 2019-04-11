package com.ctse.alarmsystem;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Alarm fired", Toast.LENGTH_LONG).show();
        System.out.println("Alarm Fired");
        Log.i("broadcast receiver", "Alarm Fired");

        Intent alarmFiredIntent = new Intent(context, AlarmFiredActivity.class);

        alarmFiredIntent.putExtra("lock", true);

        alarmFiredIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(alarmFiredIntent);
    }
}
