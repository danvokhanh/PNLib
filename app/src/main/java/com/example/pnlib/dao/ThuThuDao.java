package com.example.pnlib.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pnlib.database.DbHelper;
import com.example.pnlib.model.LoaiSach;
import com.example.pnlib.model.ThuThu;

import java.util.ArrayList;

public class ThuThuDao {
    DbHelper dbHelper;
    public ThuThuDao(Context context){
        dbHelper = new DbHelper(context);
    }

    // đăng nhập
    public boolean checkLogin(String MaTT,String MatKhau){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from ThuThu where MaTT = ? and MatKhau = ?",new String[]{MaTT, MatKhau});
        if(cursor.getCount() != 0){
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<ThuThu> selectAll(){
        ArrayList<ThuThu> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try{
            Cursor cursor = db.rawQuery("select * from ThuThu",null);
            if(cursor.getCount() > 0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    ThuThu tt = new ThuThu();
                    tt.setMaTT(cursor.getString(0));
                    tt.setHoTen(cursor.getString(1));
                    tt.setMatKhau(cursor.getString(2));
                    list.add(tt);
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public boolean insert(ThuThu tt){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaTT",tt.getMaTT());
        values.put("HoTen",tt.getHoTen());
        values.put("MatKhau",tt.getMatKhau());
        long data = db.insert("ThuThu",null,values);
        return (data > 0);
    }

    public boolean update(ThuThu tt){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaTT",tt.getMaTT());
        values.put("HoTen",tt.getHoTen());
        values.put("MatKhau",tt.getMatKhau());
        long data = db.update("ThuThu",values,"MaTT = ?",new String[]{String.valueOf(tt.getMaTT())});
        return (data > 0);
    }

}
