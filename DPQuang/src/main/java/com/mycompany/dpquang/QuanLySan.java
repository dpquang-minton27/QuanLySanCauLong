package com.mycompany.dpquang;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuanLySan implements IQuanLySan {

    private List<SanCauLong> danhSachSan;

    public QuanLySan() {
        this.danhSachSan = new ArrayList<>();
    }

    @Override
    public void themSan(SanCauLong san) {
        danhSachSan.add(san);
    }

    @Override
    public void xoaSan(String maSan) {
        danhSachSan.removeIf(s -> s.getMaSan().equals(maSan));
    }

    @Override
    public void capNhatSan(String maSan, SanCauLong san) {
        for (int i = 0; i < danhSachSan.size(); i++) {
            if (danhSachSan.get(i).getMaSan().equals(maSan)) {
                danhSachSan.set(i, san);
                break;
            }
        }
    }

    @Override
    public SanCauLong timSan(String maSan) {
        for (SanCauLong san : danhSachSan) {
            if (san.getMaSan().equals(maSan)) {
                return san;
            }
        }
        return null;
    }

    @Override
    public void hienThiTatCa() {
        for (SanCauLong san : danhSachSan) {
            System.out.println(san);
        }
    }

    public void readData(String fileName) {
        danhSachSan.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length >= 5) {
                    SanCauLong san = new SanCauLong(
                            parts[0],
                            parts[1],
                            parts[2],
                            Double.parseDouble(parts[3]),
                            parts[4]
                    );
                    danhSachSan.add(san);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeData(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (SanCauLong san : danhSachSan) {
                bw.write(san.getMaSan() + ";" +
                        san.getTenSan() + ";" +
                        san.getLoaiSan() + ";" +
                        san.getDonGiaGio() + ";" +
                        san.getTrangThai());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<SanCauLong> getDanhSachSan() {
        return danhSachSan;
    }
}
