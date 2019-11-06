package com.example.happydawn;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
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

        //initialise button start
        Button startAlarm = (Button) findViewById(R.id.startAlarm);

        startAlarm.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getHour());
                calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getMinute());

                set_alarm_text(" -> Alarme ON");
            }
        });
        //initialise button stop
        Button endAlarm = (Button) findViewById(R.id.endAlarm);

        endAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                set_alarm_text(" -> Alarm OFF");
            }
        });
    }

    private void set_alarm_text(String output) {
        updateText.setText(output);
    }



}
