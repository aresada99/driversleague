package com.example.driverleague;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProfilePage extends AppCompatActivity {

    TextView tv_profileName,tv_eq_firm,tv_eq_chassisNo,tv_eq_avgSpeed,tv_eq_cruiseControl,tv_eq_brake,tv_eq_tonnage,tv_eq_idle,tv_eq_fuelAvg,tv_eq_km;
    DataBaseHelper dbHelper;
    DriverInfoDbHelper driverInfoDbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        dbHelper = new DataBaseHelper(ProfilePage.this);
        driverInfoDbHelper = new DriverInfoDbHelper(ProfilePage.this);

        tv_eq_firm = findViewById(R.id.tv_eq_firm);
        tv_eq_chassisNo = findViewById(R.id.tv_eq_chassisNo);
        tv_eq_avgSpeed = findViewById(R.id.tv_eq_avgSpeed);
        tv_eq_cruiseControl = findViewById(R.id.tv_eq_cruiseControl);
        tv_eq_brake = findViewById(R.id.tv_eq_brake);
        tv_eq_tonnage = findViewById(R.id.tv_eq_tonnage);
        tv_eq_idle = findViewById(R.id.tv_eq_idle);
        tv_eq_fuelAvg = findViewById(R.id.tv_eq_fuelAvg);
        tv_eq_km = findViewById(R.id.tv_eq_km);


        tv_profileName = findViewById(R.id.tv_profileName);
        String email = LoginActivity.loggedInMail;

        String driverName = dbHelper.getDriverNameWithEmail(email);
        tv_profileName.setText(driverName+"'s Profile");

        tv_eq_firm.setText(driverInfoDbHelper.getDriverInfoFirmWithEmail(email));
        tv_eq_chassisNo.setText(driverInfoDbHelper.getDriverInfoChassisnoWithEmail(email));
        tv_eq_avgSpeed.setText(String.valueOf(driverInfoDbHelper.getDriverInfoAvgSpeedWithEmail(email)));
        tv_eq_cruiseControl.setText(driverInfoDbHelper.getDriverInfoCruisectrlWithEmail(email));
        tv_eq_brake.setText(String.valueOf(driverInfoDbHelper.getDriverInfoBrakeWithEmail(email)));
        tv_eq_tonnage.setText(String.valueOf(driverInfoDbHelper.getDriverInfoTonnageWithEmail(email)));
        tv_eq_idle.setText(driverInfoDbHelper.getDriverInfoIdleWithEmail(email));
        tv_eq_fuelAvg.setText(Float.toString(driverInfoDbHelper.getDriverInfoFuelAvgWithEmail(email)));
        tv_eq_km.setText(String.valueOf(driverInfoDbHelper.getDriverInfoKmWithEmail(email)));


    }



}