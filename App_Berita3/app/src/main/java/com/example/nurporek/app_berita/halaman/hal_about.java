package com.example.nurporek.app_berita.halaman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.nurporek.app_berita.R;

public class hal_about extends AppCompatActivity {
    private static final String MY_PREFS_NAME = "USER";
    public int id_user, logged;
    public String nama, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hal_about);

        Intent intentku = getIntent();
        id_user = intentku.getIntExtra("id_user", 0);
        logged = intentku.getIntExtra("logged", 0);
        nama = intentku.getStringExtra("nama_user");
        email = intentku.getStringExtra("e_mail");
    }
}
