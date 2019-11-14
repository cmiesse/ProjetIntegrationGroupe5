package com.example.happydawn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class jour_calendrier extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jour_calendrier);

        TextView textView = findViewById(R.id.jour);
        Button button = findViewById(R.id.retourCalendrier);

        String date = getIntent().getStringExtra("date");
        if(date!= null)
            textView.setText(date);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(jour_calendrier.this, CalendrierActivity.class);
                startActivity(intent);
            }
        });
    }
}
