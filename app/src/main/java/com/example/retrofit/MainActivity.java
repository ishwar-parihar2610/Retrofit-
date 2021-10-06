package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;

import com.example.retrofit.Api.RetrofitClient;
import com.example.retrofit.R;
import com.example.retrofit.databinding.ActivityMainBinding;
import com.example.retrofit.model.Results;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    List<Results> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        results=new ArrayList<>();
        getSuperHero();

    }

    private void getSuperHero() {
        Call<List<Results>> call= RetrofitClient.getInstance().getMyApi().getHero();
        call.enqueue(new Callback<List<Results>>() {
            @Override
            public void onResponse(Call<List<Results>> call, Response<List<Results>> response) {
                results=response.body();
                adapter adapter=new adapter(results,MainActivity.this);
                binding.heroListRecycleView.setAdapter(adapter);
                
            }


            @Override
            public void onFailure(Call<List<Results>> call, Throwable t) {
                Log.d("error", "onFailure: "+t.getLocalizedMessage());

            }
        });
    }
}