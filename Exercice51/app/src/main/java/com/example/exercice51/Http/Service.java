package com.example.exercice51.Http;

import com.example.exercice51.transfert.Repo;
import com.example.exercice51.transfert.utilisateur;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {
        @GET("users/{user}/repos")
        Call<String> listReposString(@Path("user") String utilisateur);
        @GET("users/{user}")
        Call<String> utilisateurString(@Path("user") String utilisateur);
        @GET("users/{user}")
        Call<utilisateur> utilisateur(@Path("user") String utilisateur);

        @GET("users/{user}/repos")
        Call<List<Repo>> listRepos(@Path("user") String utilisateur);
}
