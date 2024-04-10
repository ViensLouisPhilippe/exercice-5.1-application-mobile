package com.example.attentea;


import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitUtil {
    public static ServiceAttenteA get(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl("https://4n6.azurewebsites.net/")
                .build();

        ServiceAttenteA service = retrofit.create(ServiceAttenteA.class);
        return service;
    }
}
