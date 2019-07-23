package com.cmpundhir.cm.allwidgetsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cmpundhir.cm.allwidgetsdemo.AdMobs_package.BannerActivity;
import com.cmpundhir.cm.allwidgetsdemo.AdMobs_package.InterstitialActivity;
import com.cmpundhir.cm.allwidgetsdemo.AdMobs_package.RewardedActivity;

public class AdMobsActivity extends AppCompatActivity {
Button btn,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_mobs);
        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdMobsActivity.this, BannerActivity.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdMobsActivity.this, InterstitialActivity.class);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdMobsActivity.this, RewardedActivity.class);
                startActivity(intent);
            }
        });
    }
}
