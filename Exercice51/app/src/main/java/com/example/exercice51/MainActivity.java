package com.example.exercice51;

import com.example.exercice51.Http.retrofitUtil;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.exercice51.Http.Service;
import com.example.exercice51.transfert.Repo;
import com.example.exercice51.transfert.utilisateur;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Service service = retrofitUtil.get();
        service.listRepos("jorisdeguet").enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                if (response.isSuccessful()) {
                    //tous c bien passer
                    List<Repo> resultat = response.body();
                    Log.i("RETROFIT", resultat.size() + "");
                } else {
                    // cas erreur http 400 404
                    Log.i("RETROFIT", response.code() + "");
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                //erreur accès reseau ou alors Gson
                Log.i("RETROFIT", t.getMessage());
            }
        });


        TextView tv = findViewById(R.id.textview);
        EditText et = findViewById(R.id.ed);
        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = et.getText().toString();
                service.utilisateur(nom).enqueue(new Callback<utilisateur>() {
                    @Override
                    public void onResponse(Call<utilisateur> call, Response<utilisateur> response) {
                        if(response.isSuccessful()){
                            tv.setText(response.body().id + "");
                        }
                        else
                        {

                        }
                    }

                    @Override
                    public void onFailure(Call<utilisateur> call, Throwable t) {

                    }
                });
            }
        });
    }
}