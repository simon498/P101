package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class SignIn extends AppCompatActivity {

    private static final int SPLASH_SCREEN = 5000;

    Button siGnin, loGin;

    TextInputLayout firstName, lastName, eMail, userName, passWord, coUntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_in);

        firstName = findViewById(R.id.first_nameEditText);
        lastName = findViewById(R.id.last_nameEditText);
        eMail = findViewById(R.id.emailEditText);
        userName = findViewById(R.id.usernameEditText);
        passWord = findViewById(R.id.passwordEditText);
        coUntry = findViewById(R.id.countryEditText);
        siGnin = findViewById(R.id.sign_inButton);
        loGin = findViewById(R.id.sign_loginButton);


        siGnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignIn.this, Dashboard.class);
                startActivity(intent);
                finish();
            }
        });
        loGin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignIn.this, Logn.class);
                startActivity(intent);
                finish();
            }
        });
    }
        private Boolean validateFirstname(){
            String val = firstName.getEditText().getText().toString().trim();

            if (val.isEmpty()){
                firstName.setError("Field can not be empty");
                return false;
            }
            else{
                firstName.setError(null);
                firstName.setEnabled(false);
                return true;
            }

        }
        private Boolean validateLastname(){
            String val = lastName.getEditText().getText().toString().trim();

            if (val.isEmpty()){
                lastName.setError("Field can not be empty");
                return false;
            }
            else{
                lastName.setError(null);
                lastName.setEnabled(false);
                return true;
            }

        }
        private Boolean validateEmail(){
            String val = eMail.getEditText().getText().toString().trim();
            String checkemail = "[a-zA=Z0-9._-]+@[a-z]\\.+[a-z]+";

            if (val.isEmpty()){
                eMail.setError("Field can not be empty");
                return false;
            } else if (!val.matches(checkemail)){
                eMail.setError("invalid Email");
                return false;
            }
            else{
                eMail.setError(null);
                eMail.setEnabled(false);
                return true;
            }

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
        private Boolean validateCountry(){
            String val = coUntry.getEditText().getText().toString().trim();

            if (val.isEmpty()){
                coUntry.setError("Field can not be empty");
                return false;
            }
            else{
                coUntry.setError(null);
                coUntry.setEnabled(false);
                return true;
            }

        }

}

