package com.mycompany.dpquang;

public interface IQuanLySan {
    void themSan(SanCauLong san);
    void xoaSan(String maSan);
    void capNhatSan(String maSan, SanCauLong san);
    SanCauLong timSan(String maSan);
    void hienThiTatCa();
}
