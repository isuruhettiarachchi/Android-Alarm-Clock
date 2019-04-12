package com.ctse.alarmsystem;

import android.net.Uri;

public class Alarm {

    private long alarmTime;
    private boolean alarmStatus;
    private Uri ringtoneUri;

    public Alarm() {}

    public Alarm(long alarmTime, boolean alarmStatus, Uri ringtoneUri) {
        this.alarmTime = alarmTime;
        this.alarmStatus = alarmStatus;
        this.ringtoneUri = ringtoneUri;
    }

    public long getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(long alarmTime) {
        this.alarmTime = alarmTime;
    }

    public boolean isAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(boolean alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    public Uri getRingtoneUri() {
        return ringtoneUri;
    }

    public void setRingtoneUri(Uri ringtoneUri) {
        this.ringtoneUri = ringtoneUri;
    }
}
