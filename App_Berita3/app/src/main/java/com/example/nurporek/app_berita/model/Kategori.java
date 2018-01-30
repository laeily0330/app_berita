package com.example.nurporek.app_berita.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Lely on 01/15/2018.
 */

public class Kategori {
    @SerializedName("id_kategori")
    @Expose
    private int id_kategori;

    @SerializedName("nama_kategori")
    @Expose
    private String nama_kategori;

    public Kategori(int id_kategori, String nama_kategori) {
        this.id_kategori = id_kategori;
        this.nama_kategori = nama_kategori;
    }

    public int getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(int id_kategori) {
        this.id_kategori = id_kategori;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }
}
