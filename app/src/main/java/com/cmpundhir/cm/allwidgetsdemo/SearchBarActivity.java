package com.cmpundhir.cm.allwidgetsdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
//import com.cmpundhir.cm.allwidgetsdemo.ListView_package.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchBarActivity extends AppCompatActivity {
SearchView searchView;
ListView listView;
String language[] = {"Java","C++","C#","JavaScript","Python"};
//int logo[] = {R.drawable.java,R.drawable.cplusplus,R.drawable.chash,R.drawable.javascript,R.drawable.python};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_bar);
        searchView = findViewById(R.id.search_View);
        listView = findViewById(R.id.listView);
        final ArrayAdapter myAdapter = new ArrayAdapter(SearchBarActivity.this, android.R.layout.simple_list_item_1, language);
        //final MyAdapter myAdapter = new MyAdapter(SearchBarActivity.this,language, logo);
        listView.setAdapter(myAdapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Log.d("TAG", "Your result");
                myAdapter.getFilter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                myAdapter.getFilter().filter(s);
                return false;
            }
        });
    }
}
/*class MyAdapter extends ArrayAdapter<String>{
Activity context;
String language[];
int language_icon[];

    public MyAdapter(@NonNull Activity context, String language[],int language_icon[]) {
        super(context,R.layout.custome_listview2,language);
        this.context = context;
        this.language= language;
        this.language_icon = language_icon;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable final View convertView, @NonNull final ViewGroup parent) {
        LayoutInflater inflater= context.getLayoutInflater();
        View view = inflater.inflate(R.layout.custome_listview2, parent,false);
        TextView textView;
        ImageView imageView;
        textView = view.findViewById(R.id.title);
        imageView = view.findViewById(R.id.icon);
        textView.setText(language[position]);
        imageView.setImageResource(language_icon[position]);
        return view;
    }
}*/