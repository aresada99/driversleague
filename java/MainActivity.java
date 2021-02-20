package com.example.driverleague;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Driver;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_profile;
    TextView tw_welcome;
    ListView lv_driverList;
    ArrayAdapter driverArrayAdapter;
    DataBaseHelper dbHelper;
    DriverModel clickedDriver;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_profile = findViewById(R.id.btn_profile);
        tw_welcome = findViewById(R.id.tw_welcome);
        lv_driverList = findViewById(R.id.lv_driverList);

        dbHelper = new DataBaseHelper(MainActivity.this);

        ShowDriversOnList(dbHelper);


        String driverName = dbHelper.getDriverNameWithEmail(LoginActivity.loggedInMail);
        tw_welcome.setText("Welcome "+driverName);
        SuccessfullyLoggedInDialogMsg();







        lv_driverList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clickedDriver = (DriverModel) parent.getItemAtPosition(position);
            }
        });


        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenProfileScreen();
            }
        });





    }

    private void ShowDriversOnList(DataBaseHelper dbHelper){
        driverArrayAdapter = new ArrayAdapter<DriverModel>(MainActivity.this, android.R.layout.simple_list_item_1,dbHelper.getAllDrivers());
        lv_driverList.setAdapter(driverArrayAdapter);
    }

    private void OpenLoginScreen(){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    private void SuccessfullyLoggedInDialogMsg(){
        DataBaseHelper dbHelperForDialogMsg = new DataBaseHelper(MainActivity.this);
        String driverName = dbHelperForDialogMsg.getDriverNameWithEmail(LoginActivity.loggedInMail);
        AlertDialog dialog = new AlertDialog.Builder(this).setTitle("Successfully logged in").setMessage("Welcome "+driverName).setPositiveButton("CONTINUE",null).show();

    }

    // Back button's press activity. Empty = disable back button
    public void onBackPressed(){

    }

    private void OpenProfileScreen(){
        Intent intent = new Intent(this,ProfilePage.class);
        startActivity(intent);
    }


}


