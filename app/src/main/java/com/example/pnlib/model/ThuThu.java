package com.example.pnlib.model;

public class ThuThu {
    private String MaTT,MatKhau,HoTen;

    public ThuThu() {
    }

    public ThuThu(String maTT, String matKhau, String hoTen) {
        MaTT = maTT;
        MatKhau = matKhau;
        HoTen = hoTen;
    }

    public String getMaTT() {
        return MaTT;
    }

    public void setMaTT(String maTT) {
        MaTT = maTT;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }
}
