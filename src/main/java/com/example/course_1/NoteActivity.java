package com.example.course_1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class NoteActivity extends AppCompatActivity {
    private static final String fileName = "Course1Notes.txt";
    EditText mText;
    Button bt,bt2,bt3;
    TextView dText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noteactivityxml);
        mText = (EditText) findViewById(R.id.noteText);
        dText = (TextView) findViewById(R.id.displaytext);
        bt = (Button) findViewById(R.id.buttonnote);
        bt2 = (Button) findViewById(R.id.buttonread);
        bt3 = (Button) findViewById(R.id.buttonedit);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textToSave = mText.getText().toString();
                try {
                    FileOutputStream fileOutputStream = openFileOutput(fileName, MODE_PRIVATE);
                    fileOutputStream.write(textToSave.getBytes());
                    fileOutputStream.close();
                    Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                    mText.setText("");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream fileInputStream = openFileInput(fileName);
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuffer stringBuffer = new StringBuffer();
                    String lines;
                    while ((lines = bufferedReader.readLine()) != null) {
                        stringBuffer.append(lines + "\n");
                    }
                    dText.setText(stringBuffer.toString());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream fileInputStream = openFileInput(fileName);
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuffer stringBuffer = new StringBuffer();
                    String lines;
                    while ((lines = bufferedReader.readLine()) != null) {
                        stringBuffer.append(lines + "\n");
                    }
                    mText.setText(stringBuffer.toString());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
