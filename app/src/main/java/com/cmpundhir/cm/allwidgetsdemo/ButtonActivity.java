package com.cmpundhir.cm.allwidgetsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity implements View.OnClickListener {
Button btn,btn2,btn3,btn4;
LinearLayout linearLayout;
ImageButton imageButton;
RadioGroup radioGroup,D_radioGroup;
RadioButton D_rb1,D_rb2,D_rb3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        init();
    }
    private void init(){
        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        imageButton = findViewById(R.id.imageButton);
        radioGroup = findViewById(R.id.radioGroup);
        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        imageButton.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = (RadioButton)findViewById(i);
                Toast.makeText(ButtonActivity.this, "You have selected "+radioButton.getText()+" radio button",Toast.LENGTH_LONG).show();
            }
        });

        //Dynamic Radio Button Code
        D_radioGroup = new RadioGroup(ButtonActivity.this);
        linearLayout = (LinearLayout)findViewById(R.id.linearlayout);
        D_rb1 = new RadioButton(ButtonActivity.this);
        D_rb2 = new RadioButton(ButtonActivity.this);
        D_rb3 = new RadioButton(ButtonActivity.this);
        D_rb1.setText("Male");
        D_rb2.setText("Female");
        D_rb3.setText("Others");
        D_radioGroup.addView(D_rb1);
        D_radioGroup.addView(D_rb2);
        D_radioGroup.addView(D_rb3);
        D_radioGroup.setOrientation(RadioGroup.VERTICAL);
        linearLayout.addView(D_radioGroup);
        D_radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton = (RadioButton)findViewById(i);
                Toast.makeText(ButtonActivity.this, "You have selected dynamic "+radioButton.getText()+" RadioButton", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.button){
            Toast.makeText(ButtonActivity.this, "Normal button", Toast.LENGTH_LONG).show();
        }
        if(id == R.id.button2){
            Toast.makeText(ButtonActivity.this, "Colored button with tint background", Toast.LENGTH_LONG).show();
        }
        if(id == R.id.button3){
            Toast.makeText(ButtonActivity.this, "Colored button with simple background", Toast.LENGTH_LONG).show();
        }
        if(id == R.id.button4){
            Toast.makeText(ButtonActivity.this, "icon button", Toast.LENGTH_LONG).show();
        }
        if(id == R.id.imageButton){
            View layout = getLayoutInflater().inflate(R.layout.pokemon_toast,(ViewGroup) findViewById(R.id.custom_toast_layout));
            ImageView imageView = layout.findViewById(R.id.img);
            imageView.setImageDrawable(getDrawable(R.drawable.balbasor));
            Toast toast = new Toast(ButtonActivity.this);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setView(layout);
            toast.show();
        }
    }
}
