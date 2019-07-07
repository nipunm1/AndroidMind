package com.cmpundhir.cm.allwidgetsdemo.Intent_package;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.cmpundhir.cm.allwidgetsdemo.R;

public class SendDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data);
        String recievedata = getIntent().getStringExtra("send_data");
        Toast.makeText(this, recievedata, Toast.LENGTH_LONG).show();
    }
}
