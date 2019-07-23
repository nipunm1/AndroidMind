package com.cmpundhir.cm.allwidgetsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPreferenceActivity extends AppCompatActivity {
EditText editText,editText2,editText3;
Button button;
TextView textView;
SharedPreferences sharedPreferences;
SharedPreferences.Editor editor;
String demo_name,demo_email,demo_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        editText = findViewById(R.id.edit);
        editText2 = findViewById(R.id.edit2);
        editText3 = findViewById(R.id.edit3);
        button = findViewById(R.id.btn);
        textView = findViewById(R.id.text);
        sharedPreferences = getSharedPreferences("demo", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name,email,pass;
                name = editText.getText().toString();
                email = editText2.getText().toString();
                pass = editText3.getText().toString();
                if(name.equals("")){
                    editText.setError("Please enter Name to check");
                    return;
                }
                if(email.equals("")){
                    editText2.setError("Please enter Email to check");
                    return;
                }
                if(pass.equals("")){
                    editText3.setError("Please enter Password to check");
                    return;
                }
                editor.putString("name", name);
                editor.putString("email", email);
                editor.putString("password", pass);
                editor.commit();
                demo_name = sharedPreferences.getString("name", "");
                demo_email = sharedPreferences.getString("email", "");
                demo_pass = sharedPreferences.getString("password", "");
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Name = "+demo_name+"\n");
                stringBuffer.append("Email = "+demo_email+"\n");
                stringBuffer.append("Password = "+demo_pass+"\n");
                textView.setText(stringBuffer.toString());
            }
        });
    }
}
