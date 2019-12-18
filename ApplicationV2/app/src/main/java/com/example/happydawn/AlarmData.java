package com.example.happydawn;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.util.Log;

import java.io.Serializable;
import java.lang.annotation.Target;
import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class AlarmData implements Serializable {
    //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");

    static MessageFormat msgFormat = new MessageFormat("{0,number,##}:{1,number,##}");

    static Calendar calendar = Calendar.getInstance();

    private String libelle ;
    // private LocalTime time;

    private Date basicTime;
    private String son;
    private int volume;
    private int luminosite;
    private String couleur;
    private int dureeNBMinutes;
    //private int augmentNBMinutes;
    private boolean isDebug = false;

    private static Map<String,String> defaultValues = new HashMap<String,String>();
    private static int numberDefaultLibelle = 0;


    @SuppressLint("NewApi")
    public AlarmData(String libelle, String time, String son, String volume, String luminosite, String couleur, String dureeNBMinutes) {

       isDebug = ("debug".equalsIgnoreCase(libelle));
       if (isDebug)
       {
           // on force la valeur du libelle à sa valeur par default
           libelle = defaultValues.get("libelle");
       }


        if (isDefault("libelle", libelle))
        {
            this.libelle = "alarme "+(++numberDefaultLibelle);

        } else {
            this.libelle = libelle;
        }




        try {

            if (isDefault("time", time))
            {
                // this.time = LocalTime.now().plusMinutes(2);
                calendar.setTime(new Date());
                calendar.add(Calendar.MINUTE, 2);
                basicTime = calendar.getTime();
            }
            else
            {
                String[] champs = time.split(":");
                //this.time = LocalTime.of(Integer.parseInt(champs[0]), Integer.parseInt(champs[1]));
                basicTime = new Date();
                basicTime.setHours(Integer.parseInt(champs[0]));
                basicTime.setMinutes(Integer.parseInt(champs[1]));
            }
            this.son = getDefault("son", son, "Oiseaux1");
            this.volume = parseInt(getDefault("volume", volume, "30"));
            this.luminosite = parseInt(getDefault("luminosite", parseLuminosite(luminosite), "60"));
            this.couleur = getDefault("couleur", couleur, "Bleu");
            this.dureeNBMinutes = parseInt(getDefault("dureeNBMinutes", parseDureeNBMinutes(dureeNBMinutes), "5"));

        } catch (NumberFormatException e)
        {
            Log.e("AlarmData", "problem with parsing", e);
        }

    }

    protected static String parseDureeNBMinutes(String input) {
        String[] spl = input.split(" ");
        if (spl.length>1) {
            return spl[0];
        }
        else {
            return null;
        }
    }

    protected static String parseLuminosite(String input) {
        String[] spl = input.split(" ");
        if (spl.length>1) {
            return spl[0];
        }
        else {
            return null;
        }
    }

    protected static String parseAugmentation(String input) {
        String[] spl = input.split(" ");
        if (spl.length>2) {
            return spl[2];
        }
        else {
            return null;
        }
    }


    protected static void createDefaultValuesFromScreen(String libelle, String time,
                                                             String son, String volume,
                                                             String luminosite, String couleur,
                                                             String dureeNBMinutes) {
        defaultValues.put("libelle", libelle);
        defaultValues.put("time", time);
        if (defaultValues.get("son")==null) {
            // quand on choisit un son, l'écran est "rechargé" et la valeur déjà choisie pour son est considérée comme défaut
            defaultValues.put("son", son);
        }
        defaultValues.put("volume", volume);
        defaultValues.put("luminosite", luminosite);
        defaultValues.put("couleur", couleur);
        defaultValues.put("dureeNBMinutes", dureeNBMinutes);

    }

    protected static int parseInt(String valeur) {
        return Integer.parseInt(valeur);
    }

    protected static String getDefault(String champ, String valeur, String valeurParDefaut)
    {
        if (isDefault(champ, valeur)){
            return valeurParDefaut;
        } else
        {
            return valeur;
        }
    }

    protected static boolean isDefault(String champ, String valeur) {
        if (valeur==null) {
            return true;  //  problem parsing
        }
        else {
            return valeur.equals(defaultValues.get(champ));
        }
    }

    @Override
    public String toString() {
        return "AlarmData{" +
                "libelle='" + libelle + '\'' +
                // ", time=" + time +
                ", time=" + basicTime +
                ", son='" + son + '\'' +
                ", volume=" + volume +
                ", luminosite=" + luminosite +
                ", couleur='" + couleur + '\'' +
                ", dureeNBMinutes=" + dureeNBMinutes +

                '}';
    }

    public static Map<String,String> colorsToHSV = new HashMap<>();
    static {
        colorsToHSV.put("Jaune", "61000");
        colorsToHSV.put("Rouge", "0");
        colorsToHSV.put("Bleu", "22000");
        colorsToHSV.put("Vert", "45000");
    }

    protected static String getColorHSV(String color) {
        return colorsToHSV.get(color);
    }

    protected static int getInRangeFrom1To255(int nbPourcent) {
        return nbPourcent * 255 / 100 ;
    }

    public String getJSONFormat() {
        return "{" +
                //"\"t\":" + getDeltaSeconds(time) +
                "\"t\":" + getDeltaSeconds(basicTime) +
                ",\"l\":{"+
                "\"c\":"+getColorHSV(couleur)+
                ",\"M\":" + getInRangeFrom1To255(luminosite) +
                ",\"d\":" + (dureeNBMinutes * 60) +
                "},\"s\":{"+
                "\"f\":\"" + son + ".wav\"" +
                ",\"M\":" + getInRangeFrom1To255(volume)+ "}}.";
                //+
                //", augmentNBMinutes=" + augmentNBMinutes +
                //'}';

    }

    /*
    @TargetApi(26)
    protected static long getDeltaSeconds(LocalTime time){
        return ChronoUnit.SECONDS.between(LocalTime.now(), time);
        //return Duration.between(new Date(),new Date(time));
    }
*/

    protected static long getDeltaSeconds(Date time) {
        long curr = System.currentTimeMillis();
        long target = time.getTime();
        long reponse = Math.abs((target - curr)/1000);
        reponse = reponse - 30;
        if (reponse < 15)
        {
            reponse = 24;
        }
        return reponse ;

    }

    public String getLibelle() {
        return libelle;
    }

    @TargetApi(26)
    public String getTimeAsString() {
        return String.format("%02d:%02d", basicTime.getHours(), basicTime.getMinutes());
    }

    /*
    public LocalTime getTime() {
        return time;
    }

     */

    public String getSon() {
        return son;
    }

    public int getVolume() {
        return volume;
    }

    public int getLuminosite() {
        return luminosite;
    }

    public String getCouleur() {
        return couleur;
    }

    public int getDureeNBMinutes() {
        return dureeNBMinutes;
    }

    public static int getNumberDefaultLibelle() {
        return numberDefaultLibelle;
    }

    public boolean isDebug() {
        return isDebug;
    }

}
