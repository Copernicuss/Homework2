package com.example.course_1;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SensorActivityThird  extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager_2;
    private Sensor mAcc;
    TextView tvAcc;
    String msg = "ACC Sensor Testing !\n";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensorthird);
        tvAcc = (TextView)findViewById(R.id.textViewAcc);
        //tvAcc.setText(this.msg);
        sensorManager_2 = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager_2.registerListener(this, sensorManager_2.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
        mAcc = sensorManager_2.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    public void onAccuracyChanged (Sensor sensor,int accuracy){

    }

    @Override
    public void onSensorChanged (final SensorEvent event){
        if (event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            final float a = event.values[0];
            final float b = event.values[1];
            final float c = event.values[2];
            tvAcc.setText(msg + "   \n" + Float.toString(a) + "   " +  Float.toString(b) + "   " +Float.toString(c));
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    float a2 = event.values[0];
                    float b2 = event.values[1];
                    float c2 = event.values[2];
                    String strA = "" + Float.toString(a) + "   " +  Float.toString(b) + "   " +Float.toString(c) + "\n " +
                            Float.toString(a2) + "   " +  Float.toString(b2) + "   " +Float.toString(c2)  ;
                    tvAcc.setText(msg + " \n" + strA);
                    //if (a == a2 && b == b2 && c == c2){
                    if( java.lang.Math.abs(a-a2) < 0.5 && java.lang.Math.abs(b-b2) < 0.5 && java.lang.Math.abs(c-c2) < 0.5 ){
                        tvAcc.setText("IT IS CLOSING  ........ ! ");
                        //System.exit(0);
                        finishAffinity();
                    }
                }
            },5000);
        }
    }
    @Override
    protected void onResume(){
        super.onResume();
        sensorManager_2.registerListener(this,mAcc,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause(){
        super.onPause();
        sensorManager_2.unregisterListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sensorManager_2.unregisterListener(this);
    }


}
