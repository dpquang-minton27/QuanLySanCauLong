package com.mycompany.dpquang;

import java.util.Date;

public interface IDatSan {
    boolean kiemTraThoiGianHopLe(Date start, Date end);
    double tinhTongTienKhach(String maKh);
}
