package com.jerem.fragments2;

public class User {
    boolean hienthi;
    int hinhanh;
    double dtb;
    String masv,hoten,lop;

    public boolean isHienthi() {
        return hienthi;
    }

    public void setHienthi(boolean hienthi) {
        this.hienthi = hienthi;
    }

    public User() {
    }

    public User(int hinhanh, double dtb, String masv, String hoten, String lop,boolean hienthi) {
        this.hinhanh = hinhanh;
        this.dtb = dtb;
        this.masv = masv;
        this.hoten = hoten;
        this.lop = lop;
        this.hienthi=hienthi;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }

    public double getDtb() {
        return dtb;
    }

    public void setDtb(double dtb) {
        this.dtb = dtb;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
}
