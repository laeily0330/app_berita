package com.example.nurporek.app_berita.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Lely on 01/28/2018.
 */

public class Komentar {
    @SerializedName("id_komentar")
    @Expose
    private int idKomentar;
    @SerializedName("id_user")
    @Expose
    private int idUser;
    @SerializedName("id_isi")
    @Expose
    private int idIsi;
    @SerializedName("komentar")
    @Expose
    private String komentar;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("nama")
    @Expose
    private String nama;

    public Komentar(int idUser, int idIsi, String komentar, String tanggal) {
        this.idUser = idUser;
        this.idIsi = idIsi;
        this.komentar = komentar;
        this.tanggal = tanggal;
    }

    public int getIdKomentar() {
        return idKomentar;
    }

    public void setIdKomentar(int idKomentar) {
        this.idKomentar = idKomentar;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdIsi() {
        return idIsi;
    }

    public void setIdIsi(int idIsi) {
        this.idIsi = idIsi;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Komentar(int idKomentar, int idUser, int idIsi, String komentar, String tanggal, String nama) {
        this.idKomentar = idKomentar;
        this.idUser = idUser;
        this.idIsi = idIsi;
        this.komentar = komentar;
        this.tanggal = tanggal;
        this.nama = nama;
    }
}
