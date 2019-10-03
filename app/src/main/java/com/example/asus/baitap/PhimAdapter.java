package com.example.asus.baitap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PhimAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Phim> phimList;

    public PhimAdapter(Context context, int layout, List<Phim> phimList) {
        this.context = context;
        this.layout = layout;
        this.phimList = phimList;
    }

    @Override
    public int getCount() {
        return phimList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE) ;
        convertView=inflater.inflate(layout,null);
        TextView txtTenPhim=(TextView) convertView.findViewById(R.id.txtPhim);
        TextView txtMoTaPhim=(TextView)convertView.findViewById(R.id.txtMota);
        ImageView imgPhim=(ImageView)convertView.findViewById(R.id.imageHinhPhim);
        Phim phim=phimList.get(position);
        txtTenPhim.setText(phim.getTen());
        txtMoTaPhim.setText(phim.getMota());
        imgPhim.setImageResource(phim.getHinh());
        return convertView;
    }
}
