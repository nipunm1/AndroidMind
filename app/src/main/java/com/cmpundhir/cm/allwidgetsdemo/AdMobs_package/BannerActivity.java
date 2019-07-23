package com.cmpundhir.cm.allwidgetsdemo.AdMobs_package;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cmpundhir.cm.allwidgetsdemo.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class BannerActivity extends AppCompatActivity {
AdView myadview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        AdView adView = new AdView(BannerActivity.this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-9428743662353184~3271443324");
        myadview = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        myadview.loadAd(adRequest);
        /*MobileAds.initialize(BannerActivity.this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                myadview.setAdListener(new AdListener(){
                    @Override
                    public void onAdLeftApplication() {
                        super.onAdLeftApplication();
                    }

                    @Override
                    public void onAdOpened() {
                        super.onAdOpened();
                    }

                    @Override
                    public void onAdImpression() {
                        super.onAdImpression();
                    }

                    @Override
                    public void onAdFailedToLoad(final int i) {
                        super.onAdFailedToLoad(i);
                    }

                    @Override
                    public void onAdClosed() {
                        super.onAdClosed();
                    }

                    @Override
                    public void onAdClicked() {
                        super.onAdClicked();
                    }

                    @Override
                    public void onAdLoaded() {
                        super.onAdLoaded();
                    }
                });
            }
        });*/
    }
}
