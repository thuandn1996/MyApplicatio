package com.example.thuan_tvt.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;



public class Listview extends Activity  {
    final String DATABASE_NAME = "ab.sqlite";
    SQLiteDatabase database;
    private ListView Lv;
    private ArrayList<String> List;
    ArrayList<Mon> list;
    AdapterMon adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        addControls();
        readData();
        Lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Listview.this, manhinh3.class);
                intent.putExtra("Name", list.get(i).getClass().toString());
                startActivity(intent);
            }
        });
    }

    private void addControls() {
        Lv = (ListView) findViewById(R.id.LvDanhSach);
        list = new ArrayList<>();
        adapter = new AdapterMon(this, list);
        Lv.setAdapter(adapter);
    }

    private void readData(){
        database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM mon",null);
        list.clear();
        for(int i = 0; i < cursor.getCount(); i++){
            cursor.moveToPosition(i);
            int id = cursor.getInt(0);
            String tenmon = cursor.getString(1);
            list.add(new Mon(id, tenmon));
        }
        adapter.notifyDataSetChanged();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id =item.getItemId();
        if(id==R.id.action_search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}

