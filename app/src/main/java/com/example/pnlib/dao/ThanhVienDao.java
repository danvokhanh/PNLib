package com.example.pnlib.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pnlib.database.DbHelper;
import com.example.pnlib.model.PhieuMuon;
import com.example.pnlib.model.ThanhVien;

import java.util.ArrayList;

public class ThanhVienDao {
    DbHelper dbHelper;

    public ThanhVienDao(Context context) {
        dbHelper = new DbHelper(context);
    }

    public ArrayList<ThanhVien> selectAll(){
        ArrayList<ThanhVien> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try{
            Cursor cursor = db.rawQuery("select * from ThanhVien",null);
            if(cursor.getCount() > 0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    ThanhVien tv = new ThanhVien();
                    tv.setMaTV(cursor.getInt(0));
                    tv.setHoTen(cursor.getString(1));
                    tv.setNamSinh(cursor.getString(2));
                    list.add(tv);
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public boolean insert(ThanhVien tv){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaTV",tv.getMaTV());
        values.put("HoTen",tv.getHoTen());
        values.put("NamSinh",tv.getNamSinh());
        long data = db.insert("ThanhVien",null,values);
        return (data > 0);
    }

    public boolean update(ThanhVien tv){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaTV",tv.getMaTV());
        values.put("HoTen",tv.getHoTen());
        values.put("NamSinh",tv.getNamSinh());
        long data = db.update("ThanhVien",values,"MaTV = ?",new String[]{String.valueOf(tv.getMaTV())});
        return (data > 0);
    }

    public boolean delete(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long data = db.delete("ThanhVien","MaTV = ?",new String[]{String.valueOf(id)});
        return (data > 0);
    }
}
