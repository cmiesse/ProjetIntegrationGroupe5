package com.example.happydawn;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Alarme extends AppCompatActivity {

    private ImageView retour;
    private ImageView add;

    private LinearLayout parentLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarme);
        parentLinearLayout = findViewById(R.id.parent_linear_layout);

        this.retour = findViewById(R.id.retour);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(otherActivity);
                finish();
            }
        });


        Intent intent17 = getIntent();
        if (intent17 != null){
            String str6 = "";
            String str5 = "";
            String str4 = "";
            String str3 = "";
            String str2 = "";
            String str1 = "";
            String str = "";
            String str10 = "";
            if (intent17.hasExtra("edittext7")){
                str6 = intent17.getStringExtra("edittext7");
            }
            if (intent17.hasExtra("edittext6")){
                str5 = intent17.getStringExtra("edittext6");
            }
            if (intent17.hasExtra("edittext5")){
                str4 = intent17.getStringExtra("edittext5");
            }
            if (intent17.hasExtra("edittext4")){
                str3 = intent17.getStringExtra("edittext4");
            }
            if (intent17.hasExtra("edittext3")){
                str2 = intent17.getStringExtra("edittext3");
            }
            if (intent17.hasExtra("edittext2")){
                str1 = intent17.getStringExtra("edittext2");
            }
            if (intent17.hasExtra("edittext")){
                str = intent17.getStringExtra("edittext");
            }
            if (intent17.hasExtra("edittext10")){
                str10 = intent17.getStringExtra("edittext10");
            }
            TextView textView = findViewById(R.id.txtupdate7);
            textView.setText(str6);
            TextView textView1 = findViewById(R.id.txtupdate6);
            textView1.setText(str5);
            TextView textView2 = findViewById(R.id.txtupdate5);
            textView2.setText(str4);
            TextView textView3 = findViewById(R.id.txtupdate4);
            textView3.setText(str3);
            TextView textView4 = findViewById(R.id.txtupdate3);
            textView4.setText(str2);
            TextView textView5 = findViewById(R.id.txtupdate2);
            textView5.setText(str1);
            TextView textView6 = findViewById(R.id.txtupdate);
            textView6.setText(str);
            TextView textView10 = findViewById(R.id.txtupdate1);
            textView10.setText(str10);
        }




        this.add = findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(),Reglage.class);
                startActivity(otherActivity);
                finish();
            }
        });

    }

    public void onAddField(View v) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.field, null);
        // Add the new row before the add field button.
        parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount() - 1);
    }

    public void onDelete(View v) {
        parentLinearLayout.removeView((View) v.getParent());
    }
}
