package com.example.nilai.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NilaiResponse {
    @SerializedName("status")
    private Integer status;

    @SerializedName("pesan")
    private String pesan;


    @SerializedName("result")
    private ArrayList<Nilai> result = null;

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ArrayList<Nilai> getResult() {
        return result;
    }

    public void setResult(ArrayList<Nilai> result) {
        this.result = result;
    }
}
