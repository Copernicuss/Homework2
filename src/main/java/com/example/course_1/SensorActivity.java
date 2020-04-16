package com.example.course_1;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ListView;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;

public class SensorActivity  extends AppCompatActivity {
    private SensorManager sensorManager;
    //private Sensor mSensor;
    List<Sensor> sensors;
    ListView sensorlv;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xmlsensors);
        sensorlv = (ListView)findViewById(R.id.listviewsensor);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        sensorlv.setAdapter(new ArrayAdapter<Sensor>(this,android.R.layout.simple_list_item_1 , sensors));
    }
}

