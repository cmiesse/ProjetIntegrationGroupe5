package com.example.happydawn;


import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class creerAlarme {


    // Récupère heures et les minutes du système



    // Différence entre Heure système et Heure entrée
    public void calculateHour(TimePicker view, int hourOfDay, int minute){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);

        // Ajoute 1 jour à l'heure entrée si cette dernière se trouve dans le passé
        if (c.before(Calendar.getInstance())){
            c.add(Calendar.DATE, 1);
        }


        }

}