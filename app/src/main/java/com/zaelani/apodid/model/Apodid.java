package com.zaelani.apodid.model;

public class Apodid {
    private String title;
    private String date;
    private String detail;
    private String kredit_konten;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getKredit_konten() {
        return kredit_konten;
    }

    public void setKredit_konten(String kredit_konten) {
        this.kredit_konten = kredit_konten;
    }

    public String getKredit_foto() {
        return kredit_foto;
    }

    public void setKredit_foto(String kredit_foto) {
        this.kredit_foto = kredit_foto;
    }

    public String getAlih_bahasa() {
        return alih_bahasa;
    }

    public void setAlih_bahasa(String alih_bahasa) {
        this.alih_bahasa = alih_bahasa;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    private String kredit_foto;
    private String alih_bahasa;
    private int photo;

}
