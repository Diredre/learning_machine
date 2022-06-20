package com.example.learning_machine.Retrofit.Api;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * description: 下载请求
 */
public interface DownLoadApi {

    @Streaming
    @GET()
    Call<ResponseBody> downLoadApi(@Url String url);

    @Streaming
    @GET()
    Call<ResponseBody> downLoadApi(@Url String url, @QueryMap Map<String, String> maps);

}