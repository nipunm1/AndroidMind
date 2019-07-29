package com.cmpundhir.cm.allwidgetsdemo.Animation_package;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.cmpundhir.cm.allwidgetsdemo.R;

public class SequentialActivity extends AppCompatActivity {
TextView textView;
Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sequential);
        textView = findViewById(R.id.text);
        animation = AnimationUtils.loadAnimation(SequentialActivity.this, R.anim.sequencial);
        textView.startAnimation(animation);
    }
}
