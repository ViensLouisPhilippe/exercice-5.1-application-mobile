package com.example.attentea;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceAttenteA {
    @GET("exos/waitaminute")
    Call<String> waitAMinute();
}
