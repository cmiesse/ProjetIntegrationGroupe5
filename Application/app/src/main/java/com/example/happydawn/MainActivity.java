package com.example.happydawn;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private ImageButton luminosity;
    private ImageButton alarm;
    private ImageButton sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if(bluetoothAdapter == null){
            Toast.makeText(getApplicationContext(),"Device doesn't Support Bluetooth",Toast.LENGTH_SHORT).show();
        }
        if(!bluetoothAdapter.isEnabled()){
            Intent enableAdapter = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);

            startActivityForResult(enableAdapter,0);
        }

        Set bondedDevices = bluetoothAdapter.getBondedDevices();
        if(bondedDevices.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please pair the devices first",Toast.LENGTH_SHORT).show();
        }else{
            for (BluetoothDevice iterator : bondedDevices) {

            if(iterator.getAddress().equals(DEVICE_ADDRESS)) //Replace with iterator.getName() if comparing Device names.

            {

                device=iterator; //device is an object of type BluetoothDevice

                found=true;

                break;

            } } }

        this.luminosity = findViewById(R.id.luminosity);

        luminosity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),LuminosityActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

        this.alarm = findViewById(R.id.alarm);

        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),Menualarme.class);
                startActivity(otherActivity);
                finish();
            }
        });

        this.sound = findViewById(R.id.sound);

        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),SoundActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });


    }
}
