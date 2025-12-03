package com.mycompany.dpquang;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuanLyDatSan implements IDatSan {

    private List<PhieuDatSan> danhSachDat;

    public QuanLyDatSan() {
        this.danhSachDat = new ArrayList<>();
    }

    public void themDat(PhieuDatSan phieuDatSan) {
        if (phieuDatSan == null) {
            System.out.println("Phieu dat khong hop le!");
            return;
        }
        // Kiem tra trung lich truoc khi them
        if (isTrungLich(phieuDatSan, null)) {
            System.out.println("Lich dat bi trung voi phieu khac! Khong the them.");
            return;
        }
        danhSachDat.add(phieuDatSan);
    }

    public void xoaDat(String maDat) {
        danhSachDat.removeIf(p -> p.getMaDat().equals(maDat));
    }

    public void capNhatDat(String maDat, PhieuDatSan phieuDatSan) {
        if (phieuDatSan == null) {
            System.out.println("Phieu dat khong hop le, khong cap nhat.");
            return;
        }
        // Kiem tra trung lich, bo qua phieu co maDat dang cap nhat
        if (isTrungLich(phieuDatSan, maDat)) {
            System.out.println("Lich dat moi bi trung voi phieu khac! Khong the cap nhat.");
            return;
        }
        for (int i = 0; i < danhSachDat.size(); i++) {
            if (danhSachDat.get(i).getMaDat().equals(maDat)) {
                danhSachDat.set(i, phieuDatSan);
                return;
            }
        }
    }

    public PhieuDatSan timDat(String maDat) {
        for (PhieuDatSan p : danhSachDat) {
            if (p.getMaDat().equals(maDat)) {
                return p;
            }
        }
        return null;
    }

    public List<PhieuDatSan> timDatTheoKhach(String maKh) {
        List<PhieuDatSan> result = new ArrayList<>();
        for (PhieuDatSan p : danhSachDat) {
            if (p.getMaKH().equals(maKh)) {
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public boolean kiemTraThoiGianHopLe(Date start, Date end) {
        if (start == null || end == null) return false;
        Date now = new Date();
        // start phai sau hien tai va truoc end
        if (!start.after(now)) {
            return false;
        }
        if (!start.before(end)) {
            return false;
        }
        return true;
    }

    @Override
    public double tinhTongTienKhach(String maKh) {
        double sum = 0;
        for (PhieuDatSan p : danhSachDat) {
            if (p.getMaKH().equals(maKh)) {
                sum += p.tinhTienSan();
            }
        }
        return sum;
    }

    public void readData(String fileName) {
        danhSachDat.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 7) {
                    String maDat = parts[0];
                    String maKH = parts[1];
                    String maSan = parts[2];
                    Date start = new Date(Long.parseLong(parts[3]));
                    Date end = new Date(Long.parseLong(parts[4]));
                    double soGio = Double.parseDouble(parts[5]);
                    double donGia = Double.parseDouble(parts[6]);

                    PhieuDatSan p = new PhieuDatSan(
                            maDat, maKH, maSan, start, end, soGio, donGia
                    );
                    danhSachDat.add(p);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeData(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (PhieuDatSan p : danhSachDat) {
                bw.write(p.getMaDat() + ";" +
                        p.getMaKH() + ";" +
                        p.getMaSan() + ";" +
                        p.getThoiGianBatDau().getTime() + ";" +
                        p.getThoiGianKetThuc().getTime() + ";" +
                        p.getSoGio() + ";" +
                        p.getDonGiaGio());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void hienThiTatCa() {
        for (PhieuDatSan p : danhSachDat) {
            System.out.println(p);
        }
    }

    public List<PhieuDatSan> getDanhSachDat() {
        return danhSachDat;
    }

    /**
     * Kiem tra trung lich dat cho cung maSan.
     * Neu maDatBoQua != null thi bo qua phieu co maDat do (phuc vu cap nhat).
     */
    private boolean isTrungLich(PhieuDatSan phieuMoi, String maDatBoQua) {
        for (PhieuDatSan p : danhSachDat) {
            if (maDatBoQua != null && p.getMaDat().equals(maDatBoQua)) {
                continue;
            }
            if (!p.getMaSan().equals(phieuMoi.getMaSan())) {
                continue;
            }
            Date start1 = phieuMoi.getThoiGianBatDau();
            Date end1 = phieuMoi.getThoiGianKetThuc();
            Date start2 = p.getThoiGianBatDau();
            Date end2 = p.getThoiGianKetThuc();

            // Khoang thoi gian giao nhau neu start1 < end2 va end1 > start2
            if (start1.before(end2) && end1.after(start2)) {
                return true;
            }
        }
        return false;
    }
}
