package com.example.nilai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nilai.model.Nilai;
import com.example.nilai.model.NilaiResponse;
import com.example.nilai.model.User;
import com.example.nilai.network.ApiService;
import com.example.nilai.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUsername, edtPassword, edtKodeSoal;
    private Button btnLogin;
    String username, password,kode_soal;
    private List<Nilai> nilaiList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtKodeSoal = (EditText) findViewById(R.id.edtKodeSoal);
        btnLogin = (Button) findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = edtUsername.getText().toString();
                password = edtPassword.getText().toString();
                kode_soal = edtKodeSoal.getText().toString();

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("USERNAME", username);
                intent.putExtra("PASSWORD", password);
                intent.putExtra("KODE", kode_soal);
                startActivity(intent);
            }
        });
    }
}
