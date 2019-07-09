package com.cmpundhir.cm.allwidgetsdemo.ListView_package;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cmpundhir.cm.allwidgetsdemo.R;

public class   CustomeListViewActivity extends AppCompatActivity {
String title[] = {"Java","C++","C#","Python","JavaScript"};
String subtitle[] = {"OOPS Language","Not purely OOPS Language","Desktop Language","Advance Language","Scripting Client Side Language"};
Integer logo[] = {R.drawable.java,R.drawable.cplusplus,R.drawable.chash,R.drawable.python,R.drawable.javascript};
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custome_list_view);
        listView = findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter(CustomeListViewActivity.this, title, subtitle, logo);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    Toast.makeText(CustomeListViewActivity.this, "You have selected to learn java", Toast.LENGTH_LONG).show();
                }
                if(i == 1){
                    Toast.makeText(CustomeListViewActivity.this, "You have selected to learn c++", Toast.LENGTH_LONG).show();
                }
                if(i == 2){
                    Toast.makeText(CustomeListViewActivity.this, "You have selected to learn c#", Toast.LENGTH_LONG).show();
                }
                if(i == 3){
                    Toast.makeText(CustomeListViewActivity.this, "You have selected to learn python", Toast.LENGTH_LONG).show();
                }
                if(i == 4){
                    Toast.makeText(CustomeListViewActivity.this, "You have selected to learn javascript", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}


class MyAdapter extends ArrayAdapter<String>{
Activity context;
String[] title;
String[] subtitle;
Integer[] logo;
    public MyAdapter(@NonNull Activity context, @NonNull String[] title,String[] subtitle,Integer[] logo) {
        super(context, R.layout.custome_listview,title);
        this.context = context;
        this.title = title;
        this.subtitle = subtitle;
        this.logo = logo;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable final View convertView, @NonNull final ViewGroup parent) {
        LayoutInflater layoutInflater =context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.custome_listview, parent,false);
        TextView tv,tv2;
        ImageView img;
        tv = view.findViewById(R.id.title);
        tv2 = view.findViewById(R.id.subtitle);
        img = view.findViewById(R.id.icon);
        tv.setText(title[position]);
        tv2.setText(subtitle[position]);
        img.setImageResource(logo[position]);
        return view;
    }
}