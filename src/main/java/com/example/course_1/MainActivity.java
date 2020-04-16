package com.example.course_1;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int count = 3;

    public int getCount() {
        return count;
    }

    public void decCount(){
        this.count -= 1;
    }
    public void setCount(){
        this.count = 3;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final EditText username,password;
        final Button loginButton;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.usernameText);
        password = (EditText) findViewById(R.id.passwordText);
        loginButton = (Button) findViewById(R.id.loginButton);

        View.OnClickListener test_log = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernameStr = username.getText().toString();
                String passwordStr = password.getText().toString();
                if (usernameStr.equals("") || passwordStr.equals("")){
                    Toast.makeText(MainActivity.this, "Fill the blanks !", Toast.LENGTH_SHORT).show();
                }
                else {
                    for (Person p : Person.getData()) {
                        if (username.getText().toString().equals(p.getPersonName()) && password.getText().toString().equals(p.getPassword())) {
                            setCount();
                            Intent intent = new Intent(MainActivity.this, HelloWorld.class);
                            startActivity(intent);
                            Toast.makeText(MainActivity.this, "login succesfully !", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    decCount();
                    if (getCount() == 0) {
                        Toast.makeText(MainActivity.this, "The program has been closed !", Toast.LENGTH_LONG).show();
                        //System.exit(0);
                        finishAffinity();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Username or password is wrong !  " + getCount() + " more", Toast.LENGTH_SHORT).show();
                    }
                }

                  //  Intent intent = new Intent(MainActivity.this, HelloWorld.class);
                   // startActivity(intent);

            }
        };
        loginButton.setOnClickListener(test_log);
    }
}

