package com.example.pnlib.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pnlib.database.DbHelper;
import com.example.pnlib.model.LoaiSach;
import com.example.pnlib.model.PhieuMuon;

import java.util.ArrayList;

public class LoaiSachDao {
    DbHelper dbHelper;

    public LoaiSachDao(Context context) {
        dbHelper = new DbHelper(context);
    }

    public ArrayList<LoaiSach> selectAll(){
        ArrayList<LoaiSach> list = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        try{
            Cursor cursor = db.rawQuery("select * from LoaiSach",null);
            if(cursor.getCount() > 0){
                cursor.moveToFirst();
                while (!cursor.isAfterLast()){
                    LoaiSach ls = new LoaiSach();
                    ls.setMaLS(cursor.getInt(0));
                    ls.setTenLS(cursor.getString(1));
                    list.add(ls);
                    cursor.moveToNext();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public boolean insert(LoaiSach ls){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaLS",ls.getMaLS());
        values.put("TenLS",ls.getTenLS());
        long data = db.insert("LoaiSach",null,values);
        return (data > 0);
    }

    public boolean update(LoaiSach ls){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MaLS",ls.getMaLS());
        values.put("TenLS",ls.getTenLS());
        long data = db.update("LoaiSach",values,"MaLS = ?",new String[]{String.valueOf(ls.getMaLS())});
        return (data > 0);
    }

    public boolean delete(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long data = db.delete("LoaiSach","MaLS = ?",new String[]{String.valueOf(id)});
        return (data > 0);
    }
}
