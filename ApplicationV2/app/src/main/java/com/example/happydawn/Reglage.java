package com.example.happydawn;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Reglage extends AppCompatActivity {

    private ImageView retour;
    private Button son;
    AlarmManager alarm_manager;
    TimePicker timePicker;
    Context context;
    TextView updateText;
    PendingIntent pending_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reglage);

        this.retour = findViewById(R.id.retour);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),Alarme.class);
                startActivity(otherActivity);
                finish();
            }
        });

        this.son= findViewById(R.id.son);

        son.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),ListeSons.class);
                startActivity(otherActivity);
                finish();
            }
        });

        this.context = this;

        //initialise le alarm manager
        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        //initialise le timePicker
        timePicker = (TimePicker) findViewById(R.id.timePicker);

        //initialise text update
        updateText = (TextView) findViewById(R.id.updateText);

        final Calendar calendar = Calendar.getInstance();

        //intent pour le alarm receiver
        final Intent my_intent = new Intent(this.context, AlarmReceiver.class);

        //initialise button start
        ImageView valide = findViewById(R.id.valide);

        valide.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getMinute());

                //string de l hour et minute
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();
                String hour_string = String.valueOf(hour);
                String minute_string = String.valueOf(minute);

                if(hour>12){
                    hour_string = String.valueOf(hour - 12);
                }

                if(minute < 10){
                    minute_string = String.valueOf("0" + minute);
                }

                set_alarm_text(" -> Alarme ON" +"\n          "+ hour_string + ":" + minute_string);

                //pending intent
                pending_intent = PendingIntent.getBroadcast(Reglage.this, 0, my_intent
                        , PendingIntent.FLAG_UPDATE_CURRENT);

                //set alarm manager
                alarm_manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),pending_intent);
            }
        });

    }

    private void set_alarm_text(String output) {
        updateText.setText(output);
    }



}