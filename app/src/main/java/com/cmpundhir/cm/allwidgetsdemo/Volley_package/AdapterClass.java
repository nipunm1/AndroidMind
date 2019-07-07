package com.cmpundhir.cm.allwidgetsdemo.Volley_package;

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

import java.util.List;


public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> {
    Activity context;
    List<FollowingClass>list;
    public AdapterClass(final Activity context, final List<FollowingClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.custome_recyclerview_volley, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FollowingClass followingClass = list.get(position);
        holder.tv.setText(followingClass.getLogin());
        holder.tv2.setText(followingClass.getId()+"");
        Glide.with(context).load(followingClass.getAvatarUrl()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv,tv2;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.name);
            tv2 = itemView.findViewById(R.id.id);
            img = itemView.findViewById(R.id.image);
        }
    }
}
