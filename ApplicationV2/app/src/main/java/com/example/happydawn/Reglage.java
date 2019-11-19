package com.example.happydawn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Reglage extends AppCompatActivity {

    private ImageView retour;
    private Button son;

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

    }
}
