package com.cmpundhir.cm.allwidgetsdemo.Animation_package;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.cmpundhir.cm.allwidgetsdemo.R;

public class CrossFadingActivity extends AppCompatActivity {
TextView textView,textView2;
Animation animation,animation2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross_fading);
        textView = findViewById(R.id.text);
        textView2 = findViewById(R.id.text2);
        animation = AnimationUtils.loadAnimation(CrossFadingActivity.this, R.anim.fade_in);
        animation2 = AnimationUtils.loadAnimation(CrossFadingActivity.this, R.anim.fade_out);
        textView.startAnimation(animation);
        textView2.startAnimation(animation2);
    }
}
