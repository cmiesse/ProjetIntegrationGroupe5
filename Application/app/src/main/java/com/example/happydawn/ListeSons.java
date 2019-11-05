package com.example.happydawn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListeSons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_sons);
        String[] items = {"Oiseau","Mer","Pluie","Coq"};
        ListView listv = (ListView) findViewById(R.id.listeSons);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_item,R.id.txt,items);
        listv.setAdapter(adapter);
        listv.setOnItemClickListener(new ItemList());

    }

    private class ItemList implements AdapterView.OnItemClickListener {

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ViewGroup viewg = (ViewGroup) view;
            TextView textv = (TextView) viewg.findViewById(R.id.txt);
            Toast.makeText(ListeSons.this, textv.getText().toString(), Toast.LENGTH_LONG).show();
        }
    }
}
