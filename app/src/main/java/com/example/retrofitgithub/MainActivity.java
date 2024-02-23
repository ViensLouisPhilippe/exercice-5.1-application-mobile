package com.example.retrofitgithub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.retrofitgithub.databinding.ActivityMainBinding;
import com.example.retrofitgithub.http.Service;
import com.example.retrofitgithub.http.retrofitUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    LongAdapter longAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        initRecycler();
        fillRecycler();

    }

    private void initRecycler() {
        RecyclerView recyclerView = binding.rvLongs;
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        longAdapter = new LongAdapter();
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(longAdapter);
    }

    private void fillRecycler() {
        longAdapter.longList.clear();
        Service service = (Service) retrofitUtil.get();
        service.getLongs().enqueue(new Callback<List<Long>>() {
            @Override
            public void onResponse(Call<List<Long>> call, Response<List<Long>> response) {
                if (response.isSuccessful())
                {
                    List<Long> list = response.body();
                    longAdapter.longList = list;
                    longAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Long>> call, Throwable t) {

            }
        });
    }
}