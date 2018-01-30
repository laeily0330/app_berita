package com.example.nurporek.app_berita.services;

import com.example.nurporek.app_berita.model.Isi;
import com.example.nurporek.app_berita.model.Kategori;
import com.example.nurporek.app_berita.model.Komentar;
import com.example.nurporek.app_berita.model.Reporter;
import com.example.nurporek.app_berita.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

/**
 * Created by Lely on 01/15/2018.
 */

public interface Services {
    @GET("kategori")
    Call<List<Kategori>> getKategori();

    @GET("user")
    Call<List<User>> getUser();

    @GET("komentar?")
    Call<List<Komentar>> getKomen(@Query("id_isi") int idIsi);

    @POST("komentar")
    Call<User> createKomen(@Body Komentar itemKomen);

    @POST("user")
    Call<User> createUser(@Body User itemUser);

    @GET("reporter")
    Call<List<Reporter>> getReporter();

    @GET("isi")
    Call<List<Isi>> getIsi();

    @GET("isi2?")
    Call<List<Isi>> getByKat(@Query("id_kategori") int idKategori);

    @PUT("like?")
    Call<Isi> like(@Query("id_isi") int id_isi, @Body Isi itemIsi);

    @GET("latest")
    Call<List<Isi>> getLatest();

}
