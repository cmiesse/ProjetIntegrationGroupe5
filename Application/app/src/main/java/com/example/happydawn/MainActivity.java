package com.example.happydawn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton luminosity;
    private ImageButton alarm;
    private ImageButton sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.luminosity = findViewById(R.id.luminosity);

        luminosity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),LuminosityActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

        this.alarm = findViewById(R.id.alarm);

        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),Menualarme.class);
                startActivity(otherActivity);
                finish();
            }
        });

        this.sound = findViewById(R.id.sound);

        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),SoundActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });


    }
}
