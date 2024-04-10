package com.example.attentea;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btn_go);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        textView = (TextView) findViewById(R.id.tv_text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDownload();
                RetrofitUtil.get().waitAMinute().enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        endDownload();
                        Toast.makeText(getApplicationContext(), "Yes", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        endDownload();
                        Toast.makeText(getApplicationContext(), "Non", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });



    }
    private void startDownload(){
        progressBar.setVisibility(View.VISIBLE);
        textView.setVisibility(View.GONE);
        button.setText("En attente de chargement");
        button.setBackgroundColor(Color.GRAY);
    }
    private void endDownload(){
        progressBar.setVisibility(View.GONE);//INVISIBLE occupe de l'espace GONE non
        textView.setVisibility(View.VISIBLE);
        button.setText("Je suis un bouton");
        button.setBackgroundColor(Color.BLACK);
    }
}