package com.mycompany.dpquang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final QuanLyKhachHang qlKhachHang = new QuanLyKhachHang();
    private static final QuanLySan qlSan = new QuanLySan();
    private static final QuanLyDatSan qlDatSan = new QuanLyDatSan();
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    static {
        sdf.setLenient(false);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("===== QUAN LY SAN CAU LONG =====");
            System.out.println("1. Quan ly khach hang");
            System.out.println("2. Quan ly san");
            System.out.println("3. Quan ly dat san");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");

            int choice = readInt();
            switch (choice) {
                case 1:
                    menuKhachHang();
                    break;
                case 2:
                    menuSan();
                    break;
                case 3:
                    menuDatSan();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    // -------- MENU KHÁCH HÀNG --------
    private static void menuKhachHang() {
        while (true) {
            System.out.println("\n--- QUAN LY KHACH HANG ---");
            System.out.println("1. Them khach hang");
            System.out.println("2. Xoa khach hang");
            System.out.println("3. Cap nhat khach hang");
            System.out.println("4. Tim khach hang theo ma");
            System.out.println("5. Hien thi tat ca khach hang");
            System.out.println("6. Doc danh sach tu file");
            System.out.println("7. Ghi danh sach ra file");
            System.out.println("0. Quay lai menu chinh");
            System.out.print("Chon: ");

            int choice = readInt();
            switch (choice) {
                case 1:
                    KhachHang kh = nhapKhachHang();
                    qlKhachHang.themKhach(kh);
                    break;
                case 2:
                    System.out.print("Nhap ma khach can xoa: ");
                    String maXoa = sc.nextLine();
                    qlKhachHang.xoaKhach(maXoa);
                    break;
                case 3:
                    System.out.print("Nhap ma khach can cap nhat: ");
                    String maSua = sc.nextLine();
                    KhachHang khMoi = nhapKhachHang();
                    qlKhachHang.capNhatKhach(maSua, khMoi);
                    break;
                case 4:
                    System.out.print("Nhap ma khach can tim: ");
                    String maTim = sc.nextLine();
                    KhachHang kq = qlKhachHang.timKhach(maTim);
                    System.out.println(kq != null ? kq : "Khong tim thay!");
                    break;
                case 5:
                    qlKhachHang.hienThiTatCa();
                    break;
                case 6:
                    System.out.print("Nhap ten file doc (vd: khachhang.txt): ");
                    qlKhachHang.readData(sc.nextLine());
                    break;
                case 7:
                    System.out.print("Nhap ten file ghi (vd: khachhang.txt): ");
                    qlKhachHang.writeData(sc.nextLine());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    // -------- MENU SÂN --------
    private static void menuSan() {
        while (true) {
            System.out.println("\n--- QUAN LY SAN ---");
            System.out.println("1. Them san");
            System.out.println("2. Xoa san");
            System.out.println("3. Cap nhat san");
            System.out.println("4. Tim san theo ma");
            System.out.println("5. Hien thi tat ca san");
            System.out.println("6. Doc danh sach tu file");
            System.out.println("7. Ghi danh sach ra file");
            System.out.println("0. Quay lai menu chinh");
            System.out.print("Chon: ");

            int choice = readInt();
            switch (choice) {
                case 1:
                    SanCauLong san = nhapSan();
                    qlSan.themSan(san);
                    break;
                case 2:
                    System.out.print("Nhap ma san can xoa: ");
                    String maXoa = sc.nextLine();
                    qlSan.xoaSan(maXoa);
                    break;
                case 3:
                    System.out.print("Nhap ma san can cap nhat: ");
                    String maSua = sc.nextLine();
                    SanCauLong sanMoi = nhapSan();
                    qlSan.capNhatSan(maSua, sanMoi);
                    break;
                case 4:
                    System.out.print("Nhap ma san can tim: ");
                    String maTim = sc.nextLine();
                    SanCauLong kq = qlSan.timSan(maTim);
                    System.out.println(kq != null ? kq : "Khong tim thay!");
                    break;
                case 5:
                    qlSan.hienThiTatCa();
                    break;
                case 6:
                    System.out.print("Nhap ten file doc (vd: san.txt): ");
                    qlSan.readData(sc.nextLine());
                    break;
                case 7:
                    System.out.print("Nhap ten file ghi (vd: san.txt): ");
                    qlSan.writeData(sc.nextLine());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    // -------- MENU ĐẶT SÂN --------
    private static void menuDatSan() {
        while (true) {
            System.out.println("\n--- QUAN LY DAT SAN ---");
            System.out.println("1. Them phieu dat san");
            System.out.println("2. Xoa phieu dat san");
            System.out.println("3. Cap nhat phieu dat san");
            System.out.println("4. Tim phieu theo ma dat");
            System.out.println("5. Tim phieu theo ma khach");
            System.out.println("6. Hien thi tat ca phieu");
            System.out.println("7. Tinh tong tien theo ma khach");
            System.out.println("8. Doc danh sach tu file");
            System.out.println("9. Ghi danh sach ra file");
            System.out.println("0. Quay lai menu chinh");
            System.out.print("Chon: ");

            int choice = readInt();
            switch (choice) {
                case 1:
                    themPhieuDatSan();
                    break;
                case 2:
                    System.out.print("Nhap ma dat can xoa: ");
                    String maXoa = sc.nextLine();
                    qlDatSan.xoaDat(maXoa);
                    break;
                case 3:
                    System.out.print("Nhap ma dat can cap nhat: ");
                    String maSua = sc.nextLine();
                    PhieuDatSan phieuMoi = nhapPhieuDatSan(maSua);
                    qlDatSan.capNhatDat(maSua, phieuMoi);
                    break;
                case 4:
                    System.out.print("Nhap ma dat can tim: ");
                    String maTimDat = sc.nextLine();
                    PhieuDatSan p = qlDatSan.timDat(maTimDat);
                    System.out.println(p != null ? p : "Khong tim thay!");
                    break;
                case 5:
                    System.out.print("Nhap ma khach: ");
                    String maKh = sc.nextLine();
                    List<PhieuDatSan> list = qlDatSan.timDatTheoKhach(maKh);
                    if (list.isEmpty()) {
                        System.out.println("Khong co phieu nao!");
                    } else {
                        list.forEach(System.out::println);
                    }
                    break;
                case 6:
                    qlDatSan.hienThiTatCa();
                    break;
                case 7:
                    System.out.print("Nhap ma khach: ");
                    String maKhTien = sc.nextLine();
                    double tong = qlDatSan.tinhTongTienKhach(maKhTien);
                    System.out.println("Tong tien cua khach " + maKhTien + " = " + tong);
                    break;
                case 8:
                    System.out.print("Nhap ten file doc (vd: phieu.txt): ");
                    qlDatSan.readData(sc.nextLine());
                    break;
                case 9:
                    System.out.print("Nhap ten file ghi (vd: phieu.txt): ");
                    qlDatSan.writeData(sc.nextLine());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    // -------- HÀM NHẬP ĐỐI TƯỢNG --------
    private static KhachHang nhapKhachHang() {
        System.out.print("Nhap ma khach: ");
        String maKh = sc.nextLine();
        System.out.print("Nhap ho ten: ");
        String hoTen = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        String sdt = sc.nextLine();
        System.out.print("Nhap email: ");
        String email = sc.nextLine();
        System.out.print("Nhap dia chi: ");
        String diaChi = sc.nextLine();
        return new KhachHang(maKh, hoTen, sdt, email, diaChi);
    }

    private static SanCauLong nhapSan() {
        System.out.print("Nhap ma san: ");
        String maSan = sc.nextLine();
        System.out.print("Nhap ten san: ");
        String tenSan = sc.nextLine();
        System.out.print("Nhap loai san: ");
        String loaiSan = sc.nextLine();
        System.out.print("Nhap don gia gio: ");
        double donGia = readDouble();
        System.out.print("Nhap trang thai (TRONG/BAN): ");
        String trangThai = sc.nextLine();
        return new SanCauLong(maSan, tenSan, loaiSan, donGia, trangThai);
    }

    private static void themPhieuDatSan() {
        System.out.print("Nhap ma dat: ");
        String maDat = sc.nextLine();
        PhieuDatSan p = nhapPhieuDatSan(maDat);
        if (p != null) {
            qlDatSan.themDat(p);
        }
    }

    private static PhieuDatSan nhapPhieuDatSan(String maDat) {
        System.out.print("Nhap ma khach: ");
        String maKh = sc.nextLine();
        KhachHang kh = qlKhachHang.timKhach(maKh);
        if (kh == null) {
            System.out.println("Khach hang khong ton tai! Hay them khach truoc.");
            return null;
        }

        System.out.print("Nhap ma san: ");
        String maSan = sc.nextLine();
        SanCauLong san = qlSan.timSan(maSan);
        if (san == null) {
            System.out.println("San khong ton tai! Hay them san truoc.");
            return null;
        }

        Date start = nhapNgayGio("Nhap thoi gian bat dau (dd/MM/yyyy HH:mm): ");
        Date end = nhapNgayGio("Nhap thoi gian ket thuc (dd/MM/yyyy HH:mm): ");

        if (!qlDatSan.kiemTraThoiGianHopLe(start, end)) {
            System.out.println("Thoi gian khong hop le!");
            return null;
        }

        double soGio = tinhSoGio(start, end);
        double donGia = san.getDonGiaGio();

        return new PhieuDatSan(maDat, maKh, maSan, start, end, soGio, donGia);
    }

    // -------- HÀM HỖ TRỢ NHẬP LIỆU --------
    private static Date nhapNgayGio(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();
            try {
                return sdf.parse(input);
            } catch (ParseException e) {
                System.out.println("Sai dinh dang! Vui long nhap lai (dd/MM/yyyy HH:mm).");
            }
        }
    }

    private static double tinhSoGio(Date start, Date end) {
        long diffMillis = end.getTime() - start.getTime();
        return diffMillis / (1000.0 * 60 * 60);
    }

    private static int readInt() {
        while (true) {
            try {
                String line = sc.nextLine();
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.print("Nhap so nguyen: ");
            }
        }
    }

    private static double readDouble() {
        while (true) {
            try {
                String line = sc.nextLine();
                return Double.parseDouble(line.trim());
            } catch (NumberFormatException e) {
                System.out.print("Nhap so thuc: ");
            }
        }
    }
}
