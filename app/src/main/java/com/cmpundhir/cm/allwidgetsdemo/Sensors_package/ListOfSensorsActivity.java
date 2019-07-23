package com.cmpundhir.cm.allwidgetsdemo.Sensors_package;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import com.cmpundhir.cm.allwidgetsdemo.R;

import java.util.List;

public class ListOfSensorsActivity extends AppCompatActivity {
SensorManager sensorManager;
List<Sensor>list;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_sensors);
        int pc=0;
        textView = findViewById(R.id.text);
        sensorManager =(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        list =sensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuffer stringBuffer = new StringBuffer();
        for(Sensor sensor:list){
            stringBuffer.append(++pc + "." +sensor.getName()+"\n");
        }
        textView.setText(stringBuffer.toString());
    }
}
