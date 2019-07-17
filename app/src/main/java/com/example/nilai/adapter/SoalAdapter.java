package com.example.nilai.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nilai.R;
import com.example.nilai.model.Nilai;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SoalAdapter extends RecyclerView.Adapter<SoalAdapter.JadwalViewHolder> {


    private ArrayList<Nilai> dataList;
    private Context context;

    public SoalAdapter(ArrayList<Nilai> dataList,Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public SoalAdapter.JadwalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_nilai, parent, false);
        return new SoalAdapter.JadwalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SoalAdapter.JadwalViewHolder holder, final int position) {

        holder.soal.setText(dataList.get(position).getSoal());
        holder.jawaban.setText(dataList.get(position).getJawbabanTerpilih());

    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class JadwalViewHolder extends RecyclerView.ViewHolder{
        private TextView soal,jawaban,tv_status,tv_info;

        public JadwalViewHolder(View itemView) {
            super(itemView);
            soal = (TextView) itemView.findViewById(R.id.tvSoal);
            jawaban = (TextView) itemView.findViewById(R.id.tvJawaban);

        }
    }
}