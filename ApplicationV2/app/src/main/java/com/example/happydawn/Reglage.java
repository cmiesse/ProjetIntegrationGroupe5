package com.example.happydawn;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Reglage extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    private ImageView retour;
    private Button son;
    private TextView textvolume;
    int volume;
    SeekBar seekbar;

    // TextView heure
    public TextView mTextView;

    /*Travail sur l'heure

    //Heure système
    Calendar calend = Calendar.getInstance();
    long heureActuelleMillis = calend.getTimeInMillis();
    Date date1 = new Date(heureActuelleMillis * 1000);

    // Heure de l'utilisateur
    TextView textViewHeure = findViewById(R.id.textView);
    String heureEntree = textViewHeure.getText().toString();
    Date date2;
    {
        try {
            date2 = new SimpleDateFormat().parse(heureEntree);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // Calcul
    long difference = date1.getTime() - date2.getTime();
    int days = (int) (difference / (1000*60*60*24));
    int  heuresDifferences = (int) ((difference - (1000*60*60*24*days)) / (1000*60*60));
    int minutesDifferences = (int) (difference - (1000*60*60*24*days) - (1000*60*60*heuresDifferences)) / (1000*60);
    long differenceEnMilli = (long) (heuresDifferences) + (minutesDifferences);

    
     */

    //augmentation
    private Button augmentation;
    String[] listItem1;
    TextView textAugmentation;

    //luminosite
    private Button luminosite;
    String[] listItem2;
    TextView textLuminosite;

    //couleur
    private Button couleur;
    String[] listItem3;
    TextView textCouleur;

    //duree
    private Button duree;
    String[] listItem4;
    TextView textDuree;


    //nom de l'alarme
    TextView nomalarme;
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



        final Calendar calendar = Calendar.getInstance();

        //intent pour le alarm receiver
        final Intent my_intent = new Intent(this.context, AlarmReceiver.class);

        //initialise button start
        ImageView valide = findViewById(R.id.valide);

        final Intent intent17 = new Intent(this, Alarme.class);


        valide.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                //nom
                TextView textview0 = findViewById(R.id.nomalarme);
                // String du nom de l'alarme
                String str = textview0.getText().toString();

                intent17.putExtra("edittext", str);
                startActivity(intent17);

                //heure
                TextView textViewHeure = findViewById(R.id.textView);
                // String de l'heure
                String stringHeure = textViewHeure.getText().toString();

                intent17.putExtra("edittext10", stringHeure);



                //son
                TextView textview1 = findViewById(R.id.txtson);
                // String du son choisi
                String str1 = textview1.getText().toString();

                intent17.putExtra("edittext2", str1);


                //volume
                TextView textview2 = findViewById(R.id.textvolume);
                // String du volume
                String str2 = textview2.getText().toString();

                intent17.putExtra("edittext3", str2);


                //luminosite
                TextView textview3 = findViewById(R.id.txtluminosite);
                // String de la luminosité
                String str3 = textview3.getText().toString();

                intent17.putExtra("edittext4", str3);


                //couleur
                TextView textview4 = findViewById(R.id.txtcouleur);
                // String de la couleur choisie
                String str4 = textview4.getText().toString();

                intent17.putExtra("edittext5", str4);




                //augmentation
                TextView textview6 = findViewById(R.id.txtaugmentation);
                // String de la'augmentation
                String str6 = textview6.getText().toString();

                intent17.putExtra("edittext7", str6);

                // duree
                TextView textview5 = findViewById(R.id.txtduree);
                // String de la duree
                String str5 = textview5.getText().toString();

                intent17.putExtra("edittext6", str5);
                startActivity(intent17);


            }
        });

        mTextView = findViewById(R.id.textView);

        Button button = (Button) findViewById(R.id.button_timepicker);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");

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



        augmentation = findViewById(R.id.augmentation);
        textAugmentation = findViewById(R.id.txtaugmentation);
        augmentation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listItem1 = new String[]{"ttes les 5 min", "ttes les 10 min", "ttes les 15 min"};
                AlertDialog.Builder builder1 = new AlertDialog.Builder(Reglage.this);
                builder1.setTitle("augmentation");
                builder1.setIcon(R.drawable.icon);
                builder1.setSingleChoiceItems(listItem1, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        textAugmentation.setText(listItem1[i]);
                        dialog.dismiss();
                    }
                });
                builder1.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertdialog1 = builder1.create();
                alertdialog1.show();
            }
        });



        luminosite = findViewById(R.id.luminosite);
        textLuminosite = findViewById(R.id.txtluminosite);
        luminosite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listItem2 = new String[]{"25 %", "50 %", "75 %", "100 %"};
                AlertDialog.Builder builder2 = new AlertDialog.Builder(Reglage.this);
                builder2.setTitle("luminosité");
                builder2.setIcon(R.drawable.icon);
                builder2.setSingleChoiceItems(listItem2, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        textLuminosite.setText(listItem2[i]);
                        dialog.dismiss();
                    }
                });
                builder2.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertdialog2 = builder2.create();
                alertdialog2.show();
            }
        });


        couleur = findViewById(R.id.couleurs);
        textCouleur = findViewById(R.id.txtcouleur);
        couleur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listItem3 = new String[]{"Bleu", "Vert", "Rouge", "Jaune"};
                AlertDialog.Builder builder3 = new AlertDialog.Builder(Reglage.this);
                builder3.setTitle("couleurs");
                builder3.setIcon(R.drawable.icon);
                builder3.setSingleChoiceItems(listItem3, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        textCouleur.setText(listItem3[i]);
                        dialog.dismiss();
                    }
                });
                builder3.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertdialog3 = builder3.create();
                alertdialog3.show();
            }
        });


        duree = findViewById(R.id.duree);
        textDuree = findViewById(R.id.txtduree);
        duree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listItem4 = new String[]{"15 minutes", "20 minutes", "30 minutes", "45 minutes"};
                AlertDialog.Builder builder4 = new AlertDialog.Builder(Reglage.this);
                builder4.setTitle("couleurs");
                builder4.setIcon(R.drawable.icon);
                builder4.setSingleChoiceItems(listItem4, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        textDuree.setText(listItem4[i]);
                        dialog.dismiss();
                    }
                });
                builder4.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertdialog4 = builder4.create();
                alertdialog4.show();
            }
        });

        //son

        Intent intent22 = getIntent();
        if (intent22 != null){
            String strson = "son";
            if (intent22.hasExtra("edittext")){
                strson = intent22.getStringExtra("edittext");
            }
            TextView textView = findViewById(R.id.txtson);
            textView.setText(strson);
        }







    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);

        updateTimeText(c);
        startAlarm(c);
    }

    public void updateTimeText(Calendar c){
        String timeText = "";
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());

        mTextView.setText(timeText);
    }
    private void startAlarm(Calendar c){
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, Alarme.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0 );

        if(c.before(Calendar.getInstance())){
            c.add(Calendar.DATE, 1);
        }

        alarmManager.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pending_intent );

    }

    private void set_alarm_text(String output) {
        updateText.setText(output);
    }

    /* Fonctions pour adapter les données reçus par l'utilisateur en données
     lisibles par l'arduino */

    /**
     * @param s String contenant la couleur : bleu, vert, rouge ou jaune
     * @return un entier correspondant a la couleur entree en parametre
     */
    private int setColor(String s){
        switch(s){
            case "bleu":
                return 1;
            case "vert":
                return 2;
            case "rouge":
                return 3;
            case "jaune":
                return 4;
            default :
                return 0;
        }
    }

    /**
     * @param s String contenant la luminosite en pourcentage : 25 %, 50 %, 75 % ou 100 %
     * @return un entier correspondant au pourcentage applique sur la luminosite maximale 255
     */
    private int setLuminosity(String s){
        String onlyValue = "";
        if(s.equals("100 %")){
            onlyValue = s.substring(0,3);
        }
        else {
            onlyValue = s.substring(0,2);
        }

        return (255 * Integer.parseInt(onlyValue)) / 100;
    }

    /**
     * @param s String contenant l'intitule du son a jouer
     * @return un entier representant le son a envoyer a l'arduino
     */
    private int setSon(String s){
        switch(s){
            case "Foret Matinale":
                return 1;
            case "Oiseaux 1":
                return 2;
            case "Oiseaux 2":
                return 3;
            case "Petit Ruisseaux":
                return 4;
            case "Vague Ocean":
                return 5;
            case "Pluie/Orage":
                return 6;
            case "Mouettes Mer":
                return 7;
            default :
                return 0;
        }
    }










}