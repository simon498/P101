package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.WindowManager;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.security.KeyStore;
import java.util.Calendar;

public class Logn extends AppCompatActivity {

    private static final int SPLASH_SCREEN = 5000;

    TextInputLayout userName, passWord;
    Button loGin, siGnin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_logn);

        userName = findViewById(R.id.usernameEditText);
        passWord = findViewById(R.id.passwordEditText);
        loGin = findViewById(R.id.loginButton);
        siGnin = findViewById(R.id.login_signButton);

        loGin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Logn.this, Dashboard.class);
                startActivity(intent);
                finish();
            }
        });

        siGnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Logn .this, SignIn.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private Boolean validateUsername(){
        String val = userName.getEditText().getText().toString().trim();
        String checkspaces = "\\A\\w{1,15}\\z";

        if (val.isEmpty()){
            userName.setError("Field can not be empty");
            return false;
        } else if (val.length()>15){
            userName.setError("Username is too long!!");
            return false;
        } else if (!val.matches(checkspaces)){
            userName.setError("No white spaces are allowed");
            return false;
        }
        else{
            userName.setError(null);
            userName.setEnabled(false);
            return true;
        }

    }
    private Boolean validatePassword(){
        String val = passWord.getEditText().getText().toString().trim();
        String checkpassword = "^" +"(?=.*[0-9])"+"(?=.*[a-z])"+"(?=.*[A-Z])"+ "(?=.*[a-zA-Z])" + "(?=.*[@#$%^&+=])"+"(?=\\s+$)"+".(6,)"+"$";

        if (val.isEmpty()){
            passWord.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkpassword)){
            passWord.setError("Password is too weak");
            return false;
        }
        else{
            passWord.setError(null);
            passWord.setEnabled(false);
            return true;
        }
    }
}