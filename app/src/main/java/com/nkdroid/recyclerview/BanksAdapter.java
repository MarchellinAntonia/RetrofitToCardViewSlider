package com.nkdroid.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class BanksAdapter extends RecyclerView.Adapter<BanksAdapter.MovieViewHolder> {

    private List<DataBank> dataBank;
    private int rowLayout;
    private Context context;

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView namaBankText;
        TextView kodebankText;

        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.banks_layout);
            namaBankText = (TextView) v.findViewById(R.id.data_bank_name);
            kodebankText = (TextView) v.findViewById(R.id.data_bank_code);
        }
    }

    public BanksAdapter(List<DataBank> dataBank, int rowLayout, Context context) {
        this.dataBank = dataBank;
        this.rowLayout = rowLayout;
        this.context = context;
        //dataBank = bank.getDataBank();
    }

    @Override
    public BanksAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.namaBankText.setText(dataBank.get(position).getName());
        holder.kodebankText.setText(dataBank.get(position).getCode());
    }

    @Override
    public int getItemCount() {
        return dataBank.size();
    }
}