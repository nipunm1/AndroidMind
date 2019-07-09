package com.cmpundhir.cm.allwidgetsdemo.RetroFit_package;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cmpundhir.cm.allwidgetsdemo.R;
import com.cmpundhir.cm.allwidgetsdemo.RetroFit_package.model.MyGitInfo;

import org.w3c.dom.Text;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {
    public MyRecyclerAdapter(final Activity context, final List<MyGitInfo> list) {
        this.context = context;
        this.list = list;
    }

    Activity context;
List<MyGitInfo>list;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.custome_recyclerview, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyGitInfo myGitInfo =list.get(position);
        holder.textView.setText(myGitInfo.getLogin());
        holder.textView2.setText(myGitInfo.getId()+"");
        Glide.with(context).load(myGitInfo.getAvatarUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView,textView2;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.title);
            textView2 = itemView.findViewById(R.id.subtitle);
            imageView = itemView.findViewById(R.id.icon);
        }
    }
}
