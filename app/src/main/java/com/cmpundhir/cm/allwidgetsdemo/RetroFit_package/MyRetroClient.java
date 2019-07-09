package com.cmpundhir.cm.allwidgetsdemo.RetroFit_package;

import com.cmpundhir.cm.allwidgetsdemo.RetroFit_package.api.MyApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetroClient {
    private static Retrofit retrofit = null;
    private static Retrofit init(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.github.com").build();
        }
        return retrofit;
    }
    public static MyApi api =init().create(MyApi.class);
}
