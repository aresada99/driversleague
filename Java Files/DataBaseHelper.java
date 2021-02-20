package com.example.driverleague;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DRIVER_TABLE = "DRIVER_TABLE";
    public static final String COLUMN_DRIVER_NAME = "DRIVER_NAME";
    public static final String COLUMN_DRIVER_SURNAME = "DRIVER_SURNAME";
    public static final String COLUMN_DRIVER_EMAIL = "DRIVER_EMAIL";
    public static final String COLUMN_DRIVER_PASSWORD = "DRIVER_PASSWORD";
    public static final String COLUMN_DRIVER_PHONE_NUM = "DRIVER_PHONE_NUM";
    public static final String COLUMN_DRIVER_CAR_MAKE = "DRIVER_CAR_MAKE";
    public static final String COLUMN_DRIVER_CAR_MODEL = "DRIVER_CAR_MODEL";
    public static final String COLUMN_DRIVER_ID = "DRIVER_ID";


    public DataBaseHelper(@Nullable Context context) {
        super(context, "drivers.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + DRIVER_TABLE + " (" + COLUMN_DRIVER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_DRIVER_NAME + " TEXT, " + COLUMN_DRIVER_SURNAME + " TEXT, " + COLUMN_DRIVER_EMAIL + " TEXT, " + COLUMN_DRIVER_PASSWORD + " TEXT, " + COLUMN_DRIVER_PHONE_NUM + " TEXT, " + COLUMN_DRIVER_CAR_MAKE + " TEXT, " + COLUMN_DRIVER_CAR_MODEL + " TEXT)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists DRIVER_TABLE");

    }

    public boolean addOne(DriverModel dm){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_DRIVER_NAME,dm.getName());
        cv.put(COLUMN_DRIVER_SURNAME,dm.getSurname());
        cv.put(COLUMN_DRIVER_EMAIL,dm.getEmail());
        cv.put(COLUMN_DRIVER_PASSWORD,dm.getPassword());
        cv.put(COLUMN_DRIVER_PHONE_NUM,dm.getPhone_num());
        cv.put(COLUMN_DRIVER_CAR_MAKE,dm.getCar_make());
        cv.put(COLUMN_DRIVER_CAR_MODEL,dm.getCar_model());

        long insert = db.insert(DRIVER_TABLE, null, cv);
        if(insert ==  -1){
            return false;
        }
        else{
            return true;
        }

    }

    /////////////////////// GETTERS WITH EMAIL ///////////////////////

    public int getDriverIDWithEmail(String email){
        String queryString = "SELECT * FROM DRIVER_TABLE WHERE DRIVER_EMAIL = '" + email + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        int driverID = -1;
        if(cursor.moveToFirst()){
            do{
                driverID = cursor.getInt(0);
            }while(cursor.moveToNext());
        }
        else{

        }

        return driverID;
    }

    public String getDriverNameWithEmail(String email){
        String queryString = "SELECT * FROM DRIVER_TABLE WHERE DRIVER_EMAIL = '" + email + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        String driverName = "";

        if(cursor.moveToFirst()){
            do{
                 driverName = cursor.getString(1);
            }while(cursor.moveToNext());
        }
        else{

        }
        return driverName;
    }

    public String getDriverSurnameWithEmail(String email){
        String queryString = "SELECT * FROM DRIVER_TABLE WHERE DRIVER_EMAIL = '" + email + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        String driverSurname = "";

        if(cursor.moveToFirst()){
            do{
                driverSurname = cursor.getString(2);
            }while(cursor.moveToNext());
        }
        else{

        }
        return driverSurname;
    }

    public String getDriverPasswordWithEmail(String email){
        String queryString = "SELECT * FROM DRIVER_TABLE WHERE DRIVER_EMAIL = '" + email + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        String driverPassword = "";

        if(cursor.moveToFirst()){
            do{
                driverPassword = cursor.getString(4);
            }while(cursor.moveToNext());
        }
        else{

        }
        return driverPassword;
    }

    public String getDriverPhoneNumWithEmail(String email){
        String queryString = "SELECT * FROM DRIVER_TABLE WHERE DRIVER_EMAIL = '" + email + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        String driverPhoneNum = "";

        if(cursor.moveToFirst()){
            do{
                driverPhoneNum = cursor.getString(5);
            }while(cursor.moveToNext());
        }
        else{

        }
        return driverPhoneNum;
    }

    public String getDriverCarMakeWithEmail(String email){
        String queryString = "SELECT * FROM DRIVER_TABLE WHERE DRIVER_EMAIL = '" + email + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        String driverCarMake = "";

        if(cursor.moveToFirst()){
            do{
                driverCarMake = cursor.getString(6);
            }while(cursor.moveToNext());
        }
        else{

        }
        return driverCarMake;
    }

    public String getDriverCarModelWithEmail(String email){
        String queryString = "SELECT * FROM DRIVER_TABLE WHERE DRIVER_EMAIL = '" + email + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        String driverCarModel = "";

        if(cursor.moveToFirst()){
            do{
                driverCarModel = cursor.getString(7);
            }while(cursor.moveToNext());
        }
        else{

        }
        return driverCarModel;
    }

    //////////////////////////////////////////////////////////////////


    public List<DriverModel> getAllDrivers(){
        List<DriverModel> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + DRIVER_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString,null);

        if(cursor.moveToFirst()){
            do{
                int driverID = cursor.getInt(0);
                String driverName = cursor.getString(1);
                String driverSurname = cursor.getString(2);
                String driverEmail = cursor.getString(3);
                String driverPassword = cursor.getString(4);
                String driverPhoneNum = cursor.getString(5);
                String driverCarMake = cursor.getString(6);
                String driverCarModel = cursor.getString(7);

                DriverModel newDriver = new DriverModel(driverID,driverName,driverSurname,driverEmail,driverPassword,driverPhoneNum,driverCarMake,driverCarModel);
                returnList.add(newDriver);

            }while(cursor.moveToNext());
        }
        else{

        }
        cursor.close();
        db.close();

        return returnList;
    }

    public boolean checkEmail(String givenEmail){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "SELECT * FROM DRIVER_TABLE WHERE DRIVER_EMAIL =  ?";
        Cursor cursor = db.rawQuery(queryString,new String[]{givenEmail});
        if(cursor.getCount() > 0){
            return false;
        }
        else{
            return true;
        }

    }

    public boolean checkEmailPassword(String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "SELECT * FROM DRIVER_TABLE WHERE DRIVER_EMAIL = ? AND DRIVER_PASSWORD = ?";
        Cursor cursor = db.rawQuery(queryString,new String[]{email,password});

        if(cursor.getCount()>0){
            return true;
        }
        else{return false;}

    }

    public boolean deleteOne(DriverModel dm){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + DRIVER_TABLE + " WHERE " + COLUMN_DRIVER_ID + " = " + dm.getId();
        Cursor cursor = db.rawQuery(queryString,null);
        if(cursor.moveToFirst()){
            return true;
        }
        else{
            return false;
        }
    }


}
