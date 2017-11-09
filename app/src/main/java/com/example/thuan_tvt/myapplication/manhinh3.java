package com.example.thuan_tvt.myapplication;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import java.util.ArrayList;


public class manhinh3 extends Activity {
    final String DATABASE_NAME = "ab.sqlite";
    SQLiteDatabase database;
    private ListView Lv;
    private ArrayList<String> List;
    ArrayList<MonAn> list;
    AdapterMonAn adapter;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinh3);
        addControls();
        readData();
    }

    private void addControls() {
        list = new ArrayList<>();
        adapter = new AdapterMonAn(this, list);
    }

    private void readData(){
        database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM monan",null);
        list.clear();
        for(int i = 0; i < cursor.getCount(); i++){
            cursor.moveToPosition(i);
            int id = cursor.getInt(0);
            String tenmon = cursor.getString(1);
            String nguyenlieu = cursor.getString(2);
            String cachthuchien = cursor.getString(3);
            byte[] anh = cursor.getBlob(4);
            list.add(new MonAn(id, tenmon, nguyenlieu,cachthuchien, anh));
        }
        adapter.notifyDataSetChanged();
    }
}
