package com.example.nilai.network;

import com.example.nilai.model.NilaiResponse;
import com.example.nilai.model.User;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @FormUrlEncoded
    @POST("list_jawaban")
    Call<NilaiResponse> postNilai(@FieldMap HashMap<String, String> params);


//    @POST("list_jawaban")
//    Call<NilaiResponse> postNilai(@Body User user);
}
