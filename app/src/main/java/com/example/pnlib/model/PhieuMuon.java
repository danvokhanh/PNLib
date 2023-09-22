package com.example.pnlib.model;

public class PhieuMuon {
    private int MaPM,MaTV;
    private String MaTT;
    private int MaSach;
    private String Ngay;
    private int TienThue,TraSach;

    public PhieuMuon() {
    }

    public PhieuMuon(int maPM, int maTV, String maTT, int maSach, String ngay, int tienThue, int traSach) {
        MaPM = maPM;
        MaTV = maTV;
        MaTT = maTT;
        MaSach = maSach;
        Ngay = ngay;
        TienThue = tienThue;
        TraSach = traSach;
    }

    public int getMaPM() {
        return MaPM;
    }

    public void setMaPM(int maPM) {
        MaPM = maPM;
    }

    public int getMaTV() {
        return MaTV;
    }

    public void setMaTV(int maTV) {
        MaTV = maTV;
    }

    public String getMaTT() {
        return MaTT;
    }

    public void setMaTT(String maTT) {
        MaTT = maTT;
    }

    public int getMaSach() {
        return MaSach;
    }

    public void setMaSach(int maSach) {
        MaSach = maSach;
    }

    public String getNgay() {
        return Ngay;
    }

    public void setNgay(String ngay) {
        Ngay = ngay;
    }

    public int getTienThue() {
        return TienThue;
    }

    public void setTienThue(int tienThue) {
        TienThue = tienThue;
    }

    public int getTraSach() {
        return TraSach;
    }

    public void setTraSach(int traSach) {
        TraSach = traSach;
    }
}
