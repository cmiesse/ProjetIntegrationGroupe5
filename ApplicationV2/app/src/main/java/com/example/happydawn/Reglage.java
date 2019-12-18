package com.example.happydawn;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
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
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.felhr.usbserial.UsbSerialDevice;
import com.felhr.usbserial.UsbSerialInterface;


import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Reglage extends AppCompatActivity {

    private ImageView retour;
    private Button son;
    private TextView textvolume;
    int volume;
    SeekBar seekbar;


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

    boolean isDebug = false;

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

        initSerial();

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
        updateText = findViewById(R.id.txtheure);

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

                AlarmData alarmData = getAlarmData();
                Log.d("AlarmData", alarmData.getJSONFormat());

                isDebug = alarmData.isDebug();
                send(alarmData.getJSONFormat());

                intent17.putExtra("AlarmData", alarmData);
                /*
                //nom
                TextView textview0 = findViewById(R.id.nomalarme);
                String str = textview0.getText().toString();
                intent17.putExtra("edittext", str);
                startActivity(intent17);

                //heure
                TextView textview10 = findViewById(R.id.txtheure);
                String str10 = textview10.getText().toString();
                intent17.putExtra("edittext10", str10);
                startActivity(intent17);



                //son
                TextView textview1 = findViewById(R.id.txtson);
                String str1 = textview1.getText().toString();
                intent17.putExtra("edittext2", str1);


                //volume
                TextView textview2 = findViewById(R.id.textvolume);

                String str2 = textview2.getText().toString();
                intent17.putExtra("edittext3", str2);


                //luminosite
                TextView textview3 = findViewById(R.id.txtluminosite);

                String str3 = textview3.getText().toString();
                intent17.putExtra("edittext4", str3);


                //couleur
                TextView textview4 = findViewById(R.id.txtcouleur);

                String str4 = textview4.getText().toString();
                intent17.putExtra("edittext5", str4);

                //duree


                //augmentation
                TextView textview6 = findViewById(R.id.txtaugmentation);

                String str6 = textview6.getText().toString();
                intent17.putExtra("edittext7", str6);

                TextView textview5 = findViewById(R.id.txtduree);

                String str5 = textview5.getText().toString();
                intent17.putExtra("edittext6", str5);


                 */
                startActivity(intent17);


            }
        });

        Button heure = findViewById(R.id.heure);
        heure.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                //pending intent
                pending_intent = PendingIntent.getBroadcast(Reglage.this, 0, my_intent
                        , PendingIntent.FLAG_UPDATE_CURRENT);

                //set alarm manager
                alarm_manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pending_intent);
                //heure

                //TODO testSerial


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
                    minute_string = "0" + minute;
                }

                set_alarm_text( hour_string + ":" + minute_string);

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

                        //send(EditTextValue);
                    }
                });

                alertdialog.show();
            }
        });


        /*
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
        */


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
                listItem4 = new String[]{"2 minutes","5 minutes", "10 minutes"};
                AlertDialog.Builder builder4 = new AlertDialog.Builder(Reglage.this);
                builder4.setTitle("durée");
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

        donneValeursDefault();


    }

    private void set_alarm_text(String output) {
        updateText.setText(output);
    }

    protected void donneValeursDefault()
    {
        AlarmData.createDefaultValuesFromScreen(((TextView)findViewById(R.id.nomalarme)).getText().toString(),((TextView)findViewById(R.id.txtheure)).getText().toString(),
                ((TextView)findViewById(R.id.txtson)).getText().toString(), ((TextView)findViewById(R.id.textvolume)).getText().toString(),
                ((TextView)findViewById(R.id.txtluminosite)).getText().toString(), ((TextView)findViewById(R.id.txtcouleur)).getText().toString(),
                ((TextView)findViewById(R.id.txtduree)).getText().toString());
    }

    protected AlarmData getAlarmData()
    {
        return new AlarmData(((TextView)findViewById(R.id.nomalarme)).getText().toString(),((TextView)findViewById(R.id.txtheure)).getText().toString(),
                ((TextView)findViewById(R.id.txtson)).getText().toString(), ((TextView)findViewById(R.id.textvolume)).getText().toString(),
                ((TextView)findViewById(R.id.txtluminosite)).getText().toString(), ((TextView)findViewById(R.id.txtcouleur)).getText().toString(),
                ((TextView)findViewById(R.id.txtduree)).getText().toString());
    }

    public final String ACTION_USB_PERMISSION = "com.example.happydawn.USB_PERMISSION";


    UsbManager usbManager;
    UsbDevice device;
    UsbSerialDevice serialPort;
    UsbDeviceConnection connection;

    protected void initSerial() {
        //TODO  Toaster debug
        Toast.makeText(getApplicationContext(),"initSerial", Toast.LENGTH_SHORT).show();

        usbManager = (UsbManager) getSystemService(this.USB_SERVICE);


        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_USB_PERMISSION);
        filter.addAction(UsbManager.ACTION_USB_DEVICE_ATTACHED);
        filter.addAction(UsbManager.ACTION_USB_DEVICE_DETACHED);
        registerReceiver(broadcastReceiver, filter);

        connectSerial();

    }


    UsbSerialInterface.UsbReadCallback mCallback = new UsbSerialInterface.UsbReadCallback() { //Defining a Callback which triggers whenever data is read.
        @Override
        public void onReceivedData(byte[] arg0) {
            String data = null;
            try {
                data = new String(arg0, "UTF-8");
                data.concat("/n");
                // tvAppend(textView, data);

                Log.d("Serial", "received "+ data);
                if (isDebug)
                {
                    Toast.makeText(getApplicationContext(),"recv_from_USB:"+data, Toast.LENGTH_SHORT).show();
                }


            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    };
    private final BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { //Broadcast Receiver to automatically start and stop the Serial connection.
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(ACTION_USB_PERMISSION)) {
                boolean granted = intent.getExtras().getBoolean(UsbManager.EXTRA_PERMISSION_GRANTED);
                if (granted) {
                    connection = usbManager.openDevice(device);
                    serialPort = UsbSerialDevice.createUsbSerialDevice(device, connection);
                    if (serialPort != null) {
                        if (serialPort.open()) { //Set Serial Connection Parameters.
//                            setUiEnabled(true);
                            serialPort.setBaudRate(9600);
                            serialPort.setDataBits(UsbSerialInterface.DATA_BITS_8);
                            serialPort.setStopBits(UsbSerialInterface.STOP_BITS_1);
                            serialPort.setParity(UsbSerialInterface.PARITY_NONE);
                            serialPort.setFlowControl(UsbSerialInterface.FLOW_CONTROL_OFF);
                            serialPort.read(mCallback);
//                            tvAppend(textView,"Serial Connection Opened!\n");

                        } else {
                            Log.d("SERIAL", "PORT NOT OPEN");
                        }
                    } else {
                        Log.d("SERIAL", "PORT IS NULL");
                    }
                } else {
                    Log.d("SERIAL", "PERM NOT GRANTED");
                }
            } else if (intent.getAction().equals(UsbManager.ACTION_USB_DEVICE_ATTACHED)) {
                // onClickStart(startButton);
                Log.d("SERIAL", UsbManager.ACTION_USB_DEVICE_ATTACHED);
                //TODO  what ?
            } else if (intent.getAction().equals(UsbManager.ACTION_USB_DEVICE_DETACHED)) {
                // onClickStop(stopButton);
                Log.d("SERIAL", UsbManager.ACTION_USB_DEVICE_DETACHED);
                //TODO  what ?

            }
        }

        ;
    };

    /*
    public void onClickStart(View view) {

        HashMap<String, UsbDevice> usbDevices = usbManager.getDeviceList();
        if (!usbDevices.isEmpty()) {
            boolean keep = true;
            for (Map.Entry<String, UsbDevice> entry : usbDevices.entrySet()) {
                device = entry.getValue();
                int deviceVID = device.getVendorId();
                if (deviceVID == 0x2341)//Arduino Vendor ID
                {
                    PendingIntent pi = PendingIntent.getBroadcast(this, 0, new Intent(ACTION_USB_PERMISSION), 0);
                    usbManager.requestPermission(device, pi);
                    keep = false;
                } else {
                    connection = null;
                    device = null;
                }

                if (!keep)
                    break;
            }
        }
    }

     */

    public void connectSerial() {

        HashMap<String, UsbDevice> usbDevices = usbManager.getDeviceList();
        if (usbDevices==null)
        {
            //TODO  Toaster debug
            Toast.makeText(getApplicationContext(),"connectSerial : usbDevices is null", Toast.LENGTH_SHORT).show();
            return ;
        }
        if (!usbDevices.isEmpty()) {
            boolean keep = true;
            for (Map.Entry<String, UsbDevice> entry : usbDevices.entrySet()) {
                device = entry.getValue();
                int deviceVID = device.getVendorId();
                if (deviceVID == 0x2341)//Arduino Vendor ID
                {
                    PendingIntent pi = PendingIntent.getBroadcast(this, 0, new Intent(ACTION_USB_PERMISSION), 0);
                    usbManager.requestPermission(device, pi);
                    keep = false;
                } else {
                    connection = null;
                    device = null;
                }

                if (!keep)
                    break;
            }
        }
    }


    /*
    public void onClickSend(View view) {
        String string = editText.getText().toString();
        serialPort.write(string.getBytes());
        tvAppend(textView, "\nData Sent : " + string + "\n");
    }
    */

    public void send(String message) {
        Log.d("SERIAL", "sending "+message);
        if (serialPort!=null) {
            serialPort.write(message.getBytes());
            Toast.makeText(getApplicationContext(),"Alarm sent", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"message would be sent to USB : "+message, Toast.LENGTH_SHORT).show();
        }
        Log.d("SERIAL", "sent "+message);
    }


    /*
    public void onClickStop(View view) {
        setUiEnabled(false);
        serialPort.close();
        tvAppend(textView,"\nSerial Connection Closed! \n");

    }
    */

    public void stopSerial() {
        // setUiEnabled(false);
        serialPort.close();
        // tvAppend(textView,"\nSerial Connection Closed! \n");

    }
}