package com.example.nilai.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nilai {
    @SerializedName("soal")
    @Expose
    private String soal;
    @SerializedName("jawbaban_terpilih")
    @Expose
    private String jawbabanTerpilih;

    private int status;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getJawbabanTerpilih() {
        return jawbabanTerpilih;
    }

    public void setJawbabanTerpilih(String jawbabanTerpilih) {
        this.jawbabanTerpilih = jawbabanTerpilih;
    }
}
