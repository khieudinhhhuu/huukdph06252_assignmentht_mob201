package com.khieuthichien.hotrohoctap.model;

public class Sinhvien {
    private int imganh;
    private String masv;
    private String tensv;

    public Sinhvien(int imganh, String masv, String tensv) {
        this.imganh = imganh;
        this.masv = masv;
        this.tensv = tensv;
    }

    public Sinhvien(String masv, String tensv) {
        this.masv = masv;
        this.tensv = tensv;
    }

    public Sinhvien() {
    }

    public int getImganh() {
        return imganh;
    }

    public void setImganh(int imganh) {
        this.imganh = imganh;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getTensv() {
        return tensv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }
}
