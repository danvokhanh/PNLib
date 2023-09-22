package com.example.pnlib.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    static final String dbName = "PhuongNamLib";
    static final int dbVersion = 1;

    public DbHelper(@Nullable Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tạo bảng thủ thư
        String tb_ThuThu = "create table ThuThu(" +
                "MaTT text primary key not null," +
                "HoTen text not null," +
                "MatKhau text not null)";
        db.execSQL(tb_ThuThu);

        // Tạo bảng thành viên
        String tb_ThanhVien = "create table ThanhVien(" +
                "MaTV integer primary key autoincrement," +
                "HoTen text not null," +
                "NamSinh text not null)";
        db.execSQL(tb_ThanhVien);

        // Tạo bảng loại sách
        String tb_LoaiSach = "create table LoaiSach(" +
                "MaLoai integer primary key autoincrement," +
                "HoTen text not null)";
        db.execSQL(tb_LoaiSach);

        // Tạo bảng sách
        String tb_Sach = "create table Sach(" +
                "MaSach integer primary key autoincrement," +
                "TenSach text not null," +
                "GiaThue integer not null," +
                "MaLoai integer references LoaiSach(MaLoai) not null)";
        db.execSQL(tb_Sach);

        // Tạo bảng phiếu mượn
        String tb_PhieuMuon = "create table PhieuMuon(" +
                "MaPM integer primary key autoincrement," +
                "MaTT text references ThuThu(MaTT) not null," +
                "MaTV integer references ThanhVien(MaTV) not null," +
                "MaSach integer references Sach(MaSach) not null," +
                "Ngay Date not null," +
                "TraSach integer not null)";
        db.execSQL(tb_PhieuMuon);

        //data mẫu
        // data loại sách
        db.execSQL("insert into LoaiSach values(1,'Lập Trình')," +
                "(2,'Thiết Kế Đồ Họa')," +
                "(3,'Maketing')");
        // data sách
        db.execSQL("insert into Sach values(1,'Lập Trình Java',35000,1)," +
                "(2,'Nhập Môn Thiết Kế Đồ Họa',25000,2)," +
                "(3,'Maketing cơ bản',30000,3)");
        // data thủ thư
        db.execSQL("insert into ThuThu values('Kina','Nguyễn Thiên Thiên','nkoxloveqcno123')");
        //data thành viên

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if(i != i1){
            db.execSQL("drop table if exists ThuThu");
            db.execSQL("drop table if exists ThanhVien");
            db.execSQL("drop table if exists LoaiSach");
            db.execSQL("drop table if exists Sach");
            db.execSQL("drop table if exists PhieuMuon");
            onCreate(db);
        }
    }
}
