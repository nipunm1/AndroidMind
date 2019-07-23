package com.cmpundhir.cm.allwidgetsdemo.Sensors_package;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.DialogInterface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import com.cmpundhir.cm.allwidgetsdemo.R;

public class LightSensorsActivity extends AppCompatActivity implements SensorEventListener {
SensorManager sensorManager;
Sensor sensor;
TextView textView;
ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_sensors);
        textView = findViewById(R.id.text2);
        constraintLayout = findViewById(R.id.cl);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if(sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)!=null){
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(LightSensorsActivity.this);
            builder.setTitle("Important Message!!");
            builder.setMessage("Your mobile don't have light sensor");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        textView.setText("Light : "+sensorEvent.values[0]);
        if(sensorEvent.values[0]>400){
            constraintLayout.setBackgroundColor(getResources().getColor(R.color.red));
        }
        else if(sensorEvent.values[0]>300){
            constraintLayout.setBackgroundColor(getResources().getColor(R.color.yellow));
        }
        else if(sensorEvent.values[0]>200){
            constraintLayout.setBackgroundColor(getResources().getColor(R.color.blue));
        }
        else if(sensorEvent.values[0]>100){
            constraintLayout.setBackgroundColor(getResources().getColor(R.color.green));
        }
        else{
            constraintLayout.setBackgroundColor(getResources().getColor(R.color.white));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
    @Override
    protected void onResume()
    {
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
