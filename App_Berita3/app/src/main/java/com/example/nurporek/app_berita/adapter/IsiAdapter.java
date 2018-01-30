package com.example.nurporek.app_berita.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nurporek.app_berita.DetailBerita;
import com.example.nurporek.app_berita.R;
import com.example.nurporek.app_berita.model.Isi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Lely on 01/26/2018.
 */

public class IsiAdapter extends RecyclerView.Adapter<IsiAdapter.IsiViewHolder>{
    Context context;
    List<Isi> isiList;
    int id_user, logged;
    String nama, email;

    public IsiAdapter(Context context, List<Isi> isiList, int id_user, String email, int logged, String nama) {
        this.context = context;
        this.isiList = isiList;
        this.id_user = id_user;
        this.logged = logged;
        this.nama = nama;
        this.email = email;
    }

    @Override
    public IsiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_teknologi, parent, false);
        IsiViewHolder vh = new IsiViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(IsiViewHolder holder, int position) {
        final Isi itemIsi = isiList.get(position);
        holder.txtJudul.setText(itemIsi.getJudul());
        final String link = "http://192.168.43.166/news-master/uploads/original/";

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String dateString = null;
                DateFormat inputFormatter1 = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = null;
                try {
                    date1 = inputFormatter1.parse(itemIsi.getTanggal());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                DateFormat outputFormatter1 = new SimpleDateFormat("dd-MMM-yyyy");
                String finalDateString = outputFormatter1.format(date1);

//                SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
//                String dateString = sdfr.format(itemIsi.getTanggal());
//                final String finalDateString = dateString;

                Intent i = new Intent(v.getContext(),DetailBerita.class);
                i.putExtra("id_isi", itemIsi.getIdIsi());
                i.putExtra("judul", itemIsi.getJudul());
                i.putExtra("linkgambar", itemIsi.getGambar());
                Log.d("COBA ",itemIsi.getGambar());
                i.putExtra("isi", itemIsi.getIsi());
                i.putExtra("tanggal", finalDateString);
                i.putExtra("nama_reporter", itemIsi.getNamaReporter());
                i.putExtra("id_user", id_user);
                i.putExtra("logged", logged);
                i.putExtra("nama_user", nama);
                i.putExtra("email", email);
//                i.putExtra("likes", itemIsi.getLikes());
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return isiList.size();
    }

    public class IsiViewHolder extends RecyclerView.ViewHolder {
        TextView txtJudul;
        ImageView imageView;
        public IsiViewHolder(View itemView) {
            super(itemView);
            txtJudul= itemView.findViewById(R.id.txtJudul);
            imageView = itemView.findViewById(R.id.imageView7);
        }
    }
}
