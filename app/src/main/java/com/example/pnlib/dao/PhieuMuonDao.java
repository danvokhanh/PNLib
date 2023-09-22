package com.example.pnlib.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pnlib.database.DbHelper;
import com.example.pnlib.model.PhieuMuon;

import java.util.ArrayList;

public class PhieuMuonDao {
    DbHelper dbHelper;

    public PhieuMuonDao(Context context) {
        dbHelper = new DbHelper(context);
    }

    public ArrayList<PhieuMuon> selectAll(){
        ArrayList<PhieuMuon> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try{
            Cursor cursor = db.rawQuery("select * from PhieuMuon",null);
            if(cursor.getCount() > 0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    PhieuMuon pm = new PhieuMuon();
                    pm.setMaPM(cursor.getInt(0));
                    pm.setMaTV(cursor.getInt(1));
                    pm.setMaTT(cursor.getString(2));
                    pm.setMaSach(cursor.getInt(3));
                    pm.setNgay(cursor.getString(4));
                    pm.setTienThue(cursor.getInt(5));
                    pm.setTraSach(cursor.getInt(6));
                    list.add(pm);
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public boolean insert(PhieuMuon pm){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaPM",pm.getMaPM());
        values.put("MaTV",pm.getMaTV());
        values.put("MaTT",pm.getMaTT());
        values.put("MaSach",pm.getMaSach());
        values.put("Ngay",pm.getNgay());
        values.put("TienThue",pm.getTienThue());
        values.put("TraSach",pm.getTraSach());
        long data = db.insert("PhieuMuon",null,values);
        return (data > 0);
    }

    public boolean update(PhieuMuon pm){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaPM",pm.getMaPM());
        values.put("MaTV",pm.getMaTV());
        values.put("MaTT",pm.getMaTT());
        values.put("MaSach",pm.getMaSach());
        values.put("Ngay",pm.getNgay());
        values.put("TienThue",pm.getTienThue());
        values.put("TraSach",pm.getTraSach());
        long data = db.update("PhieuMuon",values,"MaPM = ?",new String[]{String.valueOf(pm.getMaPM())});
        return (data > 0);
    }

    public boolean delete(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long data = db.delete("PhieuMuon","MaPM = ?",new String[]{String.valueOf(id)});
        return (data > 0);
    }
}
