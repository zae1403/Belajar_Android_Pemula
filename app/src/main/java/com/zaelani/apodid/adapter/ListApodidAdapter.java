package com.zaelani.apodid.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zaelani.apodid.DetailActivity;
import com.zaelani.apodid.R;
import com.zaelani.apodid.model.Apodid;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;


public class ListApodidAdapter extends RecyclerView.Adapter <ListApodidAdapter.ListViewHolder> {

    private ArrayList<Apodid> listapod;

    public ListApodidAdapter(ArrayList<Apodid> list){
        this.listapod = list;
    }


    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_apod, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListViewHolder holder, int position) {
        final Apodid apodid = listapod.get(position);

        Glide.with(holder.itemView.getContext())
                .load(apodid.getPhoto())
                .into(holder.imgPhoto);
        holder.tvTitle.setText(apodid.getTitle());
        holder.tvDate.setText(apodid.getDate());
        holder.tvDetail.setText(apodid.getDetail());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveDataIntent = new Intent(v.getContext(), DetailActivity.class);
                moveDataIntent.putExtra(DetailActivity.EXTRA_TITLE, apodid.getTitle());
                moveDataIntent.putExtra(DetailActivity.EXTRA_DATE,apodid.getDate() );
                moveDataIntent.putExtra(DetailActivity.EXTRA_DETAIL, apodid.getDetail());
                moveDataIntent.putExtra(DetailActivity.EXTRA_IMAGE, apodid.getPhoto());
                moveDataIntent.putExtra(DetailActivity.EXTRA_FOTO, apodid.getKredit_foto());
                moveDataIntent.putExtra(DetailActivity.EXTRA_KONTEN, apodid.getKredit_konten());
                moveDataIntent.putExtra(DetailActivity.EXTRA_TRANSLATOR, apodid.getAlih_bahasa());

                v.getContext().startActivity(moveDataIntent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listapod.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvTitle,tvDetail,tvDate;

        ListViewHolder(View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_photo);
            tvDetail = itemView.findViewById(R.id.tv_detail);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvTitle = itemView.findViewById(R.id.tv_title);

        }
    }

}