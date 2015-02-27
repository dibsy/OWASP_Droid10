package com.dibsyhex.droid10.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by WHOIS on 25-02-2015.
 */
public class StorageHelper {
    private static String vectorID;
    private static String vectorName;
    private static String databaseName;
    private static String tableName;
    private static int version=1;
    private static String createQuery;


    private final Context context;
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase sqLiteDatabase;

    public StorageHelper(Context c){
        context=c;
        databaseHelper=new DatabaseHelper(context);
    }

    public StorageHelper(Context c, String vectorID, String vectorName, String databaseName, String tableName, String createQuery){
        context=c;
        databaseHelper=new DatabaseHelper(context);
        this.vectorID=vectorID;
        this.vectorName=vectorName;
        this.databaseName=databaseName;
        this.tableName=tableName;
        this.createQuery=createQuery;
    }



    private static class DatabaseHelper extends SQLiteOpenHelper{
        DatabaseHelper(Context c){
            super(c,databaseName,null,version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                db.execSQL(createQuery);
            }catch (Exception e){
                Log.e("ERROR","onCreate()"+e.toString());
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                db.execSQL("DROP TABLE IF EXISTS " + tableName);
                onCreate(db);
            }catch (Exception e){
                Log.e("ERROR","onUpgrade()"+e.toString());
            }

        }
    }

    public StorageHelper connect(){
        try {
            sqLiteDatabase = databaseHelper.getWritableDatabase();
            return this;
        }catch (Exception e){
            Log.e("ERROR","connect()"+e.toString());
            return this;
        }
    }

    public void disconnect(){
        databaseHelper.close();
    }

    public long insert(String vector){
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(vectorName, vector);
            this.connect();
            return sqLiteDatabase.insert(tableName, null, contentValues);
        }catch (Exception e){
            Log.e("ERROR","insert()"+e.toString());
            return 0;
        }

    }

    public Cursor retrieve(){
        try {
            this.connect();
            return sqLiteDatabase.query(tableName,new String[]{vectorID,vectorName},null,null,null,null,null);
        }catch (Exception e){
            Log.e("ERROR","retrieve()"+e.toString());
            return null;
        }

    }

    public boolean update(String vector,int id){
        this.connect();
        ContentValues contentValues=new ContentValues();
        contentValues.put(vectorName,vector);
        return (sqLiteDatabase.update(tableName,contentValues,vectorID+"="+id,null) > 0);
    }

    public boolean delete(int id){
        this.connect();
        return (sqLiteDatabase.delete(tableName,vectorID+"="+id,null) > 0);
    }

}
