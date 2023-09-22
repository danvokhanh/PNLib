package com.example.pnlib.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.pnlib.R;
import com.example.pnlib.model.PhieuMuon;

import java.util.ArrayList;

public class adapter_PhieuMuon extends BaseAdapter {

    private Context context;
    private ArrayList<PhieuMuon> list;

    public adapter_PhieuMuon(Context context, ArrayList<PhieuMuon> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        view = inflater.inflate(R.layout.item_phieu_muon,parent,false);

        TextView MaPM = view.findViewById(R.id.MaPM);
        TextView TV_PM = view.findViewById(R.id.PM_TV);
        TextView TS_PM = view.findViewById(R.id.PM_TS);
        TextView TT_PM = view.findViewById(R.id.PM_TT);
        TextView TrangThai_PM = view.findViewById(R.id.PM_TrangThai);
        TextView NgayThue_PM = view.findViewById(R.id.PM_NT);
        Button PM_Delete = view.findViewById(R.id.PM_Delete);

        MaPM.setText(list.get(position).getMaPM());
        TV_PM.setText(list.get(position).getMaTV());
        TS_PM.setText(list.get(position).get);

        return view;
    }
}
