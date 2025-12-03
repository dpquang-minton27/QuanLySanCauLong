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

    // ================== MENU KHÁCH HÀNG ==================
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
                case 1: {
                    // Nhap va kiem tra trung maKH khi them moi
                    while (true) {
                        KhachHang kh = nhapKhachHang();
                        if (qlKhachHang.timKhach(kh.getMaKH()) != null) {
                            System.out.println("Ma khach da ton tai! Vui long nhap ma khac.");
                        } else {
                            qlKhachHang.themKhach(kh);
                            System.out.println("Da them khach hang thanh cong.");
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.print("Nhap ma khach can xoa: ");
                    String maXoa = sc.nextLine();

                    KhachHang khCanXoa = qlKhachHang.timKhach(maXoa);
                    if (khCanXoa == null) {
                        System.out.println("Khong tim thay!");
                    } else {
                        qlKhachHang.xoaKhach(maXoa);
                        System.out.println("Da xoa khach hang co ma: " + maXoa);
                    }
                    break;
                }
                case 3: {
    System.out.print("Nhap ma khach can cap nhat: ");
    String maSua = sc.nextLine().trim();

    KhachHang khHienTai = qlKhachHang.timKhach(maSua);
    if (khHienTai == null) {
        System.out.println("Khong tim thay!");
    } else {
        System.out.println("Thong tin hien tai: " + khHienTai);

        while (true) {
            System.out.println("\n--- CHON THONG TIN CAN SUA ---");
            System.out.println("1. Sua ho ten");
            System.out.println("2. Sua so dien thoai");
            System.out.println("3. Sua email");
            System.out.println("4. Sua dia chi");
            System.out.println("0. Hoan thanh cap nhat");
            System.out.print("Chon: ");

            int chSua = readInt();
            switch (chSua) {
                case 1:
                    // Su dung ham nhapHoTen() da co rang buoc
                    String hoTenMoi = nhapHoTen();
                    khHienTai.setHoTen(hoTenMoi);
                    System.out.println("Da cap nhat ho ten.");
                    break;
                case 2:
                    String sdtMoi = nhapSoDienThoai();
                    khHienTai.setSoDienThoai(sdtMoi);
                    System.out.println("Da cap nhat so dien thoai.");
                    break;
                case 3:
                    String emailMoi = nhapEmailGmail();
                    khHienTai.setEmail(emailMoi);
                    System.out.println("Da cap nhat email.");
                    break;
                case 4:
                    String diaChiMoi = nhapDiaChi();
                    khHienTai.setDiaChi(diaChiMoi);
                    System.out.println("Da cap nhat dia chi.");
                    break;
                case 0:
                    System.out.println("Da hoan thanh cap nhat khach hang co ma: " + maSua);
                    System.out.println("Thong tin moi: " + khHienTai);
                    return; // thoat muc 3, quay lai menu khach hang
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }
    break;
}

                case 4: {
                    System.out.print("Nhap ma khach can tim: ");
                    String maTim = sc.nextLine();
                    KhachHang kq = qlKhachHang.timKhach(maTim);
                    System.out.println(kq != null ? kq : "Khong tim thay!");
                    break;
                }
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

    // ================== MENU SÂN ==================
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
                case 1: {
                    // Nhap va kiem tra trung maSan khi them moi
                    while (true) {
                        SanCauLong san = nhapSan();
                        if (qlSan.timSan(san.getMaSan()) != null) {
                            System.out.println("Ma san da ton tai! Vui long nhap lai.");
                        } else {
                            qlSan.themSan(san);
                            System.out.println("Da them san thanh cong.");
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.print("Nhap ma san can xoa: ");
                    String maXoa = sc.nextLine();

                    SanCauLong sanCanXoa = qlSan.timSan(maXoa);
                    if (sanCanXoa == null) {
                        System.out.println("Khong tim thay!");
                    } else {
                        qlSan.xoaSan(maXoa);
                        System.out.println("Da xoa san co ma: " + maXoa);
                    }
                    break;
                }
                case 3: {
    System.out.print("Nhap ma san can cap nhat: ");
    String maSua = sc.nextLine().trim();

    SanCauLong sanHienTai = qlSan.timSan(maSua);
    if (sanHienTai == null) {
        System.out.println("Khong tim thay!");
    } else {
        while (true) {
            System.out.println("\nThong tin hien tai: " + sanHienTai);
            System.out.println("--- CHON THONG TIN CAN SUA ---");
            System.out.println("1. Sua ten san");
            System.out.println("2. Sua loai san");
            System.out.println("3. Sua don gia gio");
            System.out.println("4. Sua trang thai");
            System.out.println("0. Hoan thanh cap nhat");
            System.out.print("Chon: ");

            int chSua = readInt();
            switch (chSua) {
                case 1: {
                    String tenMoi = nhapKhongRong("Nhap ten san moi: ");
                    sanHienTai.setTenSan(tenMoi);
                    System.out.println("Da cap nhat ten san.");
                    break;
                }
                case 2: {
                    String loaiMoi = nhapKhongRong("Nhap loai san moi: ");
                    sanHienTai.setLoaiSan(loaiMoi);
                    System.out.println("Da cap nhat loai san.");
                    break;
                }
                case 3: {
                    double donGiaMoi;
                    while (true) {
                        System.out.print("Nhap don gia gio moi: ");
                        donGiaMoi = readDouble();
                        if (donGiaMoi > 0) break;
                        System.out.println("Don gia phai > 0!");
                    }
                    sanHienTai.setDonGiaGio(donGiaMoi);
                    System.out.println("Da cap nhat don gia gio.");
                    break;
                }
                case 4: {
                    String ttMoi = nhapTrangThaiSan();
                    sanHienTai.setTrangThai(ttMoi);
                    System.out.println("Da cap nhat trang thai san.");
                    break;
                }
                case 0:
                    System.out.println("Da hoan thanh cap nhat san co ma: " + maSua);
                    System.out.println("Thong tin moi: " + sanHienTai);
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
            if (chSua == 0) break;
        }
    }
    break;
}

                case 4: {
                    System.out.print("Nhap ma san can tim: ");
                    String maTim = sc.nextLine();
                    SanCauLong kq = qlSan.timSan(maTim);
                    System.out.println(kq != null ? kq : "Khong tim thay!");
                    break;
                }
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

    // ================== MENU ĐẶT SÂN ==================
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

                case 2: {
                    System.out.print("Nhap ma dat can xoa: ");
                    String maXoa = sc.nextLine();

                    PhieuDatSan phieuCanXoa = qlDatSan.timDat(maXoa);
                    if (phieuCanXoa == null) {
                        System.out.println("Khong tim thay!");
                    } else {
                        qlDatSan.xoaDat(maXoa);
                        System.out.println("Da xoa phieu dat co ma: " + maXoa);
                    }
                    break;
                }

                case 3: {
    System.out.print("Nhap ma dat can cap nhat: ");
    String maSua = sc.nextLine().trim();

    PhieuDatSan phieuHienTai = qlDatSan.timDat(maSua);
    if (phieuHienTai == null) {
        System.out.println("Khong tim thay!");
    } else {
        // Tao ban sao tam de chinh sua, tranh cap nhat truc tiep
        PhieuDatSan phieuMoi = new PhieuDatSan(
                phieuHienTai.getMaDat(),
                phieuHienTai.getMaKH(),
                phieuHienTai.getMaSan(),
                phieuHienTai.getThoiGianBatDau(),
                phieuHienTai.getThoiGianKetThuc(),
                phieuHienTai.getSoGio(),
                phieuHienTai.getDonGiaGio()
        );

        while (true) {
            System.out.println("\nThong tin hien tai (ban tam): " + phieuMoi);
            System.out.println("--- CHON THONG TIN CAN SUA ---");
            System.out.println("1. Sua ma khach");
            System.out.println("2. Sua ma san");
            System.out.println("3. Sua thoi gian bat dau/ket thuc");
            System.out.println("4. Sua don gia gio");
            System.out.println("0. Hoan thanh cap nhat");
            System.out.print("Chon: ");

            int chSua = readInt();
            switch (chSua) {
                case 1: {
                    System.out.print("Nhap ma khach moi: ");
                    String maKhMoi = sc.nextLine().trim();
                    KhachHang kh = qlKhachHang.timKhach(maKhMoi);
                    if (kh == null) {
                        System.out.println("Khach hang khong ton tai! Khong cap nhat.");
                    } else {
                        phieuMoi.setMaKH(maKhMoi);
                        System.out.println("Da cap nhat ma khach.");
                    }
                    break;
                }
                case 2: {
                    System.out.print("Nhap ma san moi: ");
                    String maSanMoi = sc.nextLine().trim();
                    SanCauLong san = qlSan.timSan(maSanMoi);
                    if (san == null) {
                        System.out.println("San khong ton tai! Khong cap nhat.");
                    } else {
                        phieuMoi.setMaSan(maSanMoi);
                        phieuMoi.setDonGiaGio(san.getDonGiaGio()); // cap nhat theo don gia san moi
                        System.out.println("Da cap nhat ma san va don gia gio theo san moi.");
                    }
                    break;
                }
                case 3: {
                    Date startMoi = nhapNgayGio("Nhap thoi gian bat dau moi (dd/MM/yyyy HH:mm): ");
                    Date endMoi = nhapNgayGio("Nhap thoi gian ket thuc moi (dd/MM/yyyy HH:mm): ");

                    if (!qlDatSan.kiemTraThoiGianHopLe(startMoi, endMoi)) {
                        System.out.println("Thoi gian khong hop le! (phai sau hien tai va bat dau < ket thuc)");
                    } else {
                        phieuMoi.setThoiGianBatDau(startMoi);
                        phieuMoi.setThoiGianKetThuc(endMoi);
                        phieuMoi.setSoGio(tinhSoGio(startMoi, endMoi));
                        System.out.println("Da cap nhat thoi gian va so gio.");
                    }
                    break;
                }
                case 4: {
                    double donGiaMoi;
                    while (true) {
                        System.out.print("Nhap don gia gio moi: ");
                        donGiaMoi = readDouble();
                        if (donGiaMoi > 0) break;
                        System.out.println("Don gia phai > 0!");
                    }
                    phieuMoi.setDonGiaGio(donGiaMoi);
                    System.out.println("Da cap nhat don gia gio.");
                    break;
                }
                case 0: {
                    // Kiem tra lai thoi gian truoc khi luu
                    if (!qlDatSan.kiemTraThoiGianHopLe(
                            phieuMoi.getThoiGianBatDau(),
                            phieuMoi.getThoiGianKetThuc()
                    )) {
                        System.out.println("Thoi gian cua phieu khong hop le! Khong the cap nhat.");
                    } else {
                        // Thu cap nhat (co kiem tra trung lich ben trong QuanLyDatSan)
                        qlDatSan.capNhatDat(maSua, phieuMoi);
                        System.out.println("Da thu cap nhat phieu dat co ma: " + maSua);
                        System.out.println("Vui long kiem tra danh sach de xem ket qua (neu bi trung lich se khong duoc cap nhat).");
                    }
                    break;
                }
                default:
                    System.out.println("Lua chon khong hop le!");
            }
            if (chSua == 0) break;
        }
    }
    break;
}

                case 4: {
                    System.out.print("Nhap ma dat can tim: ");
                    String maTimDat = sc.nextLine();
                    PhieuDatSan p = qlDatSan.timDat(maTimDat);
                    System.out.println(p != null ? p : "Khong tim thay!");
                    break;
                }

                case 5: {
                    System.out.print("Nhap ma khach: ");
                    String maKh = sc.nextLine();
                    List<PhieuDatSan> list = qlDatSan.timDatTheoKhach(maKh);
                    if (list.isEmpty()) {
                        System.out.println("Khong co phieu nao!");
                    } else {
                        list.forEach(System.out::println);
                    }
                    break;
                }

                case 6:
                    qlDatSan.hienThiTatCa();
                    break;

                case 7: {
                    System.out.print("Nhap ma khach: ");
                    String maKhTien = sc.nextLine();
                    double tong = qlDatSan.tinhTongTienKhach(maKhTien);
                    System.out.println("Tong tien cua khach " + maKhTien + " = " +
                    String.format("%,.0f VND", tong));
                    break;
                }

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

    // ================== HÀM NHẬP ĐỐI TƯỢNG ==================
    private static KhachHang nhapKhachHang() {
        String maKh = nhapKhongRong("Nhap ma khach: ");
        String hoTen = nhapHoTen();
        String sdt = nhapSoDienThoai();
        String email = nhapEmailGmail();
        String diaChi = nhapDiaChi();
        return new KhachHang(maKh, hoTen, sdt, email, diaChi);
    }

    private static SanCauLong nhapSan() {
        String maSan = nhapKhongRong("Nhap ma san: ");
        String tenSan = nhapKhongRong("Nhap ten san: ");
        String loaiSan = nhapKhongRong("Nhap loai san: ");

        double donGia;
        while (true) {
            System.out.print("Nhap don gia gio: ");
            donGia = readDouble();
            if (donGia > 0) break;
            System.out.println("Don gia phai > 0!");
        }

        String trangThai = nhapTrangThaiSan();
        return new SanCauLong(maSan, tenSan, loaiSan, donGia, trangThai);
    }

    private static void themPhieuDatSan() {
        // maDat khong rong va khong trung
        String maDat;
        while (true) {
            maDat = nhapKhongRong("Nhap ma dat: ");
            if (qlDatSan.timDat(maDat) != null) {
                System.out.println("Ma dat da ton tai! Vui long nhap ma khac.");
            } else {
                break;
            }
        }

        PhieuDatSan p = nhapPhieuDatSan(maDat);
        if (p != null) {
            qlDatSan.themDat(p);
        }
    }

    private static PhieuDatSan nhapPhieuDatSan(String maDat) {
        System.out.print("Nhap ma khach: ");
        String maKh = sc.nextLine().trim();
        KhachHang kh = qlKhachHang.timKhach(maKh);
        if (kh == null) {
            System.out.println("Khach hang khong ton tai! Hay them khach truoc.");
            return null;
        }

        System.out.print("Nhap ma san: ");
        String maSan = sc.nextLine().trim();
        SanCauLong san = qlSan.timSan(maSan);
        if (san == null) {
            System.out.println("San khong ton tai! Hay them san truoc.");
            return null;
        }

        Date start = nhapNgayGio("Nhap thoi gian bat dau (dd/MM/yyyy HH:mm): ");
        Date end = nhapNgayGio("Nhap thoi gian ket thuc (dd/MM/yyyy HH:mm): ");

        if (!qlDatSan.kiemTraThoiGianHopLe(start, end)) {
            System.out.println("Thoi gian khong hop le! (phai sau hien tai va truoc thoi gian ket thuc)");
            return null;
        }

        double soGio = tinhSoGio(start, end);
        double donGia = san.getDonGiaGio();

        return new PhieuDatSan(maDat, maKh, maSan, start, end, soGio, donGia);
    }

    // ================== HÀM HỖ TRỢ NHẬP & KIỂM TRA ==================
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

    // ================== HÀM HỖ TRỢ RÀNG BUỘC CHUỖI ==================
    /** Nhap chuoi khong rong (khong toan space). */
    private static String nhapKhongRong(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Khong duoc de trong! Vui long nhap lai.");
        }
    }

    /** Nhap ho ten: khong rong, chi chu va khoang trang. */
    private static String nhapHoTen() {
        while (true) {
            System.out.print("Nhap ho ten: ");
            String hoTen = sc.nextLine().trim();
            if (hoTen.isEmpty()) {
                System.out.println("Ho ten khong duoc de trong!");
                continue;
            }
            // \\p{L} la tat ca chu cai Unicode (cho phep tieng Viet)
            if (!hoTen.matches("^[\\p{L} ]+$")) {
                System.out.println("Ho ten chi duoc chua chu cai va khoang trang!");
                continue;
            }
            return hoTen;
        }
    }

    /** Nhap dia chi: khong rong, toi thieu 5 ky tu. */
    private static String nhapDiaChi() {
        while (true) {
            System.out.print("Nhap dia chi: ");
            String diaChi = sc.nextLine().trim();
            if (diaChi.isEmpty()) {
                System.out.println("Dia chi khong duoc de trong!");
                continue;
            }
            if (diaChi.length() < 5) {
                System.out.println("Dia chi qua ngan! Vui long nhap chi tiet hon.");
                continue;
            }
            return diaChi;
        }
    }

    /** Nhap so dien thoai: chi chua so, do dai 9–11 ky tu. */
    private static String nhapSoDienThoai() {
        while (true) {
            System.out.print("Nhap so dien thoai: ");
            String sdt = sc.nextLine().trim();

            if (!sdt.matches("\\d{9,11}")) {
                System.out.println("So dien thoai chi duoc chua so va do dai 9–11 chu so!");
                continue;
            }
            return sdt;
        }
    }

    /** Nhap email: bat buoc co dinh dang ...@gmail.com */
    private static String nhapEmailGmail() {
        while (true) {
            System.out.print("Nhap email: ");
            String email = sc.nextLine().trim();

            if (!email.matches("^[\\w.+-]+@gmail\\.com$")) {
                System.out.println("Email khong hop le! Vui long nhap lai theo dang ten@gmail.com");
                continue;
            }
            return email;
        }
    }

    /** Nhap trang thai san: chi cho phep TRONG hoac BAN. */
    private static String nhapTrangThaiSan() {
        while (true) {
            System.out.print("Nhap trang thai (TRONG/DA DAT): ");
            String tt = sc.nextLine().trim().toUpperCase();
            if (tt.equals("TRONG") || tt.equals("DA DAT")) {
                return tt;
            }
            System.out.println("Trang thai chi duoc la TRONG hoac DA DAT!");
        }
    }
}
