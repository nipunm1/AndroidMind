package com.cmpundhir.cm.allwidgetsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

public class GesturesActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener {
private static final String TAG="TOUCH";
TextView textView,textView2;
GestureDetectorCompat gestureDetectorCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestures);
        textView = findViewById(R.id.text);
        textView2 = findViewById(R.id.text2);
        gestureDetectorCompat = new GestureDetectorCompat(GesturesActivity.this, this);
        gestureDetectorCompat.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(final MotionEvent event) {
        int id = event.getAction();
        gestureDetectorCompat.onTouchEvent(event);
        /*switch (id) {
            case (MotionEvent.ACTION_DOWN):
                Log.d(TAG, "Action was down");
                textView2.setText("Action was down");
                return true;
            case (MotionEvent.ACTION_MOVE):
                Log.d(TAG, "Action was move");
                textView2.setText("Action was move");
                return true;
            case (MotionEvent.ACTION_UP):
                Log.d(TAG,"Action was up");
                textView2.setText("Action was up");
                return true;
            case (MotionEvent.ACTION_OUTSIDE):
                Log.d(TAG, "Action was outside");
                textView2.setText("Action was outside");
                return true;
            case (MotionEvent.ACTION_CANCEL):
                Log.d(TAG, "Action was cancel");
                textView2.setText("Action was cancel");
                return true;
            default:
                return super.onTouchEvent(event);
        }*/
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        textView2.setText("onDown = "+motionEvent.toString());
        Log.d(TAG, "onDown = "+motionEvent.toString());
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        textView2.setText("onShowPress = "+motionEvent.toString());
        Log.d(TAG, "onShowPress = "+motionEvent.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        textView2.setText("onSingleTapUp = "+motionEvent.toString());
        Log.d(TAG, "onSingleTapUp = "+motionEvent.toString());
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        textView2.setText("onScroll = "+motionEvent.toString()+motionEvent1.toString());
        Log.d(TAG, "onScroll = "+motionEvent.toString()+motionEvent1.toString());
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        textView2.setText("onLongPress = "+motionEvent.toString());
        Log.d(TAG, "onLongPress = "+motionEvent.toString());
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        textView2.setText("onFling = "+motionEvent.toString()+motionEvent1.toString());
        Log.d(TAG, "onFling = "+motionEvent.toString()+motionEvent1.toString());
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        textView2.setText("onSingleTapConfirmed = "+motionEvent.toString());
        Log.d(TAG, "onSingleTapConfirmed = "+motionEvent.toString());
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        textView2.setText("onDoublePress = "+motionEvent.toString());
        Log.d(TAG, "onDoublePress = "+motionEvent.toString());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        textView2.setText("onDoubleTapEvent = "+motionEvent.toString());
        Log.d(TAG, "onDoubleTapEvent = "+motionEvent.toString());
        return true;
    }
}
