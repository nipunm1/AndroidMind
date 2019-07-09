package com.cmpundhir.cm.allwidgetsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cmpundhir.cm.allwidgetsdemo.RetroFit_package.ListViewAdapter;
import com.cmpundhir.cm.allwidgetsdemo.RetroFit_package.MyRecyclerAdapter;
import com.cmpundhir.cm.allwidgetsdemo.RetroFit_package.MyRetroClient;
import com.cmpundhir.cm.allwidgetsdemo.RetroFit_package.model.MyGitInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetroFitActivity extends AppCompatActivity {
//RecyclerView recyclerView;
//ListView listView;
    TextView textView,textView2;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retro_fit);
        //recyclerView = findViewById(R.id.recyclerView);
        //listView = findViewById(R.id.list);
        textView = findViewById(R.id.text);
        textView2 = findViewById(R.id.text2);
        imageView = findViewById(R.id.image);
        //retrofit();
        retrofit2();
    }
    /*private void retrofit(){
        MyRetroClient.api.mygitinfo("nipunm1").enqueue(new Callback<List<MyGitInfo>>() {
            @Override
            public void onResponse(Call<List<MyGitInfo>> call, Response<List<MyGitInfo>> response) {
                List<MyGitInfo>list = response.body();
                //Log.d("list", list+"");
                recyclerView.setLayoutManager(new LinearLayoutManager(RetroFitActivity.this));
                MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(RetroFitActivity.this, list);
                recyclerView.setAdapter(myRecyclerAdapter);

                ListViewAdapter listViewAdapter = new ListViewAdapter(RetroFitActivity.this, list);
                listView.setAdapter(listViewAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        if(i==0){
                            Toast.makeText(RetroFitActivity.this, "You are following CMPumdhir", Toast.LENGTH_LONG).show();
                        }
                        if(i==1){
                            Toast.makeText(RetroFitActivity.this, "You are following akshay4532", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }

            @Override
            public void onFailure(Call<List<MyGitInfo>> call, Throwable t) {

            }
        });
    }*/
    private void retrofit2(){
        MyRetroClient.api.mygitinfo2("nipunm1").enqueue(new Callback<MyGitInfo>() {
            @Override
            public void onResponse(Call<MyGitInfo> call, Response<MyGitInfo> response) {
                MyGitInfo myGitInfo = response.body();
                String username = myGitInfo.getLogin();
                textView.setText(username);
                int id = myGitInfo.getId();
                textView2.setText(id+"");
                Glide.with(RetroFitActivity.this).load(myGitInfo.getAvatarUrl()).into(imageView);
            }

            @Override
            public void onFailure(Call<MyGitInfo> call, Throwable t) {
                Toast.makeText(RetroFitActivity.this,"error : "+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
