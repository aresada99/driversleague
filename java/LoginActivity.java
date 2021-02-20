package com.example.driverleague;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
* notepad++ indir
* Toast msg yerine pop-up
* push notifications
* loginden sonra geri gidilmesin
* */

public class LoginActivity extends AppCompatActivity {


    TextView click_signup;
    EditText et_email,et_pw;
    Button btn_login;
    DataBaseHelper dbHelper;

    ////
    public static String loggedInMail;
    ////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        click_signup = findViewById(R.id.tw_signup);
        et_email = findViewById(R.id.et_email);
        et_pw = findViewById(R.id.et_pw);
        btn_login = findViewById(R.id.btn_login);
        dbHelper = new DataBaseHelper(LoginActivity.this);

        SpannableString ss = new SpannableString(click_signup.getText());

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                OpenRegisterScreen();
                ClearFields();
            }
        };

        ss.setSpan(clickableSpan1,0,7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        click_signup.setText(ss);
        click_signup.setMovementMethod(LinkMovementMethod.getInstance());

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = et_email.getText().toString();
                String password = et_pw.getText().toString();
/*                int driver_id;*/
                boolean checkEmailPass = dbHelper.checkEmailPassword(email,password);
                if(checkEmailPass==true){
                    loggedInMail = email;
                    OpenMainScreen();
                    ClearFields();

                }
                else{
                    LoginFailedDialogMsg();
                }


            }
        });

    }



    private void OpenRegisterScreen(){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    private void OpenMainScreen(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void ClearFields(){
        et_email.setText("");
        et_pw.setText("");
    }

    private void LoginFailedDialogMsg(){
        AlertDialog dialog = new AlertDialog.Builder(this).setTitle("Login failed").setMessage("Wrong e-mail or password.").setPositiveButton("CONTINUE",null).show();

    }




}