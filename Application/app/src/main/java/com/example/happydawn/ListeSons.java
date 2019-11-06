package com.example.happydawn;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListeSons extends AppCompatActivity {

    protected MediaPlayer foret;
    protected MediaPlayer oiseaux1;
    protected MediaPlayer oiseaux2;
    protected MediaPlayer oiseaux3;
    protected MediaPlayer petitRuisseau;
    protected MediaPlayer petitesVaguesDosOcean;
    protected MediaPlayer petitesVaguesFaceOcean;
    protected MediaPlayer pluieOrage;
    protected MediaPlayer vaguesMouettes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_sons);

        foret = MediaPlayer.create(getApplicationContext(),R.raw.foret);
        oiseaux1 = MediaPlayer.create(getApplicationContext(),R.raw.oiseaux1);
        oiseaux2 = MediaPlayer.create(getApplicationContext(),R.raw.oiseaux2);
        oiseaux3 = MediaPlayer.create(getApplicationContext(),R.raw.oiseaux3);
        petitRuisseau = MediaPlayer.create(getApplicationContext(),R.raw.petit_ruisseau);
        petitesVaguesDosOcean = MediaPlayer.create(getApplicationContext(),R.raw.petites_vagues_dos_ocean);
        petitesVaguesFaceOcean = MediaPlayer.create(getApplicationContext(),R.raw.petites_vagues_face_ocean);
        pluieOrage = MediaPlayer.create(getApplicationContext(),R.raw.pluie_orage);
        vaguesMouettes = MediaPlayer.create(getApplicationContext(),R.raw.vagues_mouettes);

        String[] items = {"foret","oiseaux1","oiseaux2","oiseaux3","petitRuisseau","petitesVaguesDosOcean","petitesVaguesFaceOcean","pluieOrage","vaguesMouettes"};
        ListView listv = (ListView) findViewById(R.id.listeSons);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_item,R.id.txt,items);
        listv.setAdapter(adapter);
        listv.setOnItemClickListener(new ItemList());

    }


    private class ItemList implements AdapterView.OnItemClickListener {



        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ViewGroup viewg = (ViewGroup) view;
            TextView textv = (TextView) viewg.findViewById(R.id.txt);
            switch (textv.getText().toString()) {
                case "foret":
                    if(foret.isPlaying()){
                        foret.pause();
                    }
                    else{
                        foret.start();
                    }
                    break;
                case "oiseaux1":
                    if(oiseaux1.isPlaying()){
                        oiseaux1.pause();
                    }
                    else{
                        oiseaux1.start();
                    }
                    break;
                case "oiseaux2":
                    if(oiseaux2.isPlaying()){
                        oiseaux2.pause();
                    }
                    else{
                        oiseaux2.start();
                    }
                    break;
                case "oiseaux3":
                    if(oiseaux3.isPlaying()){
                        oiseaux3.pause();
                    }
                    else{
                        oiseaux3.start();
                    }
                    break;
                case "petitRuisseau":
                    if(petitRuisseau.isPlaying()){
                        petitRuisseau.pause();
                    }
                    else{
                        petitRuisseau.start();
                    }
                    break;
                case "petitesVaguesDosOcean":
                    if(petitesVaguesDosOcean.isPlaying()){
                        petitesVaguesDosOcean.pause();
                    }
                    else{
                        petitesVaguesDosOcean.start();
                    }
                    break;
                case "petitesVaguesFaceOcean":
                    if(petitesVaguesFaceOcean.isPlaying()){
                        petitesVaguesFaceOcean.pause();
                    }
                    else{
                        petitesVaguesFaceOcean.start();
                    }
                    break;
                case "pluieOrage":
                    if(pluieOrage.isPlaying()){
                        pluieOrage.pause();
                    }
                    else{
                        pluieOrage.start();
                    }
                    break;
                case "vaguesMouettes":
                    if(vaguesMouettes.isPlaying()){
                        vaguesMouettes.pause();
                    }
                    else{
                        vaguesMouettes.start();
                    }
                    break;
            }
        }
    }
}
