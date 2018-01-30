package com.example.nurporek.app_berita.halaman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.nurporek.app_berita.R;
import com.example.nurporek.app_berita.adapter.IsiAdapter;
import com.example.nurporek.app_berita.generator.ServiceGenerator;
import com.example.nurporek.app_berita.model.Isi;
import com.example.nurporek.app_berita.services.Services;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class hal_teknologi extends AppCompatActivity {
    public int id_user, logged;
    public String nama, email;
    public TextView txtJudul;
    Services gotService;
    int count;
    RecyclerView rvIsi;
    IsiAdapter mDataAdapter;
    int idp;
    List<Isi> isiList = new ArrayList<>();
    RecyclerView.LayoutManager mLayoutManager;
    public TextView txt4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hal_teknologi);

        Intent i = getIntent();
        id_user = i.getIntExtra("id_user", 0);
        logged = i.getIntExtra("logged", 0);
        nama = i.getStringExtra("nama_user");
        email = i.getStringExtra("e_mail");

        gotService = ServiceGenerator.createService(Services.class);
        reloadData();
        mDataAdapter = new IsiAdapter(getApplicationContext(), isiList, id_user, email, logged, "Lely");
        rvIsi = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        rvIsi.setAdapter(mDataAdapter);
        rvIsi.setLayoutManager(mLayoutManager);
    }

    private void reloadData(){
        Call<List<Isi>> call = gotService.getByKat(5);
        call.enqueue(new Callback<List<Isi>>() {
            @Override
            public void onResponse(Call<List<Isi>> call, Response<List<Isi>> response) {
                Log.d("SOKO", "SUKSES");
                isiList.clear();
                isiList.addAll(response.body());
                mDataAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Isi>> call, Throwable t) {
                Log.d("SOKO", "GAGAL");
            }
        });
    }
}
