package com.ctse.alarmsystem;

import android.net.Uri;

public class Alarm {

    private long alarmTime;
    private boolean alarmStatus;
    private Uri ringtoneUri;
    private String label;

    public Alarm() {}

    public Alarm(long alarmTime, boolean alarmStatus, Uri ringtoneUri, String label) {
        this.alarmTime = alarmTime;
        this.alarmStatus = alarmStatus;
        this.ringtoneUri = ringtoneUri;
        this.label = label;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
