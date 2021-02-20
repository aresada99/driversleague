package com.example.driverleague;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DriverInfoDbHelper extends SQLiteOpenHelper {
    public static final String DRIVERINFO_TABLE = "DRIVERINFO_TABLE";
    public static final String COLUMN_DRIVERINFO_EMAIL = "DRIVERINFO_EMAIL";
    public static final String COLUMN_DRIVERINFO_FIRM = "DRIVERINFO_FIRM";
    public static final String COLUMN_DRIVERINFO_CHASSISNO = "DRIVERINFO_CHASSISNO";
    public static final String COLUMN_DRIVERINFO_AVGSPEED = "DRIVERINFO_AVGSPEED";
    public static final String COLUMN_DRIVERINFO_CRUISECTRL = "DRIVERINFO_CRUISECTRL";
    public static final String COLUMN_DRIVERINFO_BRAKE = "DRIVERINFO_BRAKE";
    public static final String COLUMN_DRIVERINFO_TONNAGE = "DRIVERINFO_TONNAGE";
    public static final String COLUMN_DRIVERINFO_IDLE = "DRIVERINFO_IDLE";
    public static final String COLUMN_DRIVERINFO_FUELAVG = "DRIVERINFO_FUELAVG";
    public static final String COLUMN_DRIVERINFO_KM = "DRIVERINFO_KM";



    public DriverInfoDbHelper(@Nullable Context context) {
        super(context, "DriverInfo.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + DRIVERINFO_TABLE + " (" + COLUMN_DRIVERINFO_EMAIL + " TEXT PRIMARY KEY, " + COLUMN_DRIVERINFO_FIRM + " TEXT, " + COLUMN_DRIVERINFO_CHASSISNO + " TEXT, " + COLUMN_DRIVERINFO_AVGSPEED + " INTEGER, " + COLUMN_DRIVERINFO_CRUISECTRL + " TEXT, " + COLUMN_DRIVERINFO_BRAKE + " INTEGER, " + COLUMN_DRIVERINFO_TONNAGE + " INTEGER, " + COLUMN_DRIVERINFO_IDLE + " TEXT, " + COLUMN_DRIVERINFO_FUELAVG +" REAL, " + COLUMN_DRIVERINFO_KM + " INTEGER)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String queryString = "DROP TABLE IF EXISTS DRIVERINFO_TABLE";
        db.execSQL(queryString);
    }



    /////////////////////// GETTERS WITH EMAIL ///////////////////////



    public String getDriverInfoFirmWithEmail(String email){
        String queryString = "SELECT * FROM DRIVERINFO_TABLE WHERE DRIVERINFO_EMAIL = '" + email + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        String firm = "";
        if(cursor.moveToFirst()){
            do{
                firm = cursor.getString(1);
            }while(cursor.moveToNext());
        }
        else{}
        return firm;
    }

    public String getDriverInfoChassisnoWithEmail(String email){
        String queryString = "SELECT * FROM DRIVERINFO_TABLE WHERE DRIVERINFO_EMAIL = '" + email + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        String chassisNo = "";
        if(cursor.moveToFirst()){
            do{
                chassisNo = cursor.getString(2);
            }while(cursor.moveToNext());
        }
        else{}
        return chassisNo;
    }

    public int getDriverInfoAvgSpeedWithEmail(String email){
        String queryString = "SELECT * FROM DRIVERINFO_TABLE WHERE DRIVERINFO_EMAIL = '" + email + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        int avgSpeed = -1;
        if(cursor.moveToFirst()){
            do{
                avgSpeed = cursor.getInt(3);
            }while(cursor.moveToNext());
        }
        else{}
        return avgSpeed;
    }

    public String getDriverInfoCruisectrlWithEmail(String email){
        String queryString = "SELECT * FROM DRIVERINFO_TABLE WHERE DRIVERINFO_EMAIL = '" + email + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        String cruiseCtrl = "";
        if(cursor.moveToFirst()){
            do{
                cruiseCtrl = cursor.getString(4);
            }while(cursor.moveToNext());
        }
        else{}
        return cruiseCtrl;
    }

    public int getDriverInfoBrakeWithEmail(String email){
        String queryString = "SELECT * FROM DRIVERINFO_TABLE WHERE DRIVERINFO_EMAIL = '" + email + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        int brake = -1;
        if(cursor.moveToFirst()){
            do{
                brake = cursor.getInt(5);
            }while(cursor.moveToNext());
        }
        else{}
        return brake;
    }

    public int getDriverInfoTonnageWithEmail(String email){
        String queryString = "SELECT * FROM DRIVERINFO_TABLE WHERE DRIVERINFO_EMAIL = '" + email + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        int tonnage = -1;
        if(cursor.moveToFirst()){
            do{
                tonnage = cursor.getInt(6);
            }while(cursor.moveToNext());
        }
        else{}
        return tonnage;
    }

    public String getDriverInfoIdleWithEmail(String email){
        String queryString = "SELECT * FROM DRIVERINFO_TABLE WHERE DRIVERINFO_EMAIL = '" + email + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        String idle = "";
        if(cursor.moveToFirst()){
            do{
                idle = cursor.getString(7);
            }while(cursor.moveToNext());
        }
        else{}
        return idle;
    }

    public float getDriverInfoFuelAvgWithEmail(String email){
        String queryString = "SELECT * FROM DRIVERINFO_TABLE WHERE DRIVERINFO_EMAIL = '" + email + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        float fuelAvg = 0.0f;
        if(cursor.moveToFirst()){
            do{
                fuelAvg = cursor.getFloat(8);
            }while(cursor.moveToNext());
        }
        else{}
        return fuelAvg;
    }

    public int getDriverInfoKmWithEmail(String email){
        String queryString = "SELECT * FROM DRIVERINFO_TABLE WHERE DRIVERINFO_EMAIL = '" + email + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        int km = -1;
        if(cursor.moveToFirst()){
            do{
                km = cursor.getInt(9);
            }while(cursor.moveToNext());
        }
        else{}
        return km;
    }

    //////////////////////////////////////////////////////////////////




    public boolean addOne(DriverInfoModel dim){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_DRIVERINFO_EMAIL, dim.getEmail());
        cv.put(COLUMN_DRIVERINFO_FIRM,dim.getFirm());
        cv.put(COLUMN_DRIVERINFO_CHASSISNO,dim.getChassisNo());
        cv.put(COLUMN_DRIVERINFO_AVGSPEED,dim.getAvgSpeed());
        cv.put(COLUMN_DRIVERINFO_CRUISECTRL,dim.getCruiseCtrl());
        cv.put(COLUMN_DRIVERINFO_BRAKE,dim.getBrake());
        cv.put(COLUMN_DRIVERINFO_TONNAGE,dim.getTonnage());
        cv.put(COLUMN_DRIVERINFO_IDLE,dim.getIdle());
        cv.put(COLUMN_DRIVERINFO_FUELAVG,dim.getFuelAvg());
        cv.put(COLUMN_DRIVERINFO_KM,dim.getKm());

        long insert = db.insert(DRIVERINFO_TABLE, null, cv);
        if(insert == -1){
            return false;
        }
        else{
            return true;
        }

    }

    public List<DriverInfoModel> getAllDrivers(){
        List<DriverInfoModel> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + DRIVERINFO_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString,null);

        if(cursor.moveToFirst()){
            do{

                String email = cursor.getString(0);
                String firm = cursor.getString(1);
                String chassisNo = cursor.getString(2);
                int avgSpeed = cursor.getInt(3);
                String cruiseCtrl = cursor.getString(4);
                int brake = cursor.getInt(5);
                int tonnage = cursor.getInt(6);
                String idle = cursor.getString(7);
                float fuelAvg = cursor.getFloat(8);
                int km = cursor.getInt(9);

                DriverInfoModel newDriverInfo = new DriverInfoModel(email,firm,chassisNo,avgSpeed,cruiseCtrl,brake,tonnage,idle,fuelAvg,km);
                returnList.add(newDriverInfo);


            }while(cursor.moveToNext());
        }
        else{

        }
        cursor.close();
        db.close();

        return returnList;
    }

    public boolean deleteOne(DriverInfoModel dim){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + DRIVERINFO_TABLE + " WHERE " + COLUMN_DRIVERINFO_EMAIL + " = " + dim.getEmail();
        Cursor cursor = db.rawQuery(queryString,null);
        if(cursor.moveToFirst()){
            return true;
        }
        else{
            return false;
        }
    }


}
