package com.example.happydawn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    TextView t1_degree,t2_temps;
    private ImageView aide;
    private ImageView alarme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);



        this.aide = findViewById(R.id.aide);

        aide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),Aide.class);
                startActivity(otherActivity);
                finish();
            }
        });

        this.alarme = findViewById(R.id.alarme);

        alarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),Alarme.class);
                startActivity(otherActivity);
                finish();
            }
        });

        //WebView webView = findViewById(R.id.webView);
        //webView.loadUrl("file:///android_asset/horloge/horloge.html");
        //webView.setWebChromeClient(new WebChromeClient());
        //webView.getSettings().setJavaScriptEnabled(true);

        t1_degree = findViewById(R.id.degre);
        t2_temps = findViewById(R.id.temps);

        findwethear();

        ImageView image = findViewById(R.id.imageview);
        image.setImageResource(R.drawable.meteo);
    }


    public void findwethear() {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=Louvain-la-Neuve,BE&appid=208bd97770984e2f933ee407ae1493b6&units=imperial";

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject main_object = response.getJSONObject("main");
                    JSONArray array = response.getJSONArray("weather");
                    JSONObject object = array.getJSONObject(0);
                    String degree = String.valueOf(main_object.getDouble("temp"));
                    String temp = object.getString("description");

                    t1_degree = findViewById(R.id.degre);
                    t2_temps = findViewById(R.id.temps);

                    t2_temps.setText(temp);

                    double degree_int =  Double.parseDouble(degree);
                    double centi = (degree_int - 32)/1.8000;
                    centi = Math.round(centi);
                    int i = (int)centi;
                    t1_degree.setText(String.valueOf(i));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse (VolleyError error){

            }
        }
        );

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jor);
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
