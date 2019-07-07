package com.cmpundhir.cm.allwidgetsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.cmpundhir.cm.allwidgetsdemo.Volley_package.AdapterClass;
import com.cmpundhir.cm.allwidgetsdemo.Volley_package.FollowingClass;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class VolleyActivity extends AppCompatActivity {
//TextView textView;
//TextView textView2;
//ImageView imageView;
List<FollowingClass> list = new ArrayList<>();
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        //textView = findViewById(R.id.text);
        //textView2 = findViewById(R.id.text2);
        //imageView = findViewById(R.id.image);
        recyclerView = findViewById(R.id.recyclerView);
        //SimpleCodeVolley();
        //Volleywithapidatafetchandglide();
        gsontojavaclass();
    }
    //Simple Volley url request
    /*public void SimpleCodeVolley(){
        String url = "https://github.com/";
        final StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                textView.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("error"+error);
            }
        });
        RequestQueue queue = Volley.newRequestQueue(VolleyActivity.this);
        queue.add(request);
    }
    //Getting data using REST API and glide
    public void Volleywithapidatafetchandglide(){
        String url = "https://api.github.com/users/nipunm1";
        JsonObjectRequest request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    String name = response.getString("login");
                    int id  = response.getInt("id");
                    String img = response.getString("avatar_url");
                    textView.setText(name);
                    textView2.setText(id+"");
                    Glide.with(VolleyActivity.this).load(img).into(imageView);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("Error = "+error);
                textView2.setText("Error = "+error);
            }
        });
        RequestQueue queue = Volley.newRequestQueue(VolleyActivity.this);
        queue.add(request);
    }*/
    //Gson to Java class using volley
    public void gsontojavaclass(){
        String url = "https://api.github.com/users/nipunm1/following";
        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Gson gson = new Gson();
                for(int i=0;i<=response.length();i++){
                    try {
                        FollowingClass followingClass = gson.fromJson(response.get(i).toString(), FollowingClass.class);
                        list.add(followingClass);
                        recyclerView.setLayoutManager(new LinearLayoutManager(VolleyActivity.this));
                        AdapterClass adapterClass = new AdapterClass(VolleyActivity.this,list);
                        recyclerView.setAdapter(adapterClass);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(VolleyActivity.this, "error = "+error, Toast.LENGTH_LONG).show();
            }
        });
        RequestQueue queue = Volley.newRequestQueue(VolleyActivity.this);
        queue.add(request);
    }
}
