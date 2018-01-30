package com.example.nurporek.app_berita;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nurporek.app_berita.generator.ServiceGenerator;
import com.example.nurporek.app_berita.model.Isi;
import com.example.nurporek.app_berita.services.Services;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DetailBerita extends AppCompatActivity {

    TextView id_isi, judul, tanggal, nama_reporter, isi, haha, likes;
    ImageView gambar;
    Button btnLike, btnSeeComment;
    int likeUpdate;
    Services service = ServiceGenerator.createService(Services.class);

    public int likeIt, id_berita;
    public String id,img;
    public int id_user;
    public int logged;
    String nama, email, _gambar;
    List<Isi> isiList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);

        Intent i = getIntent();
        //id_isi = (TextView) findViewById(R.id.txtIdOrg);
        id = i.getStringExtra("id_isi");
        judul = (TextView) findViewById(R.id.txtJudul);
        judul.setText(i.getStringExtra("judul"));
        tanggal = (TextView) findViewById(R.id.txtTanggal);
        tanggal.setText(i.getStringExtra("tanggal"));
        nama_reporter = (TextView) findViewById(R.id.txtReporter);
        nama_reporter.setText(i.getStringExtra("nama_reporter"));
        img = i.getStringExtra("linkgambar");
        ImageView gambar = (ImageView) findViewById(R.id.gambar);
        Picasso.with(this).load(img).into(gambar);
        Log.d("INI BUAT DI DETAIL BERITA  ",i.getStringExtra("linkgambar"));

        isi = (TextView) findViewById(R.id.txtIsi);
        isi.setMovementMethod(new ScrollingMovementMethod());
        isi.setText(i.getStringExtra("isi"));
        id_user = i.getIntExtra("id_user",0);
        logged = i.getIntExtra("logged", 0);
        nama = i.getStringExtra("nama_user");
        email = i.getStringExtra("email");
        //id_berita = Integer.parseInt(id);

        //likes = (TextView) findViewById(R.id.txtLikes);
        //likes.setText(id);
//        likeIt = i.getIntExtra("likes", 0);
//        likeUpdate = likeIt+1;

//        btnLike = (Button) findViewById(R.id.btnLikes);
//        btnLike.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Isi itemIsi = new Isi(likeUpdate);
//                Call<Isi> call = service.like(id, itemIsi);
//                call.enqueue(new Callback<Isi>() {
//                    @Override
//                    public void onResponse(Call<Isi> call, Response<Isi> response) {
//                        Toast.makeText(getApplicationContext(), "Sukses", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onFailure(Call<Isi> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        });

        btnSeeComment = (Button) findViewById(R.id.btnSeeComment);
        btnSeeComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), TambahComment.class);
                i.putExtra("id", id);
                i.putExtra("id_user", id_user);
                i.putExtra("nama_user", nama);
                i.putExtra("logged", logged);
                startActivity(i);
            }
        });
    }
}
