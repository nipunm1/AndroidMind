package com.cmpundhir.cm.allwidgetsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

public class AutoCompleteTextViewAndSpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
String language[] = {"Java","Python","Javascript","C++","C#"};
AutoCompleteTextView autoCompleteTextView;
Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view_and_spinner);
        init();
        AutoCompTV();
        Spin();
    }
    private void init(){
        autoCompleteTextView = findViewById(R.id.autotext);
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
    }
    //AutoCompleteTextView Code
    private void AutoCompTV(){
        ArrayAdapter<String>adapter = new ArrayAdapter<>(AutoCompleteTextViewAndSpinnerActivity.this, android.R.layout.select_dialog_item, language);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(adapter);
    }

    //Spinner Code
    private void Spin(){
        ArrayAdapter adapter = new ArrayAdapter(AutoCompleteTextViewAndSpinnerActivity.this, android.R.layout.simple_spinner_dropdown_item, language);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(AutoCompleteTextViewAndSpinnerActivity.this, "You have selected language "+language[i],Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
