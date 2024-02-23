package com.example.retrofitgithub.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class retrofitUtil {
    public static com.example.retrofitgithub.http.Service get(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://4n6.azurewebsites.net/")
                .build();

        com.example.retrofitgithub.http.Service service = retrofit.create(Service.class);
        return service;
    }
}
