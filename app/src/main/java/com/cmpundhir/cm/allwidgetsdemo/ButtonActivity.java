package com.cmpundhir.cm.allwidgetsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity implements View.OnClickListener {
Button btn,btn2,btn3,btn4;
ImageButton imageButton;
RadioGroup radioGroup;
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
        int radio_id = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radio_id);
        if(radio_id == -1){
            Toast.makeText(ButtonActivity.this, "No Radio button is selected", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ButtonActivity.this, "You have selected radiobutton"+radioButton.getText(), Toast.LENGTH_LONG).show();
        }
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
