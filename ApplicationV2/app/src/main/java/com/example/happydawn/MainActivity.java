package com.example.happydawn;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    TextView t1_degree,t2_temps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        t1_degree = (TextView)findViewById(R.id.degre);
        t2_temps = (TextView)findViewById(R.id.temps);

        findwethear();
    }

    public void findwethear(){
        String url = "";
        
    }

    public void onClickStart(View view) {

    }

    public void onClickSend(View view) {
    }

    public void onClickStop(View view) {
    }

    public void onClickClear(View view) {
    }
}
