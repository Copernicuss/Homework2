package com.example.course_1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import java.util.ArrayList;
import java.util.List;

public class SharedPreferenceActivity extends AppCompatActivity implements OnItemSelectedListener{

    EditText etext,etext2,etext3,etext4,etext5,etext6,etext7,etext30;
    Button button,button2,button3;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xmlsharedpreference);
        final Spinner spinner = (Spinner)findViewById(R.id.spinner);
        etext=(EditText)findViewById(R.id.editText);
        etext2=(EditText)findViewById(R.id.editText2);
        etext3=(EditText)findViewById(R.id.editText3);
        etext4=(EditText)findViewById(R.id.editText4);
        etext5=(EditText)findViewById(R.id.editText5);
        etext6=(EditText)findViewById(R.id.editText6);
        //etext7=(EditText)findViewById(R.id.editText7);
        etext30=(EditText)findViewById(R.id.editText30);
        button=(Button)findViewById(R.id.button);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        sharedpreferences = getSharedPreferences("Course1SharedPreference", Context.MODE_PRIVATE);
        this.getSharedPreferences("Course1SharedPreference", 0).edit().clear().apply();

        spinner.setOnItemSelectedListener(this);
        final String[] modes = {"Light", "Dark"};
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, modes);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strkey  = etext.getText().toString();
                String str1 = etext2.getText().toString();
                String str2 = etext3.getText().toString();
                String str3 = modes[spinner.getSelectedItemPosition()];
                String s1 = etext4.getText().toString();
                String s2 = etext5.getText().toString();
                String s3 = etext6.getText().toString();

                if(strkey.equals("") || str1.equals("") || str2.equals("")  || str3.equals("") || s3.equals("") || s2.equals("") || s1.equals("") ){
                    Toast.makeText(SharedPreferenceActivity.this, "Fill all the blanks", Toast.LENGTH_LONG).show();
                }
                else{
                    int value1 =  Integer.parseInt(s1);
                    int value2 =  Integer.parseInt(s2);
                    int value3 =  Integer.parseInt(s3);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString(strkey.concat("_name"), str1);
                    editor.putString(strkey.concat("_gender"), str2);
                    editor.putString(strkey.concat("_mode"), str3);
                    editor.putInt(strkey.concat("_height"), value1);
                    editor.putInt(strkey.concat("_weight"), value2);
                    editor.putInt(strkey.concat("_age"), value3);
                    editor.commit();
                    Toast.makeText(SharedPreferenceActivity.this, "Saved", Toast.LENGTH_LONG).show();
                }

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str3 = etext30.getText().toString();
                if(!str3.equals("") && sharedpreferences.contains(str3.concat("_name"))) {
                    SharedPreferences.Editor editor2 = sharedpreferences.edit();
                    editor2.remove(str3.concat("_name"));
                    editor2.remove(str3.concat("_gender"));
                    editor2.remove(str3.concat("_mode"));
                    editor2.remove(str3.concat("_height"));
                    editor2.remove(str3.concat("_weight"));
                    editor2.remove(str3.concat("_age"));
                    editor2.commit();
                    Toast.makeText(SharedPreferenceActivity.this, "Has been deleted", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(SharedPreferenceActivity.this, "Write a valid key", Toast.LENGTH_LONG).show();
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str20 = etext30.getText().toString();
                if(!str20.equals("") && sharedpreferences.contains(str20.concat("_name"))) {
                    Intent intent = new Intent(SharedPreferenceActivity.this, SharedPreferencesAll.class);
                    intent.putExtra("keypara", str20);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(SharedPreferenceActivity.this, "Write a valid key", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //String item = parent.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {

    }

}
