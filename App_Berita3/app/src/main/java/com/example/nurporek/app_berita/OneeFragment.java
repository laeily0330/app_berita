package com.example.nurporek.app_berita;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nurporek.app_berita.adapter.IsiAdapter;
import com.example.nurporek.app_berita.generator.ServiceGenerator;
import com.example.nurporek.app_berita.model.Isi;
import com.example.nurporek.app_berita.services.Services;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class OneeFragment extends Fragment {

    public OneeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


//        try {
//            View rootView = inflater.inflate(R.layout.fragment_onee, container, false);
//            URL url = new URL("https://www.mcdonalds.co.id/uploads/8XXMt9j6tI3pm0m6ueLO.jpg");
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setDoInput(true);
////            connection.connect();
//            InputStream input = connection.getInputStream();
//            Bitmap bitmap = BitmapFactory.decodeStream(input);
//            ImageView gambar = (ImageView) rootView.findViewById(R.id.imageV);
//            gambar.setImageBitmap(bitmap);
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
////        Picasso.with(this).load("").into(gambar);
////        return inflater.inflate(R.layout.fragment_onee, container, false);
        return inflater.inflate(R.layout.fragment_onee, container, false);

    }


}