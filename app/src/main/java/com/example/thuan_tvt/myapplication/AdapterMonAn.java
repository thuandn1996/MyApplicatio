package com.example.thuan_tvt.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Thuan_TvT on 11/8/2017.
 */

public class AdapterMonAn extends BaseAdapter {
    Activity context;
    ArrayList<MonAn> list;

    public AdapterMonAn(Activity context, ArrayList<MonAn> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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
    public View getView(final int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.manhinh3, null);
        ImageView hinhanh = (ImageView) row.findViewById(R.id.imgAnh);
        TextView tenmon = (TextView) row.findViewById(R.id.tenmon);
        TextView nguyenlieu = (TextView) row.findViewById(R.id.nguyenlieu);
        TextView cachthuchien = (TextView) row.findViewById(R.id.cachthuchien);


        final MonAn monAn = list.get(position);
        tenmon.setText(monAn.tenmon);
        nguyenlieu.setText(monAn.nguyenlieu);
        cachthuchien.setText(monAn.cachthuchien);

        Bitmap anh = BitmapFactory.decodeByteArray(monAn.hinhanh, 0, monAn.hinhanh.length);
        hinhanh.setImageBitmap(anh);

        return row;
    }
}
