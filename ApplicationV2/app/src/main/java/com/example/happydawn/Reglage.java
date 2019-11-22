package com.example.happydawn;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Reglage extends AppCompatActivity {

    private ImageView retour;
    private Button son;
    private Button luminosite;
    private Button couleurs;
    private Button duree;
    private TextView textvolume;
    int volume;
    SeekBar seekbar;

    //augmentation de l'alarme
    private Button augmentation;
    Button button1,Submit1;
    AlertDialog.Builder builder1;
    LayoutInflater layoutinflater1;
    EditText edittext1;
    AlertDialog alertdialog1;

    //nom de l'alarme
    TextView nomalarme;
    private Button libelle;
    Button button,Submit;
    AlertDialog.Builder builder;
    LayoutInflater layoutinflater;
    EditText edittext;
    AlertDialog alertdialog;
    String EditTextValue;

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
                Intent otherActivity = new Intent(getApplicationContext(), Alarme.class);
                startActivity(otherActivity);
                finish();
            }
        });

        this.son = findViewById(R.id.son);

        son.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), ListeSons.class);
                startActivity(otherActivity);
                finish();
            }
        });

        this.context = this;

        //initialise le alarm manager
        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        //initialise le timePicker
        timePicker = findViewById(R.id.timePicker);

        //initialise text update
        updateText = findViewById(R.id.updateText);

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

                if (hour > 12) {
                    hour_string = String.valueOf(hour - 12);
                }

                if (minute < 10) {
                    minute_string = String.valueOf("0" + minute);
                }

                set_alarm_text(" -> Alarme ON" + "\n          " + hour_string + ":" + minute_string);

                //pending intent
                pending_intent = PendingIntent.getBroadcast(Reglage.this, 0, my_intent
                        , PendingIntent.FLAG_UPDATE_CURRENT);

                //set alarm manager
                alarm_manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pending_intent);
            }
        });


        textvolume = findViewById(R.id.textvolume);
        seekbar = findViewById(R.id.seekBar);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textvolume.setText(getString(R.string.volume, progress));
                volume = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        luminosite = findViewById(R.id.luminosite);
        luminosite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup_luminosite = new PopupMenu(Reglage.this,luminosite);
                popup_luminosite.getMenuInflater().inflate(R.menu.popup_luminosite, popup_luminosite.getMenu());

                popup_luminosite.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(Reglage.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popup_luminosite.show();
            }
        });

        couleurs = findViewById(R.id.couleurs);
        couleurs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup_couleurs = new PopupMenu(Reglage.this,couleurs);
                popup_couleurs.getMenuInflater().inflate(R.menu.popup_couleur, popup_couleurs.getMenu());

                popup_couleurs.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(Reglage.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popup_couleurs.show();
            }
        });

        duree = findViewById(R.id.duree);
        duree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup_duree = new PopupMenu(Reglage.this,duree);
                popup_duree.getMenuInflater().inflate(R.menu.popup_duree, popup_duree.getMenu());

                popup_duree.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(Reglage.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

                popup_duree.show();
            }
        });


        nomalarme = findViewById(R.id.nomalarme);
        button = findViewById(R.id.libelle);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder = new AlertDialog.Builder(Reglage.this);

                layoutinflater = getLayoutInflater();

                View Dview = layoutinflater.inflate(R.layout.edit_text,null);

                builder.setCancelable(false);

                builder.setView(Dview);

                edittext = Dview.findViewById(R.id.textNom);
                Submit = Dview.findViewById(R.id.buttonValideNom);

                alertdialog = builder.create();

                Submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        alertdialog.cancel();

                        EditTextValue = edittext.getText().toString();

                        nomalarme.setText(EditTextValue);
                    }
                });

                alertdialog.show();
            }
        });


        button1 = findViewById(R.id.augmentation);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder1 = new AlertDialog.Builder(Reglage.this);

                layoutinflater1 = getLayoutInflater();

                View Dview = layoutinflater1.inflate(R.layout.activity_edit_text_2,null);

                builder1.setCancelable(false);

                builder1.setView(Dview);

                alertdialog1 = builder1.create();

                alertdialog1.show();
            }
        });

    }

    private void set_alarm_text(String output) {
        updateText.setText(output);
    }



}