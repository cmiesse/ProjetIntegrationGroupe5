package com.example.happydawn;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class ListeSons extends AppCompatActivity {

    private ImageView retour;

    protected MediaPlayer foret;
    protected MediaPlayer oiseaux1;
    protected MediaPlayer oiseaux2;
    protected MediaPlayer oiseaux3;
    protected MediaPlayer petitRuisseau;
    protected MediaPlayer petitesVaguesDosOcean;
    protected MediaPlayer petitesVaguesFaceOcean;
    protected MediaPlayer pluieOrage;
    protected MediaPlayer vaguesMouettes;

    private RadioGroup radioGroup;
    private RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_sons);

        this.retour = findViewById(R.id.retour);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),Reglage.class);
                startActivity(otherActivity);
                finish();
            }
        });

        radioGroup = findViewById(R.id.radiogroup);

        final Intent intent22 = new Intent(this, Reglage.class);

        final Button valideson = findViewById(R.id.valideSon);

        valideson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioID = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioID);

                // Récupération du texte du titre Foret Matinale
                //TextView textForet = (TextView) findViewById(R.id.foretMatinale);
                //String textForetus = textForet.getText().toString();

                //Ajoute le texte du son choisi dans le champ "son"
                //valideson.setText(textForetus);

                String strson = radioButton.getText().toString();


                intent22.putExtra("edittext", strson);
                startActivity(intent22);

            }
        }
        );

        foret = MediaPlayer.create(getApplicationContext(),R.raw.foret);
        oiseaux1 = MediaPlayer.create(getApplicationContext(),R.raw.oiseaux1);
        oiseaux2 = MediaPlayer.create(getApplicationContext(),R.raw.oiseaux2);
 //       oiseaux3 = MediaPlayer.create(getApplicationContext(),R.raw.oiseaux3);
        petitRuisseau = MediaPlayer.create(getApplicationContext(),R.raw.petit_ruisseau);
        petitesVaguesDosOcean = MediaPlayer.create(getApplicationContext(),R.raw.petites_vagues_dos_ocean);
 //       petitesVaguesFaceOcean = MediaPlayer.create(getApplicationContext(),R.raw.petites_vagues_face_ocean);
        pluieOrage = MediaPlayer.create(getApplicationContext(),R.raw.pluie_orage);
        vaguesMouettes = MediaPlayer.create(getApplicationContext(),R.raw.vagues_mouettes);

        Button playforet = (Button) findViewById(R.id.playforet);
        Button pauseforet = (Button) findViewById(R.id.pauseforet);
        Button playoiseaux1 = (Button) findViewById(R.id.playoiseau1);
        Button pauseoiseaux1 = (Button) findViewById(R.id.pauseoiseaux1);
        Button playoiseaux2 = (Button) findViewById(R.id.playoiseau2);
        Button pauseoiseaux2 = (Button) findViewById(R.id.pauseoiseaux2);
        Button playPetitRuisseau = (Button) findViewById(R.id.playpetitruisseau);
        Button pausePetitRuisseau = (Button) findViewById(R.id.pausepetitruisseau);
        Button playVagueOcean = (Button) findViewById(R.id.playvaguedosocean);
        Button pauseVagueOcean = (Button) findViewById(R.id.pausevagueoceandos);
        Button playpluieorage = (Button) findViewById(R.id.playpluiorage);
        Button pausepluieorage = (Button) findViewById(R.id.pausepluieorage);
        Button playvaguesMouettes = (Button) findViewById(R.id.playmouettemer);
        Button pausevaguesMouettes = (Button) findViewById(R.id.pausemouettemer);

        playforet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              foret.start();
            }
        });
        pauseforet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foret.pause();
            }
        });

        playoiseaux1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oiseaux1.start();

            }
        });

        pauseoiseaux1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oiseaux1.pause();
            }
        });

        playoiseaux2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oiseaux2.start();
            }
        });
        pauseoiseaux2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oiseaux2.pause();
            }
        });
        playPetitRuisseau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                petitRuisseau.start();
            }
        });
        pausePetitRuisseau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                petitRuisseau.pause();
            }
        });

        playVagueOcean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                petitesVaguesDosOcean.start();
            }
        });

        pauseVagueOcean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                petitesVaguesDosOcean.pause();
            }
        });

        playpluieorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pluieOrage.start();
            }
        });

        pausepluieorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pluieOrage.pause();
            }
        });

        playvaguesMouettes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaguesMouettes.start();
            }
        });

        pausevaguesMouettes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaguesMouettes.pause();
            }
        });



    //    String[] items = {"foret","oiseaux1","oiseaux2","oiseaux3","petitRuisseau","petitesVaguesDosOcean","petitesVaguesFaceOcean","pluieOrage","vaguesMouettes"};
    //    ListView listv = (ListView) findViewById(R.id.list_view);
    //    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.activity_list_item,R.id.txt,items);
    //    listv.setAdapter(adapter);
     //   listv.setOnItemClickListener(new ItemList());

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