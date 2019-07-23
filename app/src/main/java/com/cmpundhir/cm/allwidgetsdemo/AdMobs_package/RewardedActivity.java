package com.cmpundhir.cm.allwidgetsdemo.AdMobs_package;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.cmpundhir.cm.allwidgetsdemo.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class RewardedActivity extends AppCompatActivity implements RewardedVideoAdListener{
RewardedVideoAd rewardedVideoAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewarded);
        MobileAds.initialize(RewardedActivity.this, "ca-app-pub-9428743662353184~3271443324");
        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(RewardedActivity.this);
        rewardedVideoAd.setRewardedVideoAdListener(RewardedActivity.this);
        loadedRewardedVideoAd();
        if(rewardedVideoAd.isLoaded()){
            rewardedVideoAd.show();
        }
        else{
            Toast.makeText(RewardedActivity.this, "Ad is not loaded", Toast.LENGTH_LONG).show();
        }
    }
    private void loadedRewardedVideoAd(){
            rewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917",new AdRequest.Builder().build());
    }

    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {
        loadedRewardedVideoAd();
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        Toast.makeText(RewardedActivity.this, "Rewarded to User"+ rewardItem.getAmount(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    public void onRewardedVideoCompleted() {

    }

    @Override
    protected void onPause() {
        rewardedVideoAd.pause(RewardedActivity.this);
        super.onPause();
    }

    @Override
    protected void onResume() {
        rewardedVideoAd.resume(RewardedActivity.this);
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        rewardedVideoAd.destroy(RewardedActivity.this);
        super.onDestroy();
    }
}
