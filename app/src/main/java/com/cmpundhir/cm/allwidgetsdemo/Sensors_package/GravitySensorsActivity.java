package com.cmpundhir.cm.allwidgetsdemo.Sensors_package;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import com.cmpundhir.cm.allwidgetsdemo.R;

public class GravitySensorsActivity extends AppCompatActivity implements SensorEventListener {
SensorManager sensorManager;
Sensor sensor;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravity_sensors);
        textView = findViewById(R.id.text);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if(sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)!=null){
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(GravitySensorsActivity.this);
            builder.setTitle("Warning!!");
            builder.setMessage("Your mobile don't have gravity sensor");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
                AlertDialog dialog =builder.create();
                dialog.show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        StringBuffer sf = new StringBuffer();
        sf.append("x : "+sensorEvent.values[0]+"\n");
        sf.append("y : "+sensorEvent.values[1]+"\n");
        sf.append("z : "+sensorEvent.values[2]+"\n");
        textView.setText(sf.toString());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
