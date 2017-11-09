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

public class AdapterMon extends BaseAdapter {
    Activity context;
    ArrayList<Mon> list;

    public AdapterMon(Activity context, ArrayList<Mon> list) {
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
        View row = inflater.inflate(R.layout.layout_lv, null);
        TextView txtTen = (TextView) row.findViewById(R.id.DanhSach);


        final Mon mon = list.get(position);
        txtTen.setText(mon.tenmon);

        return row;
    }
}
