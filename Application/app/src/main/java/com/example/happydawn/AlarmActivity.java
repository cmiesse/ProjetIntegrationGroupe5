package com.example.happydawn;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity {

    private Button retour;
    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    TextView updateText;
    Context context;
    PendingIntent pending_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        this.retour = findViewById(R.id.retour);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),Menualarme.class);
                startActivity(otherActivity);
                finish();
            }
        });

        this.context = this;

        //initialise le alarm manager
        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        //initialise le timePicker
        alarm_timepicker = (TimePicker) findViewById(R.id.timePicker);

        //initialise text update
        updateText = (TextView) findViewById(R.id.updateText);

        final Calendar calendar = Calendar.getInstance();

        //intent pour le alarm receiver
        final Intent my_intent = new Intent(this.context, AlarmReceiver.class);

        //initialise button start
        Button startAlarm = (Button) findViewById(R.id.startAlarm);

        startAlarm.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getHour());
                calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getMinute());

                //string de l hour et minute
                int hour = alarm_timepicker.getHour();
                int minute = alarm_timepicker.getMinute();
                String hour_string = String.valueOf(hour);
                String minute_string = String.valueOf(minute);

                if(hour>12){
                    hour_string = String.valueOf(hour - 12);
                }

                if(minute < 10){
                    minute_string = String.valueOf("0" + minute);
                }

                set_alarm_text(" -> Alarme ON" +"\n           "+ hour_string + ":" + minute_string);

                //pending intent
                pending_intent = PendingIntent.getBroadcast(AlarmActivity.this, 0, my_intent
                , PendingIntent.FLAG_UPDATE_CURRENT);

                //set alarm manager
                alarm_manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),pending_intent);
            }
        });
        //initialise button stop
        Button endAlarm = (Button) findViewById(R.id.endAlarm);

        endAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                set_alarm_text(" -> Alarm OFF");

                //anuler l'alarme
                alarm_manager.cancel(pending_intent);
            }
        });
    }

    private void set_alarm_text(String output) {
        updateText.setText(output);
    }



}
