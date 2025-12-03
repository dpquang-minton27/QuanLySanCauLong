package com.mycompany.dpquang;

public class SanCauLong {
    private String maSan;
    private String tenSan;
    private String loaiSan;
    private double donGiaGio;
    private String trangThai;

    public SanCauLong() {
    }

    public SanCauLong(String maSan, String tenSan,
                      String loaiSan, double donGiaGio,
                      String trangThai) {
        this.maSan = maSan;
        this.tenSan = tenSan;
        this.loaiSan = loaiSan;
        this.donGiaGio = donGiaGio;
        this.trangThai = trangThai;
    }

    public String getMaSan() {
        return maSan;
    }

    public void setMaSan(String maSan) {
        this.maSan = maSan;
    }

    public String getTenSan() {
        return tenSan;
    }

    public void setTenSan(String tenSan) {
        this.tenSan = tenSan;
    }

    public String getLoaiSan() {
        return loaiSan;
    }

    public void setLoaiSan(String loaiSan) {
        this.loaiSan = loaiSan;
    }

    public double getDonGiaGio() {
        return donGiaGio;
    }

    public void setDonGiaGio(double donGiaGio) {
        this.donGiaGio = donGiaGio;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "SanCauLong{" +
                "maSan='" + maSan + '\'' +
                ", tenSan='" + tenSan + '\'' +
                ", loaiSan='" + loaiSan + '\'' +
                ", donGiaGio=" + donGiaGio +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}
