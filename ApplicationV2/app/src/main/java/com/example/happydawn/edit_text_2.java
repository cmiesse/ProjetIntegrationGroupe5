package com.example.happydawn;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class edit_text_2 extends AppCompatActivity {

    String aug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_2);

        Spinner spinner = findViewById(R.id.textAugmentation);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.augmentation1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        aug = spinner.getSelectedItem().toString();



    }
}
