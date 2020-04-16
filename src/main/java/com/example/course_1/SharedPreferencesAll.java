package com.example.course_1;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


import com.example.course_1.R;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;


public class SharedPreferencesAll extends AppCompatActivity {
    TextView textDisplay;
    String str;
    StringBuilder builder = new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharedpreferencesall);
        textDisplay = (TextView)findViewById(R.id.textView11); //recycleview layout buraya
        SharedPreferences sharedPref = getSharedPreferences("Course1SharedPreference", Context.MODE_PRIVATE);

        Bundle kp = getIntent().getExtras();
        String keystring = kp.getCharSequence("keypara").toString();
        String all = sharedPref.getString(keystring.concat("_name"),null) + "\n" +
                sharedPref.getString(keystring.concat("_gender"),null) + "\n" +
                sharedPref.getInt(keystring.concat("_height"),0)  + "\n" +
                sharedPref.getInt(keystring.concat("_weight"),0)    + "\n" +
                sharedPref.getInt(keystring.concat("_age"),0)+ "\n"+
                sharedPref.getString(keystring.concat("_mode"),null) ;
        textDisplay.setText(all);

        /*
        Map<String, ?> all = sharedPref.getAll();
        //textDisplay.setText(all);
        builder.append("KEY -- VALUE\n");
        for(Map.Entry<String, ?> pairs : all.entrySet()) {
            //textDisplay.setText(pairs.getValue().toString());
            builder.append(pairs);
            builder.append("\n");
            //str.add(pairs.getValue().toString());
        }
        textDisplay.setText(builder.toString());
         */


    }
}

