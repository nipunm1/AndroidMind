package com.cmpundhir.cm.allwidgetsdemo.Animation_package;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cmpundhir.cm.allwidgetsdemo.R;

import pl.droidsonroids.gif.GifImageView;

public class AnimationHomeActivity extends AppCompatActivity {
Button button,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12,button13,button14,button15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_home);
        button = findViewById(R.id.fadeinbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnimationHomeActivity.this,FadeInActivity.class);
                startActivity(intent);
            }
        });
        button2 = findViewById(R.id.fadeoutbtn);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnimationHomeActivity.this,FadeOutActivity.class);
                startActivity(intent);
            }
        });
        button3 = findViewById(R.id.crossfadebtn);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnimationHomeActivity.this,CrossFadingActivity.class);
                startActivity(intent);
            }
        });
        button4 = findViewById(R.id.blinkbtn);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnimationHomeActivity.this,BlinkActivity.class);
                startActivity(intent);
            }
        });
        button5 = findViewById(R.id.zoominbtn);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnimationHomeActivity.this,ZoomInActivity.class);
                startActivity(intent);
            }
        });
        button6 = findViewById(R.id.zoomoutbtn);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnimationHomeActivity.this,ZoomOutActivity.class);
                startActivity(intent);
            }
        });
        button7 = findViewById(R.id.rotatebtn);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnimationHomeActivity.this,RotateActivity.class);
                startActivity(intent);
            }
        });
        button8 = findViewById(R.id.movebtn);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnimationHomeActivity.this,MoveActivity.class);
                startActivity(intent);
            }
        });
        button9 = findViewById(R.id.slideupbtn);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnimationHomeActivity.this,SlideUpActivity.class);
                startActivity(intent);
            }
        });
        button10 = findViewById(R.id.slidedownbtn);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent = new Intent(AnimationHomeActivity.this,SlideDownActivity.class);
              startActivity(intent);
            }
        });
        button11 = findViewById( R.id.bouncebtn);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnimationHomeActivity.this,BounceActivity.class);
                startActivity(intent);
            }
        });
        button12 = findViewById(R.id.sequencialbtn);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnimationHomeActivity.this,SequentialActivity.class);
                startActivity(intent);
            }
        });
        button13 = findViewById(R.id.togetherbtn);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnimationHomeActivity.this,TogetherActivity.class);
                startActivity(intent);
            }
        });
        button14 = findViewById(R.id.lottiebtn);
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnimationHomeActivity.this,LottieActivity.class);
                startActivity(intent);
            }
        });
        button15 = findViewById(R.id.gifbtn);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnimationHomeActivity.this, GifActivity.class);
                startActivity(intent);
            }
        });
    }
}
