package com.cmpundhir.cm.allwidgetsdemo.Animation_package;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.cmpundhir.cm.allwidgetsdemo.R;

public class ZoomInActivity extends AppCompatActivity {
TextView textView;
Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_in);
        textView = findViewById(R.id.text);
        animation = AnimationUtils.loadAnimation(ZoomInActivity.this, R.anim.zoom_in);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(ZoomInActivity.this, "Animation started zooming in", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        textView.startAnimation(animation);
    }
}
