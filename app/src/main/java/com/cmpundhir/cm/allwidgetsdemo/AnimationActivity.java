package com.cmpundhir.cm.allwidgetsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.manager.RequestManagerRetriever;
import com.cmpundhir.cm.allwidgetsdemo.Animation_package.AnimationHomeActivity;

public class AnimationActivity extends AppCompatActivity {
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        imageView = findViewById(R.id.ani_image);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(AnimationActivity.this, AnimationHomeActivity.class);
                ActivityOptions activityOptions =ActivityOptions.makeSceneTransitionAnimation(AnimationActivity.this, imageView, "animation");
                startActivity(intent,activityOptions.toBundle());
                finish();
            }
        }, 3000);
    }
}
