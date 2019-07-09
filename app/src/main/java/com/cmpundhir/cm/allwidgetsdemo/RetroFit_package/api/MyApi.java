package com.cmpundhir.cm.allwidgetsdemo.RetroFit_package.api;

import com.cmpundhir.cm.allwidgetsdemo.RetroFit_package.model.MyGitInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyApi {
    @GET("/users/{user}/following")
    Call<List<MyGitInfo>> mygitinfo(@Path("user")String user);
    @GET("users/{user}")
    Call<MyGitInfo> mygitinfo2(@Path("user")String user);
}
