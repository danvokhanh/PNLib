package com.example.pnlib.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnlib.R;
import com.example.pnlib.model.PhieuMuon;

import java.util.ArrayList;

public class adapter_phieu_muon extends RecyclerView.Adapter<adapter_phieu_muon.ViewHolder> {

    private ArrayList<PhieuMuon> list;
    private Context context;

    public adapter_phieu_muon(ArrayList<PhieuMuon> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_phieu_muon,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtMaPM.setText(String.valueOf(list.get(position).getMaPM()));
        holder.txtTenTV.setText(list.get(position).getHoTenTV());
        holder.txtTenSach.setText(list.get(position).getTenSach());
        String trangthai = "";
        if(list.get(position).getTrangThai() == 1){
            trangthai = "Đã trả sách";
        }else{
            trangthai = "chưa trả sách";
        }
        holder.txtTrangThai.setText(trangthai);
        holder.txtTienThue.setText(String.valueOf(list.get(position).getTienThue()));
        holder.txtNgay.setText(list.get(position).getNgayThue());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtMaPM, txtMaTV, txtTenTV, txtMaTT, txtTenTT, txtMaSach, txtTenSach, txtNgay, txtTrangThai, txtTienThue;
        ImageView PM_Delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtMaPM =  itemView.findViewById(R.id.MaPM);
            txtTenTV =  itemView.findViewById(R.id.TenTV);
            txtTenSach =  itemView.findViewById(R.id.TenSach);
            txtNgay =  itemView.findViewById(R.id.PM_NT);
            txtTrangThai =  itemView.findViewById(R.id.PM_TrangThai);
            txtTienThue =  itemView.findViewById(R.id.PM_TT);
            PM_Delete = itemView.findViewById(R.id.PM_Delete);
        }
    }

}
