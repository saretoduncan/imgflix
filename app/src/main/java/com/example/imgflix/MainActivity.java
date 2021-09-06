package com.example.imgflix;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
@SuppressLint("NonConstantResourceId")
@BindView(R.id.signUp) TextView signup;
@SuppressLint("NonConstantResourceId")
@BindView(R.id.loginButton) Button loginButton;
@SuppressLint("NonConstantResourceId")
@BindView(R.id.edEmail) EditText email;
@SuppressLint("NonConstantResourceId")
@BindView(R.id.edPassword) EditText password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, NewAccount.class);
                startActivity(intent);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checkValidation = Validation.isEmailAddress(email,true) ;

                String mPassword= password.getText().toString();
                if(mPassword.length()==0){
                    password.setError("password required");
                }
                if(checkValidation && mPassword.length()>0){
                    Intent intent = new Intent(MainActivity.this, DisplayImages.class);
                    Toast.makeText(MainActivity.this, "login success", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
          }
            }
        });
    }
}