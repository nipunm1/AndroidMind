package com.cmpundhir.cm.allwidgetsdemo.RetroFit_package;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.cmpundhir.cm.allwidgetsdemo.R;
import com.cmpundhir.cm.allwidgetsdemo.RetroFit_package.model.MyGitInfo;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<String> {
    Activity context;
    List<MyGitInfo> list;

    public ListViewAdapter(@NonNull Activity context,@NonNull List list) {
        super(context, R.layout.custome_listview, list);
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable final View convertView, @NonNull final ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.custome_listview, parent,false);
        TextView textView,textView2;
        MyGitInfo myGitInfo = list.get(position);
        ImageView imageView;
        textView = view.findViewById(R.id.title);
        textView2 = view.findViewById(R.id.subtitle);
        imageView = view.findViewById(R.id.icon);
        textView.setText(myGitInfo.getLogin());
        textView2.setText(myGitInfo.getId()+"");
        Glide.with(context).load(myGitInfo.getAvatarUrl()).into(imageView);
        return view;
    }
}
