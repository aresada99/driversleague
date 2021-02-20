package com.example.driverleague;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    Button btn_register,btn_back;
    EditText et_reg_name,et_reg_surname,et_reg_email,et_reg_password,et_reg_confirmPassword,et_reg_pnumber,et_reg_carMake,et_reg_carModel;
    DataBaseHelper dbHelper;
    DriverInfoDbHelper driverInfoDbHelper;
    DriverInfoModel dim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_register = findViewById(R.id.btn_register);
        btn_back = findViewById(R.id.btn_back);
        et_reg_name = findViewById(R.id.et_reg_name);
        et_reg_surname = findViewById(R.id.et_reg_surname);
        et_reg_email = findViewById(R.id.et_reg_email);
        et_reg_password = findViewById(R.id.et_reg_password);
        et_reg_confirmPassword = findViewById(R.id.et_reg_confirmPassword);
        et_reg_pnumber = findViewById(R.id.et_reg_pnumber);
        et_reg_carMake = findViewById(R.id.et_reg_carMake);
        et_reg_carModel = findViewById(R.id.et_reg_carModel);




        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = et_reg_email.getText().toString();
                String password = et_reg_password.getText().toString();
                String confirmPassword = et_reg_confirmPassword.getText().toString();
                String phoneNum = et_reg_pnumber.getText().toString();
                Boolean pNumValid = false;
                dbHelper = new DataBaseHelper(RegisterActivity.this);



                // Is phone number numeric?
                for(int i =0;i<phoneNum.length();i++){
                    if(phoneNum.charAt(i) >= '0' && phoneNum.charAt(i) <= '9'){
                        pNumValid = true;
                    }
                    else{
                        pNumValid = false;
                        break;
                    }
                }




                if(email.equals("") || password.equals("") || confirmPassword.equals("")){
                    ErrorDialogMsg("Failed to register","Please fill all mandatory blanks");
                }

                else if(password.equals(confirmPassword)){
                    if(!phoneNum.equals("") && pNumValid != true){
                        ErrorDialogMsg("Failed to register","Phone number only can be numeric.");
                    }
                    else{
                        Boolean checkEmail = dbHelper.checkEmail(email);
                        if(checkEmail == true){
                            DriverModel dm = new DriverModel(-1,et_reg_name.getText().toString(),et_reg_surname.getText().toString(),et_reg_email.getText().toString(),et_reg_password.getText().toString(),et_reg_pnumber.getText().toString(),et_reg_carMake.getText().toString(),et_reg_carModel.getText().toString());
                            Boolean insert = dbHelper.addOne(dm);
                            if(insert==true){
                                addDriverInfo();
                                SuccessfullyRegisteredDialogMsg();
                                ClearFields();
                            }
                            else{
                                ErrorDialogMsg("Failed to register","Error occurred while registering.");
                            }
                        }
                        else{
                            ErrorDialogMsg("Failed to register","E-mail already in use.");
                        }
                    }
                }

                else{
                    ErrorDialogMsg("Failed to register","Password and Confirm Password must match!");
                }



            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenLoginScreen();
            }
        });

    }







    private void OpenLoginScreen(){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    private void ClearFields(){
        et_reg_name.setText("");
        et_reg_surname.setText("");
        et_reg_email.setText("");
        et_reg_password.setText("");
        et_reg_confirmPassword.setText("");
        et_reg_pnumber.setText("");
        et_reg_carMake.setText("");
        et_reg_carModel.setText("");
    }

    private void SuccessfullyRegisteredDialogMsg(){
        AlertDialog dialog = new AlertDialog.Builder(this).setTitle("Successfully registered. ").setMessage("Now you can login with your e-mail and password.").setPositiveButton("CONTINUE",null).show();
        Button positiveBtn = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        positiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenLoginScreen();
            }
        });
    }

    private void ErrorDialogMsg(String title,String message){
        AlertDialog dialog = new AlertDialog.Builder(this).setTitle(title).setMessage(message).setPositiveButton("CONTINUE",null).show();
    }

    private void addDriverInfo(){
        driverInfoDbHelper = new DriverInfoDbHelper(RegisterActivity.this);
        dim = new DriverInfoModel(et_reg_email.getText().toString(),"null","null",-1,"null",-1,-1,"null",0.0f,-1);
        driverInfoDbHelper.addOne(dim);
    }

}