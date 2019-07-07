package com.cmpundhir.cm.allwidgetsdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DialogueActivity extends AppCompatActivity implements View .OnClickListener{
Button btn;
    private void init(){
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue);
        init();
    }

    @Override
    public void onClick(View view) {
        showDialogue();
    }
    private void showDialogue(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Important Message!!");
        builder.setMessage("This dialogue box warns you if you want to exit this activity or not");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                Toast.makeText(DialogueActivity.this, "Exit the Activity",Toast.LENGTH_LONG ).show();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DialogueActivity.this, "You are decided to not exit the activity", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog dialogue = builder.create();
        dialogue.show();
    }
}