package com.example.nilai;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.nilai.adapter.SoalAdapter;
import com.example.nilai.model.Nilai;
import com.example.nilai.model.NilaiResponse;
import com.example.nilai.model.User;
import com.example.nilai.network.ApiService;
import com.example.nilai.network.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    ArrayList<Nilai> nilaiList = null;

    private SoalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        String username;
        String password;
        String kode;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                username= null;
                password= null;
                kode= null;
            } else {
                username= extras.getString("USERNAME");
                password= extras.getString("PASSWORD");
                kode= extras.getString("KODE");
            }
        } else {
            username= (String) savedInstanceState.getSerializable("USERNAME");
            password= (String) savedInstanceState.getSerializable("PASSWORD");
            kode= (String) savedInstanceState.getSerializable("KODE");
        }

        HashMap<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        params.put("kode_ujian", kode);

        RecyclerView.LayoutManager mading = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(mading);

        getNilai(params);

    }

    private void getNilai(HashMap<String, String> params) {
        ApiService service = RetrofitClientInstance.retrofit().create(ApiService.class);
        Call<NilaiResponse> call = service.postNilai(params);
        call.enqueue(new Callback<NilaiResponse>() {
            @Override
            public void onResponse(Call<NilaiResponse> call, Response<NilaiResponse> response) {
                NilaiResponse nilaiResponse = response.body();

                nilaiList = nilaiResponse.getResult();
                Log.i("Data", "onResponse : " + "get nilai " + nilaiResponse.getPesan());
                Log.i("Data", "onResponse : " + "get nilai " + nilaiResponse.getStatus());
//
                if (response.isSuccessful()) {
                    for (int i = 0; i < nilaiList.size(); i++) {
                        Nilai nilai = nilaiList.get(i);

                        Log.i("Data", "onResponse : " + nilai.getSoal());
                    }
                }


                adapter = new SoalAdapter(nilaiList,getApplicationContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<NilaiResponse> call, Throwable t) {
                Log.e("Error", "failed : " + t.getLocalizedMessage());
            }
        });
    }

}
