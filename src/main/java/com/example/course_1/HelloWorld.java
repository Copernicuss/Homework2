package com.example.course_1;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;


public class HelloWorld extends Activity {

    Button b1,b2,b3,b4,b5,b6,b7;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helloworld);
        b1 = (Button)findViewById(R.id.buttn1);
        b2 = (Button)findViewById(R.id.buttn2);
        b3 = (Button)findViewById(R.id.buttn3);
        b4 = (Button)findViewById(R.id.buttn4);
        b5 = (Button)findViewById(R.id.buttn5);
        b6 = (Button)findViewById(R.id.buttn6);
        b7 = (Button)findViewById(R.id.buttn7);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelloWorld.this, ListActivity.class);
                startActivity(intent);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelloWorld.this, SharedPreferenceActivity.class);
                startActivity(intent);

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelloWorld.this, SensorActivity.class);
                startActivity(intent);

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelloWorld.this, MailClass.class);
                startActivity(intent);

            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelloWorld.this, NoteActivity.class);
                startActivity(intent);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelloWorld.this, SensorActivitySecond.class);
                startActivity(intent);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelloWorld.this, SensorActivityThird.class);
                startActivity(intent);
            }
        });

    }
}


