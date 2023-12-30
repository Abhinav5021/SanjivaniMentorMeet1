package com.kulswaminitech.sanjivanimentormeet;//package com.example.project.mentor_meeting;
//
//import android.content.Context;
//import android.database.Cursor;
//import android.database.SQLException;
//import android.database.sqlite.SQLiteDatabase;
//
//public class DBManager {
//    private Context context;
//    private SQLiteDatabase database;
//    private MyDBHelper dbHelper;
//
//    public DBManager(Context c){
//        this.context = c;
//    }
//
//    public DBManager open() throws SQLException{
//        this.dbHelper = new MyDBHelper(this.context);
//        this.database= this.dbHelper.getWritableDatabase();
//        return this;
//    }
//
//    public void close(){
//        this.dbHelper.close();
//    }
//
//    public Cursor fetch(){
//        Cursor cursor = this.database.query(MyDBHelper.TABLE_NAME,new String[]{
//                        MyDBHelper.COLUMN_USERNAME,MyDBHelper.COLUMN_PASSWORD},
//                null,null,null,null,null,null);
//        if (cursor != null){
//            cursor.moveToFirst();
//        }
//        return cursor;
//    }
//}
