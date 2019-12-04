package com.example.happydawn;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class creerAlarme {


        // Récupère heures et les minutes du système
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatHeure = new SimpleDateFormat("HH:mm aa");
        Date date1 = new Date();


        // mettre date en string
        // String datum = formatHeure.format(date1);

        // Heures et minutes entrées par l'utilisateur
        int heure = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        



        // Différence entre Heure système et Heure entrée
    /*public long diffHeure(){
            long millis = date1.getTime() - date2.getTime();
            int hours = (int) (millis/(1000 * 60 * 60));
            int mins = (int) (millis % (1000*60*60));
            return millis;
    }

    */



        public int getMinute() {
        return minute;
    }

    public void setMinute(int minutes) {
        this.minute = minutes;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }
}
