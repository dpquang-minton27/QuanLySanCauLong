package com.mycompany.dpquang;

public interface IQuanLyKhachHang {
    void themKhach(KhachHang khachHang);
    void xoaKhach(String maKh);
    void capNhatKhach(String maKh, KhachHang khachHang);
    KhachHang timKhach(String maKh);
    void hienThiTatCa();
}
