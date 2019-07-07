package com.cmpundhir.cm.allwidgetsdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cmpundhir.cm.allwidgetsdemo.RecyclerView_package.LanguageDetails;

import java.util.ArrayList;
import java.util.List;

public class RecyclerVierActivity extends AppCompatActivity {
    List<LanguageDetails>list = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_vier);
        recyclerView = findViewById(R.id.recyclerView);
        LanguageDetails languageDetails1 = new LanguageDetails("Java", "OOPS Language", R.drawable.java);
        list.add(languageDetails1);
        LanguageDetails languageDetails2 = new LanguageDetails("C++", "Not Purely OOPS Language", R.drawable.cplusplus);
        list.add(languageDetails2);
        LanguageDetails languageDetails3 = new LanguageDetails("C#", "Desktop Language", R.drawable.chash);
        list.add(languageDetails3);
        LanguageDetails languageDetails4 = new LanguageDetails("JavaScript", "Web Based Client Side Language", R.drawable.javascript);
        list.add(languageDetails4);
        LanguageDetails languageDetails5 = new LanguageDetails("Python", "Advance Language", R.drawable.python);
        list.add(languageDetails5);
        recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerVierActivity.this));
        RecyclerAdapter recyclerViewAdapter = new RecyclerAdapter(RecyclerVierActivity.this,list);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Viewholder> {

    Activity context;
    List<LanguageDetails> list;
    public RecyclerAdapter(Activity context, List<LanguageDetails> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.custome_recyclerview,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        LanguageDetails languageDetails = list.get(position);
        holder.img.setImageDrawable(context.getDrawable(languageDetails.getLogo()));
        holder.tv.setText(languageDetails.getName());
        holder.tv2.setText(languageDetails.getDesc());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView tv,tv2;
        ImageView img;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.icon);
            tv = itemView.findViewById(R.id.title);
            tv2 = itemView.findViewById(R.id.subtitle);
        }
    }
}
