package com.example.retrofitgithub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.retrofitgithub.databinding.ActivityMainBinding;
import com.example.retrofitgithub.http.Service;
import com.example.retrofitgithub.http.Truc;
import com.example.retrofitgithub.http.retrofitUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    LongAdapter longAdapter;
    TrucAdapter trucAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
           setContentView(view);
//        initRecyclerLong();
//        fillRecyclerLong();
        initRecyclerTruc();
        fillRecyclerTruc();

    }

    private void initRecyclerLong() {
        RecyclerView recyclerView = binding.rvLongs;
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        longAdapter = new LongAdapter();
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(longAdapter);
    }

    private void fillRecyclerLong() {
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

    private void initRecyclerTruc() {
        RecyclerView recyclerView = binding.rvObjects;
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        trucAdapter = new TrucAdapter();
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(trucAdapter);
    }

    private void fillRecyclerTruc() {
        trucAdapter.trucList.clear();
        Service service = retrofitUtil.get();
        service.getTrucs().enqueue(new Callback<List<Truc>>() {
            @Override
            public void onResponse(Call<List<Truc>> call, Response<List<Truc>> response) {
                if (response.isSuccessful())
                {
                    List<Truc> list = response.body();
                    trucAdapter.trucList = list;
                    trucAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Truc>> call, Throwable t) {

            }
        });
    }
}