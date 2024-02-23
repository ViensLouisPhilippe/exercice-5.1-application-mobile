package com.example.retrofitgithub.http;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("exos/long/list")
    Call<List<Long>> getLongs();

    @GET("exos/truc/list")
    Call<List<Truc>> getTrucs();
}
