package com.example.nilai.model;

public class User {

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getKode_soal() {
        return kode_soal;
    }

    public void setKode_soal(int kode_soal) {
        this.kode_soal = kode_soal;
    }

    private String username;
    private String password;
    private int kode_soal;

    public User(String username, String password, int kode_soal) {
        this.username = username;
        this.password = password;
        this.kode_soal = kode_soal;
    }
}
