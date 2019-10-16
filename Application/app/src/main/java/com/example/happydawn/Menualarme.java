package com.example.happydawn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Menualarme extends AppCompatActivity {

    private ImageButton agenda;
    private ImageButton reveil;
    private Button retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menualarme);

        this.agenda = findViewById(R.id.agenda);

        agenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),CalendrierActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

        this.reveil = findViewById(R.id.reveil);

        reveil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),AlarmActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

        this.retour = findViewById(R.id.retour);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });
    }
}
