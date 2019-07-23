package com.cmpundhir.cm.allwidgetsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cmpundhir.cm.allwidgetsdemo.SqlLite_package.dao.UsersDaoSqlLiteHelper;
import com.cmpundhir.cm.allwidgetsdemo.SqlLite_package.model.Demo;

import java.util.List;

public class SqlLiteActivity extends AppCompatActivity {
EditText editText,editText2,editText3;
Button button;
TextView textView;
UsersDaoSqlLiteHelper usersDaoSqlLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_lite);
        editText = findViewById(R.id.edit);
        editText2 = findViewById(R.id.edit2);
        editText3 = findViewById(R.id.edit3);
        button = findViewById(R.id.btn);
        textView = findViewById(R.id.text);
        usersDaoSqlLiteHelper = new UsersDaoSqlLiteHelper(SqlLiteActivity.this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name,email,pass;
                name = editText.getText().toString();
                email = editText2.getText().toString();
                pass = editText3.getText().toString();
                if(name.equals("")){
                    editText.setError("Please enter name to add in sqllite");
                    return;
                }
                if(email.equals("")){
                    editText2.setError("Please enter email to add in sqllite");
                    return;
                }
                if(pass.equals("")){
                    editText3.setError("Please enter password to add in sqllite");
                    return;
                }
                Demo demo = new Demo(name, email, pass);
                usersDaoSqlLiteHelper.addDemo(demo);
                Toast.makeText(SqlLiteActivity.this, "Data added to demo table", Toast.LENGTH_LONG).show();
                List<Demo> list = usersDaoSqlLiteHelper.getallDemo();
                textView.setText(list+"");

            }
        });
        List<Demo> list = usersDaoSqlLiteHelper.getallDemo();
        if(list.size()>0){
            textView.setText(list+"");
        }
    }
}
