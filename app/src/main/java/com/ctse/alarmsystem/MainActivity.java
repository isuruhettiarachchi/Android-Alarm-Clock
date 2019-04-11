package com.ctse.alarmsystem;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    FloatingActionButton addAlarmButton;
    Button setRingtoneButton;
    Uri ringtoneUri;
    Switch alarmSwitch;
    Calendar calendar;

    Intent alarmIntent;
    PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addAlarmButton = findViewById(R.id.addAlarmButton);
        setRingtoneButton = findViewById(R.id.setRingtoneButton);
        alarmSwitch = findViewById(R.id.alarmSwitch);

        ringtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);

        calendar = Calendar.getInstance();

        alarmIntent = new Intent(this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0);

        setRingtone(ringtoneUri);

        addAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");

            }
        });

        setRingtoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
                intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_ALARM);
                startActivityForResult(intent, 1);
            }
        });

        alarmSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    Log.i("time in millis", String.valueOf(calendar.getTimeInMillis()));
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
                    Toast.makeText(MainActivity.this, "Alarm Set", Toast.LENGTH_SHORT).show();
                } else {
                    alarmManager.cancel(pendingIntent);
                }
            }
        });
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView alarmTime = findViewById(R.id.alarmTimeTextView);
        alarmTime.setText(hourOfDay + ":" + minute);

        Log.i("time picker hour", String.valueOf(hourOfDay));
        Log.i("calender hour", String.valueOf(calendar.get(Calendar.HOUR)));

        Log.i("time picker min", String.valueOf(minute));
        Log.i("calender min", String.valueOf(calendar.get(Calendar.MINUTE)));


        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE,  minute);
        calendar.set(Calendar.SECOND, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                ringtoneUri = data.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);
                setRingtone(ringtoneUri);
            }
        }
    }

    public void setRingtone(Uri ringtoneUri) {
        Ringtone ringtone = RingtoneManager.getRingtone(this, ringtoneUri);
        String ringtoneName = ringtone.getTitle(this);
        setRingtoneButton.setText(ringtoneName);
    }
}
