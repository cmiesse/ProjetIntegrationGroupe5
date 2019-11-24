package com.example.happydawn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class edit_text_5 extends AppCompatActivity {

    String aug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text_5);

        Spinner spinner = findViewById(R.id.textDuree);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.duree, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        aug = spinner.getSelectedItem().toString();
    }

    public void ChangeActivity(View view){
        Spinner editText = findViewById(R.id.textDuree);
        String str = editText.getSelectedItem().toString();

        Intent intent = new Intent(this, Reglage.class);

        intent.putExtra("texteduree", str);

        startActivity(intent);
    }
}
