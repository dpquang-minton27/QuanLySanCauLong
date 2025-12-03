package com.mycompany.dpquang;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuanLyKhachHang implements IQuanLyKhachHang {

    private final List<KhachHang> danhSachKh;

    public QuanLyKhachHang() {
        this.danhSachKh = new ArrayList<>();
    }

    @Override
    public void themKhach(KhachHang khachHang) {
        danhSachKh.add(khachHang);
    }

    @Override
    public void xoaKhach(String maKh) {
        danhSachKh.removeIf(kh -> kh.getMaKH().equals(maKh));
    }

    @Override
    public void capNhatKhach(String maKh, KhachHang khachHang) {
        for (int i = 0; i < danhSachKh.size(); i++) {
            if (danhSachKh.get(i).getMaKH().equals(maKh)) {
                danhSachKh.set(i, khachHang);
                break;
            }
        }
    }

    @Override
    public KhachHang timKhach(String maKh) {
        for (KhachHang kh : danhSachKh) {
            if (kh.getMaKH().equals(maKh)) {
                return kh;
            }
        }
        return null;
    }

    @Override
    public void hienThiTatCa() {
        for (KhachHang kh : danhSachKh) {
            System.out.println(kh);
        }
    }

    public void readData(String fileName) {
        danhSachKh.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 5) {
                    KhachHang kh = new KhachHang(
                            parts[0], parts[1], parts[2], parts[3], parts[4]
                    );
                    danhSachKh.add(kh);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeData(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (KhachHang kh : danhSachKh) {
                bw.write(kh.getMaKH() + ";" +
                        kh.getHoTen() + ";" +
                        kh.getSoDienThoai() + ";" +
                        kh.getEmail() + ";" +
                        kh.getDiaChi());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<KhachHang> getDanhSachKh() {
        return danhSachKh;
    }
}
