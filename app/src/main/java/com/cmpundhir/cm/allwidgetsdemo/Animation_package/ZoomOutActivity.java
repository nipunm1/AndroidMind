package com.cmpundhir.cm.allwidgetsdemo.Animation_package;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.cmpundhir.cm.allwidgetsdemo.R;

public class ZoomOutActivity extends AppCompatActivity {
Animation animation;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_out);
        textView = findViewById(R.id.text);
        animation = AnimationUtils.loadAnimation(ZoomOutActivity.this, R.anim.zoom_out);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(ZoomOutActivity.this, "Animation stared zooming out", Toast.LENGTH_SHORT).show();
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
