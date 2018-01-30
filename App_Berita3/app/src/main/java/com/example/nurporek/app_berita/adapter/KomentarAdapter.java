package com.example.nurporek.app_berita.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nurporek.app_berita.R;
import com.example.nurporek.app_berita.model.Komentar;

import java.util.List;

/**
 * Created by Lely on 01/28/2018.
 */

public class KomentarAdapter extends RecyclerView.Adapter<KomentarAdapter.ViewHolder> {
    Context context;
    List<Komentar> komentarList;

    public KomentarAdapter(Context context, List<Komentar> komentarList) {
        this.context = context;
        this.komentarList = komentarList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Komentar itemKomentar = komentarList.get(position);
        holder.txtNama.setText(itemKomentar.getNama());
        holder.txtKomentar.setText(itemKomentar.getKomentar());
    }

    @Override
    public int getItemCount() {
        return komentarList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNama, txtKomentar;
        public ViewHolder(View itemView) {
            super(itemView);
            txtKomentar = itemView.findViewById(R.id.comment);
            txtNama = itemView.findViewById(R.id.nama);
        }
    }
}
