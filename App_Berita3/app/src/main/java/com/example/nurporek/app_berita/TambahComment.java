package com.example.nurporek.app_berita;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nurporek.app_berita.adapter.KomentarAdapter;
import com.example.nurporek.app_berita.generator.ServiceGenerator;
import com.example.nurporek.app_berita.model.Komentar;
import com.example.nurporek.app_berita.model.User;
import com.example.nurporek.app_berita.services.Services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahComment extends AppCompatActivity {
    Services gotService;
    EditText komentar;
    public String id_isi, nama;
    public int idisi, id_user, logged;
    FloatingActionButton btnKomentarin;
    RecyclerView rvKomen;
    KomentarAdapter mDataAdapter;
    List<Komentar> komentarList = new ArrayList<>();
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_comment);
        Intent i = getIntent();
        id_isi = i.getStringExtra("id");
        id_user = i.getIntExtra("id_user", 0);
        nama = i.getStringExtra("nama_user");
        logged = i.getIntExtra("logged", 0);
        idisi = Integer.parseInt(id_isi);
        gotService = ServiceGenerator.createService(Services.class);
        reloadData();
        mDataAdapter = new KomentarAdapter(getApplicationContext(), komentarList);
        mLayoutManager = new LinearLayoutManager(this);
        rvKomen = (RecyclerView) findViewById(R.id.recyclerView2);
        rvKomen.setLayoutManager(mLayoutManager);
        rvKomen.setAdapter(mDataAdapter);

        komentar = (EditText) findViewById(R.id.comment);
        //komentar.getText();

        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        final String formattedDate = df.format(c.getTime());

        btnKomentarin = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        btnKomentarin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (logged==0){
                    Toast.makeText(getApplicationContext(), "Login first, please!", Toast.LENGTH_LONG).show();
                }else {
                    Komentar r = new Komentar(id_user, idisi, komentar.getText().toString(), formattedDate);
                    //Call<User> cll = service.createUser(r);
                    //Call<User> call = service.createUser(r);
                    Call<User> call = gotService.createKomen(r);
                    call.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            Toast.makeText(getApplicationContext(), "Sukses", Toast.LENGTH_SHORT).show();
                            reloadData();
                            //Intent i = new Intent(getApplicationContext(), TambahComment.class);
                            //startActivity(i);
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });
    }

    private void reloadData(){
        Call<List<Komentar>> call = gotService.getKomen(idisi);
        call.enqueue(new Callback<List<Komentar>>() {
            @Override
            public void onResponse(Call<List<Komentar>> call, Response<List<Komentar>> response) {
                Log.d("SOKO", "SUKSES");
                komentarList.clear();
                komentarList.addAll(response.body());
                mDataAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Komentar>> call, Throwable t) {
                Log.d("SOKO", "GAGAL");
            }
        });
    }
}
