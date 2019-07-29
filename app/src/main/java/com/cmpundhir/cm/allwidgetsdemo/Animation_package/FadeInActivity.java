package com.cmpundhir.cm.allwidgetsdemo.Animation_package;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Fade;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.cmpundhir.cm.allwidgetsdemo.R;

public class FadeInActivity extends AppCompatActivity implements Animation.AnimationListener {
TextView textView;
Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fade_in);
        textView = findViewById(R.id.text);
        animation = AnimationUtils.loadAnimation(FadeInActivity.this, R.anim.fade_in);
        animation.setAnimationListener(this);
        textView.startAnimation(animation);
    }

    @Override
    public void onAnimationStart(Animation animation) {
        Toast.makeText(FadeInActivity.this, "Animation starts fading in", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationEnd(Animation animation) {
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        Toast.makeText(FadeInActivity.this, "Animation starts repeating", Toast.LENGTH_SHORT).show();
    }
}
