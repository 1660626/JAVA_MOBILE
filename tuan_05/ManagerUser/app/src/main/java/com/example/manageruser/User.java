package com.example.manageruser;

public class User {
    boolean hienthi;
    int HinhAnh;
    double DTB;
    String MSSV, HoTen, Lop;

    public User() {
    }

    public User(boolean hienthi, int hinhAnh, double dtb, String MSSV, String hoTen, String lop) {
        this.hienthi = hienthi;
        HinhAnh = hinhAnh;
        this.DTB = dtb;
        this.MSSV = MSSV;
        HoTen = hoTen;
        Lop = lop;
    }

    public boolean isHienthi() {
        return hienthi;
    }

    public void setHienthi(boolean hienthi) {
        this.hienthi = hienthi;
    }

    public int getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        HinhAnh = hinhAnh;
    }

    public double getDTB() {
        return DTB;
    }

    public void setDTB(double DTB) {
        this.DTB = DTB;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String lop) {
        Lop = lop;
    }
}
