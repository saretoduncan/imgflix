package com.example.imgflix;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewAccount extends AppCompatActivity {
@SuppressLint("NonConstantResourceId")
@BindView(R.id.signUpButton) TextView signUp;
@SuppressLint("NonConstantResourceId")
@BindView(R.id.edRegMail) EditText registrationEmail;
@SuppressLint("NonConstantResourceId")
@BindView(R.id.first_attempt) EditText firstPassword;
@SuppressLint("NonConstantResourceId")
@BindView(R.id.second_attempt) EditText confirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newaccount);
        ButterKnife.bind(this);
        signUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
            boolean validateEmail= Validation.isEmailAddress(registrationEmail, true);
            if(firstPassword.length()==0){
                firstPassword.setText("required");
            }
            if (confirmPassword.length()==0){
                confirmPassword.setError("required");
            }
            if(!confirmPassword.getText().toString().equals(firstPassword.getText().toString())){
                confirmPassword.setError("password do not match");
            }
            if(validateEmail&&confirmPassword.getText().toString().equals(firstPassword.getText().toString())) {
                Intent intent = new Intent(NewAccount.this, MainActivity.class);
                Toast.makeText(NewAccount.this, "signup successful", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
            }
        });
    }
}