package com.example.nurporek.app_berita.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Lely on 01/15/2018.
 */

public class User {
    @SerializedName("id_user")
    @Expose
    private int id_user;

    @SerializedName("nama")
    @Expose
    private String nama;

    @SerializedName("alamat")
    @Expose
    private String alamat;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("tanggal_lahir")
    @Expose
    private String tanggal_lahir;

    @SerializedName("password")
    @Expose
    private String password;

    public User(String nama, String alamat, String email, String tanggal_lahir, String password) {
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
        this.tanggal_lahir = tanggal_lahir;
        this.password = password;
    }

    public User(int id_user, String nama, String alamat, String email, String tanggal_lahir, String password) {
        this.id_user = id_user;
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
        this.tanggal_lahir = tanggal_lahir;
        this.password = password;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
