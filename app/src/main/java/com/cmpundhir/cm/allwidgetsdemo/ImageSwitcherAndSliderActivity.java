package com.cmpundhir.cm.allwidgetsdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class ImageSwitcherAndSliderActivity extends AppCompatActivity {
ImageSwitcher imageSwitcher;
ViewPager imageSlider;
Button btn;
int imagestoswitch[] = {R.drawable.javascript,R.drawable.python,R.drawable.chash,R.drawable.cplusplus,R.drawable.java};
int imagestoswitchlength = imagestoswitch.length;
int imagescounter=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher_and_slider);
        imageSwitcher = findViewById(R.id.imageSwitcher);
        imageSlider = findViewById(R.id.imageslider);
        btn = findViewById(R.id.imgswitchbtn);
        ImageAdapterforImageSlider imageAdapterforImageSlider = new ImageAdapterforImageSlider(ImageSwitcherAndSliderActivity.this);
        imageSlider.setAdapter(imageAdapterforImageSlider);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(ImageSwitcherAndSliderActivity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setImageResource(R.drawable.java);
                return imageView;
            }
        });

        Animation aniout = AnimationUtils.loadAnimation(ImageSwitcherAndSliderActivity.this, android.R.anim.slide_out_right);
        Animation aniin = AnimationUtils.loadAnimation(ImageSwitcherAndSliderActivity.this, android.R.anim.slide_in_left);
        imageSwitcher.setOutAnimation(aniout);
        imageSwitcher.setInAnimation(aniin);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagescounter++;
                if(imagescounter==imagestoswitchlength){
                    imagescounter=0;
                    imageSwitcher.setImageResource(imagestoswitch[imagescounter]);
                }
                else {
                    imageSwitcher.setImageResource(imagestoswitch[imagescounter]);
                }
            }
        });
    }
}
class ImageAdapterforImageSlider extends PagerAdapter{
    Context context;
    int imagestoslide[]={R.drawable.balbasor,R.drawable.charmender,R.drawable.squantel,R.drawable.psynduck,R.drawable.pokemons};
    public ImageAdapterforImageSlider(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return imagestoslide.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==((ImageView)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(imagestoslide[position]);
        ((ViewPager)container).addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull final ViewGroup container, final int position, @NonNull final Object object) {
        ((ViewPager)container).removeView((ImageView)object);
    }
}