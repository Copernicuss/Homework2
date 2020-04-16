package com.example.course_1;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import org.w3c.dom.Text;

public class SensorActivitySecond extends AppCompatActivity implements SensorEventListener {
    private final String s = "Light Sensor Testing !   ";
    TextView tv;
    private SensorManager sensorManager;
    private Sensor mLight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensorsecond);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        tv = (TextView)findViewById(R.id.textViewLight);
    }

    @Override
    public void onAccuracyChanged (Sensor sensor,int accuracy){

    }

    @Override
    public void onSensorChanged (SensorEvent event){
        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {

            float lux = event.values[0];
            tv.setText(s);
            if (lux > 20.0) {
                tv.setTextColor(Color.BLACK);
                tv.setBackgroundColor(Color.WHITE);
            }
            else {
                tv.setTextColor(Color.WHITE);
                tv.setBackgroundColor(Color.BLACK);
            }
        }
    }
    @Override
    protected void onResume(){
        super.onResume();
        sensorManager.registerListener(this,mLight,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause(){
        super.onPause();
        sensorManager.unregisterListener(this);
    }

}
