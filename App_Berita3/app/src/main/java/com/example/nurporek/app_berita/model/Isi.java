package com.example.nurporek.app_berita.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Lely on 01/15/2018.
 */

public class Isi {

    @SerializedName("id_isi")
    @Expose
    private String idIsi;
    @SerializedName("id_reporter")
    @Expose
    private String idReporter;
    @SerializedName("id_kategori")
    @Expose
    private String idKategori;
    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("gambar")
    @Expose
    private String gambar;
    @SerializedName("isi")
    @Expose
    private String isi;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("nama_reporter")
    @Expose
    private String namaReporter;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("tanggal_lahir")
    @Expose
    private String tanggalLahir;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("nama_kategori")
    @Expose
    private String namaKategori;

    public Isi(String idIsi) {
        this.idIsi = idIsi;
    }

    public Isi(String idIsi, String idReporter, String idKategori, String judul, String gambar, String isi, String tanggal, String namaReporter, String alamat, String tanggalLahir, String username, String password, String namaKategori) {
        this.idIsi = idIsi;
        this.idReporter = idReporter;
        this.idKategori = idKategori;
        this.judul = judul;
        this.gambar = gambar;
        this.isi = isi;
        this.tanggal = tanggal;
        this.namaReporter = namaReporter;
        this.alamat = alamat;
        this.tanggalLahir = tanggalLahir;
        this.username = username;
        this.password = password;
        this.namaKategori = namaKategori;
    }

    public String getIdIsi() {
        return idIsi;
    }

    public void setIdIsi(String idIsi) {
        this.idIsi = idIsi;
    }

    public String getIdReporter() {
        return idReporter;
    }

    public void setIdReporter(String idReporter) {
        this.idReporter = idReporter;
    }

    public String getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(String idKategori) {
        this.idKategori = idKategori;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getNamaReporter() {
        return namaReporter;
    }

    public void setNamaReporter(String namaReporter) {
        this.namaReporter = namaReporter;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
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

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }

}