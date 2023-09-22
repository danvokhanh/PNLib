package com.example.pnlib.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pnlib.database.DbHelper;
import com.example.pnlib.model.PhieuMuon;
import com.example.pnlib.model.Sach;

import java.util.ArrayList;

public class SachDao {
    DbHelper dbHelper;
    public SachDao(Context context){
        dbHelper = new DbHelper(context);
    }

    // Lấy toàn bộ đầu sách có ở trong thư viện
//    public ArrayList<Sach> selectAll(){
//        ArrayList<Sach> list = new ArrayList<>();
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        Cursor cursor = db.rawQuery("select * from Sach",null);
//        if(cursor.getCount() != 0){
//            cursor.moveToFirst();
//            do{
//                list.add(new Sach(cursor.getInt(0),cursor.getString(1),cursor.getInt(2),cursor.getInt(3)));
//            }while (cursor.moveToNext());
//        }
//        return list;
//    }


    public ArrayList<Sach> selectAll(){
        ArrayList<Sach> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try{
            Cursor cursor = db.rawQuery("select * from Sach",null);
            if(cursor.getCount() > 0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    Sach s = new Sach();
                    s.setMaSach(cursor.getInt(0));
                    s.setTenSach(cursor.getString(1));
                    s.setGiaThue(cursor.getInt(2));
                    s.setMaLoai(cursor.getInt(3));
                    list.add(s);
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public boolean insert(Sach s){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaSach",s.getMaSach());
        values.put("TenSach",s.getTenSach());
        values.put("GiaThue",s.getGiaThue());
        values.put("MaLoai",s.getMaLoai());
        long data = db.insert("Sach",null,values);
        return (data > 0);
    }

    public boolean update(Sach s){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaSach",s.getMaSach());
        values.put("TenSach",s.getTenSach());
        values.put("GiaThue",s.getGiaThue());
        values.put("MaLoai",s.getMaLoai());
        long data = db.update("Sach",values,"MaSach = ?",new String[]{String.valueOf(s.getMaSach())});
        return (data > 0);
    }

    public boolean delete(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long data = db.delete("Sach","MaSach = ?",new String[]{String.valueOf(id)});
        return (data > 0);
    }
}
