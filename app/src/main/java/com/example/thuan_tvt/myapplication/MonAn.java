package com.example.thuan_tvt.myapplication;

/**
 * Created by Thuan_TvT on 11/8/2017.
 */

public class MonAn {
    int id;
    String tenmon;
    String nguyenlieu;
    String cachthuchien;
    byte[] hinhanh;

    public MonAn(int id, String tenmon, String nguyenlieu, String cachthuchien, byte[] hinhanh) {
        this.id = id;
        this.tenmon = tenmon;
        this.nguyenlieu = nguyenlieu;
        this.cachthuchien = cachthuchien;
        this.hinhanh = hinhanh;
    }
}
