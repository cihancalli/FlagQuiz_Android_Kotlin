package com.zerdasoftware.flagquiz.Models

import android.annotation.SuppressLint

class FlagDAO {

    @SuppressLint("Range")
    fun getRandom5(db:DatabaseHelper) : ArrayList<FlagModel> {
        val flagModelArrayList = ArrayList<FlagModel>()
        val SDB = db.writableDatabase
        val c = SDB.rawQuery("SELECT * FROM flags ORDER BY RANDOM() LIMIT 5",null)

        while (c.moveToNext()){
            var flag = FlagModel(
                c.getInt(c.getColumnIndex("flag_id")),
                c.getString(c.getColumnIndex("flag_name")),
                c.getString(c.getColumnIndex("flag_image")))
            flagModelArrayList.add(flag)

        }
        return flagModelArrayList
    }

    //getRandom3Wrong

    @SuppressLint("Range")
    fun getRandom3Wrong(db:DatabaseHelper,flag_id:Int) : ArrayList<FlagModel> {
        val flagModelArrayList = ArrayList<FlagModel>()
        val SDB = db.writableDatabase
        val c = SDB.rawQuery("SELECT * FROM flags  WHERE flag_id != $flag_id  ORDER BY RANDOM() LIMIT 3",null)

        while (c.moveToNext()){
            var flag = FlagModel(
                c.getInt(c.getColumnIndex("flag_id")),
                c.getString(c.getColumnIndex("flag_name")),
                c.getString(c.getColumnIndex("flag_image")))
            flagModelArrayList.add(flag)

        }
        return flagModelArrayList
    }
}