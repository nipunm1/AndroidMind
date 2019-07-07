package com.cmpundhir.cm.allwidgetsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ButterKnifeActivity extends AppCompatActivity {
    @BindView(R.id.email)
    TextInputEditText e_mail;
    @BindView(R.id.password)
    TextInputEditText pass;
    @BindString(R.string.email)
    String email;
    @BindString(R.string.password)
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_knife);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.login)
    public void loginbtn(View view){
        String e,p;
        e = e_mail.getText().toString();
        p = pass.getText().toString();
        if(TextUtils.isEmpty(e)){
            e_mail.setError("Please enter email");
            Toast.makeText(ButterKnifeActivity.this, "Please enter email", Toast.LENGTH_LONG).show();
        }
        if(TextUtils.isEmpty(p)){
            pass.setError("Please enter password");
            Toast.makeText(ButterKnifeActivity.this, "Please enter password", Toast.LENGTH_LONG).show();
        }
        if(e.equals(email)){
            if(p.equals(password)){
                Toast.makeText(ButterKnifeActivity.this, "Successfully Login", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(ButterKnifeActivity.this, "Wrong Password", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(ButterKnifeActivity.this, "Wrong Email", Toast.LENGTH_LONG).show();
        }
    }
}
