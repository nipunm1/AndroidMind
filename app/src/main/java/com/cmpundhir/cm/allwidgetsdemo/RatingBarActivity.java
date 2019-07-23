package com.cmpundhir.cm.allwidgetsdemo;

import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RatingBarActivity extends AppCompatActivity {
RatingBar ratingBar;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);
        ratingBar = findViewById(R.id.ratingBar);
        btn = findViewById(R.id.ratingbarbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rating;
                rating = String.valueOf(ratingBar.getRating());
                Toast.makeText(RatingBarActivity.this, "Thank you for giving rating = "+rating, Toast.LENGTH_LONG).show();
            }
        });
    }
}
