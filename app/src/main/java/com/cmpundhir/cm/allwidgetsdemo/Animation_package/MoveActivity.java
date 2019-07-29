package com.cmpundhir.cm.allwidgetsdemo.Animation_package;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.cmpundhir.cm.allwidgetsdemo.R;

public class MoveActivity extends AppCompatActivity {
TextView textView,textView2;
Animation animation,animation2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);
        textView = findViewById(R.id.text);
        textView2 = findViewById(R.id.text2);
        animation = AnimationUtils.loadAnimation(MoveActivity.this, R.anim.move);
        animation2 = AnimationUtils.loadAnimation(MoveActivity.this, R.anim.move2);
        textView.startAnimation(animation);
        textView2.startAnimation(animation2);
    }
}
