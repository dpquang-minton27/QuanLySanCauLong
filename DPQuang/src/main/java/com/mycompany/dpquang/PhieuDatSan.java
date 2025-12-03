package com.mycompany.dpquang;

import java.util.Date;

public class PhieuDatSan {
    private String maDat;
    private String maKH;
    private String maSan;
    private Date thoiGianBatDau;
    private Date thoiGianKetThuc;
    private double soGio;
    private double donGiaGio;

    public PhieuDatSan() {
    }

    public PhieuDatSan(String maDat, String maKH, String maSan,
                       Date thoiGianBatDau, Date thoiGianKetThuc,
                       double soGio, double donGiaGio) {
        this.maDat = maDat;
        this.maKH = maKH;
        this.maSan = maSan;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.soGio = soGio;
        this.donGiaGio = donGiaGio;
    }

    public String getMaDat() {
        return maDat;
    }

    public void setMaDat(String maDat) {
        this.maDat = maDat;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaSan() {
        return maSan;
    }

    public void setMaSan(String maSan) {
        this.maSan = maSan;
    }

    public Date getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Date thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Date getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Date thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public double getSoGio() {
        return soGio;
    }

    public void setSoGio(double soGio) {
        this.soGio = soGio;
    }

    public double getDonGiaGio() {
        return donGiaGio;
    }

    public void setDonGiaGio(double donGiaGio) {
        this.donGiaGio = donGiaGio;
    }

    public double tinhTienSan() {
        return soGio * donGiaGio;
    }

    @Override
    public String toString() {
        return "PhieuDatSan{" +
                "maDat='" + maDat + '\'' +
                ", maKH='" + maKH + '\'' +
                ", maSan='" + maSan + '\'' +
                ", thoiGianBatDau=" + thoiGianBatDau +
                ", thoiGianKetThuc=" + thoiGianKetThuc +
                ", soGio=" + soGio +
                ", donGiaGio=" + donGiaGio +
                '}';
    }
}
