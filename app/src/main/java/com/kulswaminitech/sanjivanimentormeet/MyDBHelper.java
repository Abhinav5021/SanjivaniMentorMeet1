package com.kulswaminitech.sanjivanimentormeet;//package com.example.project.mentor_meeting;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//public class MyDBHelper extends SQLiteOpenHelper {
//    private static  final String DATABASE_NAME = "login.db";
//    private static  final int DATABASE_VERSION = 1;
//    public static final  String TABLE_NAME = "users";
//    public static final  String COLUMN_USERNAME = "username";
//    public static final String COLUMN_PASSWORD = "password";
//
//    public MyDBHelper(Context context){
//        super(context,DATABASE_NAME,null,DATABASE_VERSION);
//    }
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("create table users(username TEXT primary key, password TEXT)");
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("drop table if exists users");
//    }
//    public boolean insertData(String username,String password){
//        SQLiteDatabase database = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("username",username);
//        values.put("password",password);
//        long result= database.insert("users",null,values);
//        if (result!=-1){
//            return true;
//        }else {
//            return false;
//        }
//    }
//    public Boolean checkusername(String username){
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor c = db.rawQuery("select * from users where username=?",new String[]{username});
//        if(c.getCount()>0) {
//            return true;
//        }else {
//            return false;
//        }
//    }
//    public Boolean checkusernamepassword(String username,String password){
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor c = db.rawQuery("select * from users where username=? and password=?",new String[]{username,password});
//        if(c.getCount()>0) {
//            return true;
//        }else {
//            return false;
//        }
//    }
//
////public void insertDataInTable(){
////    SQLiteDatabase db = this.getWritableDatabase();
////
////}
//
//}
