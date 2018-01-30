package com.example.nurporek.app_berita.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Lely on 01/15/2018.
 */

public class Reporter {
    @SerializedName("id_reporter")
    @Expose
    private int id_reporter;

    @SerializedName("nama_reporter")
    @Expose
    private String nama_reporter;

    @SerializedName("alamat")
    @Expose
    private String alamat;

    @SerializedName("id_request")
    @Expose
    private int id_request;

    @SerializedName("tanggal_lahir")
    @Expose
    private Date tanggal_lahir;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("password")
    @Expose
    private String password;

    public Reporter(int id_reporter, String nama_reporter, String alamat, int id_request, Date tanggal_lahir, String username, String password) {
        this.id_reporter = id_reporter;
        this.nama_reporter = nama_reporter;
        this.alamat = alamat;
        this.id_request = id_request;
        this.tanggal_lahir = tanggal_lahir;
        this.username = username;
        this.password = password;
    }

    public int getId_reporter() {
        return id_reporter;
    }

    public void setId_reporter(int id_reporter) {
        this.id_reporter = id_reporter;
    }

    public String getNama_reporter() {
        return nama_reporter;
    }

    public void setNama_reporter(String nama_reporter) {
        this.nama_reporter = nama_reporter;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getId_request() {
        return id_request;
    }

    public void setId_request(int id_request) {
        this.id_request = id_request;
    }

    public Date getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(Date tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
