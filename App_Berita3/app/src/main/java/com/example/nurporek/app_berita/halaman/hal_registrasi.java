package com.example.nurporek.app_berita.halaman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nurporek.app_berita.R;
import com.example.nurporek.app_berita.generator.ServiceGenerator;
import com.example.nurporek.app_berita.model.User;
import com.example.nurporek.app_berita.services.Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class hal_registrasi extends AppCompatActivity {
    EditText nama, email, password, tanggal_lahir, alamat;
    Button add;
    Date date1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hal_registrasi);
        final Services service = ServiceGenerator.createService(Services.class);

        nama = (EditText) findViewById(R.id.etNama);
        email = (EditText) findViewById(R.id.etEmail);
        password = (EditText) findViewById(R.id.etPassword);
        tanggal_lahir = (EditText) findViewById(R.id.etDate);
        alamat = (EditText) findViewById(R.id.etKota);
        add = (Button) findViewById(R.id.button2);


        try {
            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(tanggal_lahir.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User r = new User(nama.getText().toString(), alamat.getText().toString(), email.getText().toString(), tanggal_lahir.getText().toString(), password.getText().toString());
                //Call<User> cll = service.createUser(r);
                //Call<User> call = service.createUser(r);
                Call<User> call = service.createUser(r);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Toast.makeText(getApplicationContext(), "Sukses", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(i);
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
