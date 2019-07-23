package com.cmpundhir.cm.allwidgetsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cmpundhir.cm.allwidgetsdemo.Sensors_package.AccelerometerSensorsActivity;
import com.cmpundhir.cm.allwidgetsdemo.Sensors_package.GravitySensorsActivity;
import com.cmpundhir.cm.allwidgetsdemo.Sensors_package.LightSensorsActivity;
import com.cmpundhir.cm.allwidgetsdemo.Sensors_package.ListOfSensorsActivity;

public class SensorsActivity extends AppCompatActivity implements View.OnClickListener{
Button btn,btn2,btn3,btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);
        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent=null;
        switch (id){
            case R.id.btn :
                 intent = new Intent(SensorsActivity.this, ListOfSensorsActivity.class);
                 break;
            case R.id.btn2 :
                intent = new Intent(SensorsActivity.this, GravitySensorsActivity.class);
                break;
            case R.id.btn3 :
                intent = new Intent(SensorsActivity.this, LightSensorsActivity.class);
                break;
            case R.id.btn4 :
                intent = new Intent(SensorsActivity.this, AccelerometerSensorsActivity.class);
                break;
        }
        if(intent!=null){
            startActivity(intent);
        }
    }
}
