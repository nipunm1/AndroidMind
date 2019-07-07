package com.cmpundhir.cm.allwidgetsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cmpundhir.cm.allwidgetsdemo.Intent_package.NextActivity;
import com.cmpundhir.cm.allwidgetsdemo.Intent_package.SendDataActivity;

public class IntentActivity extends AppCompatActivity implements View.OnClickListener{
Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
String subject="correction",address="nipunmiglani.96@gmail.com";
//Uri geo;
    private void init(){
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        b10 = findViewById(R.id.b10);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b10.setOnClickListener(this);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        init();
    }

    @Override
    public void onClick(View view) {
        //Explicit Intent
        //Explicit Intent is a intent when you open another activity within a same app
        int e_id = view.getId();
        switch(e_id){
            case R.id.b1:
                Intent nextactivityintent = new Intent(IntentActivity.this, NextActivity.class);
                Toast.makeText(this, "Intent calls to be explicit when user moves from one activity to other within a app ", Toast.LENGTH_LONG).show();
                startActivity(nextactivityintent);
                break;
            case R.id.b2:
                Intent senddataintent = new Intent(IntentActivity.this, SendDataActivity.class);
                senddataintent.putExtra("send_data", "Sending data from one activity to another is called explicit intent within the app");
                startActivity(senddataintent);
                break;
        }
        //Implicit Intent
        //Implicit Intent is a intent when you open activity of some other app from different app.
        int i_id = view.getId();
        switch(i_id){
            case R.id.b3:
                Intent send_message_intent = new Intent();
                send_message_intent.setAction(Intent.ACTION_SEND);
                send_message_intent.putExtra(Intent.EXTRA_TEXT, "Implicit Intent working"); //used to pass some message
                send_message_intent.setType("text/plain");
                if(send_message_intent.resolveActivity(getPackageManager())!=null){
                    startActivity(send_message_intent);
                }
                else{
                    Toast.makeText(IntentActivity.this, "Can't Send Message", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.b4:
                Intent phone_call_intent = new Intent();
                phone_call_intent.setAction(Intent.ACTION_DIAL);
                phone_call_intent.setData(Uri.parse("tel:"+"9999664813")); //used to make phone call to given number
                    if(phone_call_intent.resolveActivity(getPackageManager())!=null){
                    startActivity(phone_call_intent);
                }
                else{
                    Toast.makeText(IntentActivity.this, "Can't Make Phone call", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.b5:
                Intent email_intent = new Intent();
                email_intent.setAction(Intent.ACTION_SENDTO);
                email_intent.setData(Uri.parse("mailto:"+address));//used to provide address to email
                email_intent.putExtra(email_intent.EXTRA_SUBJECT, subject);//used to provide subject
                email_intent.putExtra(email_intent.EXTRA_TEXT, "THIS IS A CORRECTION EMAIL");//used to provide body of email
                if(email_intent.resolveActivity(getPackageManager())!=null){
                    startActivity(email_intent);
                }
                else{
                    Toast.makeText(IntentActivity.this, "Can't Open E-mail", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.b6:
                Intent google_map_intent = new Intent();
                google_map_intent.setAction(Intent.ACTION_VIEW);
                google_map_intent.setData(Uri.parse("http://maps.google.com/maps?daddr=28.697845,77.140338"));
                if(google_map_intent.resolveActivity(getPackageManager())!=null){
                    startActivity(google_map_intent);
                }
                else{
                    Toast.makeText(IntentActivity.this,"Can't find Google Map",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.b7:
                Intent web_search_intent = new Intent();
                web_search_intent.setAction(Intent.ACTION_WEB_SEARCH);
                web_search_intent.putExtra(SearchManager.QUERY, "https://www.google.com/");
                if(web_search_intent.resolveActivity(getPackageManager())!=null){
                    startActivity(web_search_intent);
                }
                else{
                    Toast.makeText(IntentActivity.this,"Can't find web",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.b8:
                Intent contact_intent = new Intent(Intent.ACTION_PICK,ContactsContract.Contacts.CONTENT_URI);
                if(contact_intent.resolveActivity(getPackageManager())!=null){
                    startActivity(contact_intent);
                }
                else{
                    Toast.makeText(IntentActivity.this, "Can't show contact", Toast.LENGTH_LONG).show();
                }
                break;
            /*case R.id.b9:
                Intent alarm_clock_intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_HOUR,"")
                        .putExtra(AlarmClock.EXTRA_MINUTES, "");
                if(alarm_clock_intent.resolveActivity(getPackageManager())!=null){
                    startActivity(alarm_clock_intent);
                }
                else{
                    Toast.makeText(IntentActivity.this,"Can't set alarm",Toast.LENGTH_LONG).show();
                }
                break;*/
            case R.id.b10:
                Intent camera_intent = new Intent();
                camera_intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                if(camera_intent.resolveActivity(getPackageManager())!=null){
                    startActivity(camera_intent);
                }
                else{
                    Toast.makeText(IntentActivity.this, "Can't open Camera", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
}
