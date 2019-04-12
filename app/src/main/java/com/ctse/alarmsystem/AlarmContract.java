package com.ctse.alarmsystem;

import android.provider.BaseColumns;

public final class AlarmContract {

    private AlarmContract() {}

    public static class AlarmTable implements BaseColumns {

        public static final String TABLE_NAME = "alarm_times";
        public static final String COLUMN_ALARM_TIME = "alarmtime";
        public static final String COLUMN_ALARM_STATUS = "alarmstatus";
        public static final String COLUMN_RINGTONE = "ringtone";
        public static final String COLUMN_LABEL = "label";
    }

}
