package com.example.happydawn;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class LuminosityActivity extends AppCompatActivity {
    private static final int REQUEST_ENABLE_BT = 0;
    private static final int REQUEST_DISCOVER_BT = 1;
    private TextView textview;
    private SeekBar seekbar;
    private Button retour;
    private int luminosite;
    private String couleur;
    private String duree;
    private ImageView mBluetooth;
    private Button monbutton,moffbutton;
    private BluetoothAdapter bluetoothAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luminosity);

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.couleur, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        couleur = spinner.getSelectedItem().toString();

        Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.minute2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        duree = spinner2.getSelectedItem().toString();

        textview = (TextView) findViewById(R.id.textview);
        seekbar = (SeekBar) findViewById(R.id.seekBar);
        moffbutton = findViewById(R.id.buttonoff);
        monbutton = findViewById(R.id.buttonon);
        //adaptateur
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        // set image according to bluetooth statues(on/off)
        if (bluetoothAdapter.isEnabled()) {
            mBluetooth.setImageResource(R.drawable.ic_action_on);
        } else {
            mBluetooth.setImageResource(R.drawable.ic_action_of);
        }
        monbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bluetoothAdapter.isEnabled()) {
                    showtoast("Turning bluetooth on...");
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(intent, REQUEST_ENABLE_BT);
                } else {
                    showtoast("Bluetooth is already on");
                }
            }
        });
        moffbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bluetoothAdapter.isEnabled()){
                    bluetoothAdapter.disable();
                    showtoast("Turning Bluetooth Off");
                    mBluetooth.setImageResource(R.drawable.ic_action_of);
                }
                else {
                    showtoast("Bluetooth is already off");
                }
            }
        });

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textview.setText(getString(R.string.luminosite, progress));
                luminosite = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        this.retour = findViewById(R.id.retour);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });

    }


        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            switch (requestCode){
                case REQUEST_ENABLE_BT:
                    if (resultCode == RESULT_OK){
                        //bluetooth is on
                        mBluetooth.setImageResource(R.drawable.ic_action_on);
                        showtoast("Bluetooth is on");
                    }
                    else {
                        //user denied to turn bluetooth on
                        showtoast("could't on bluetooth");
                    }
                    break;
            }
            super.onActivityResult(requestCode, resultCode, data);
        }

        private void showtoast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
