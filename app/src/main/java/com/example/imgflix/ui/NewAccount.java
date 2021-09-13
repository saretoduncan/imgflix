package com.example.imgflix.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imgflix.R;
import com.example.imgflix.Validation;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewAccount extends AppCompatActivity implements View.OnClickListener {
@SuppressLint("NonConstantResourceId")
@BindView(R.id.signUpButton) TextView signUp;
@SuppressLint("NonConstantResourceId")
@BindView(R.id.edRegMail) EditText registrationEmail;
@SuppressLint("NonConstantResourceId")
@BindView(R.id.first_attempt) EditText firstPassword;
@SuppressLint("NonConstantResourceId")
@BindView(R.id.second_attempt) EditText confirmPassword;
@SuppressLint("NonConstantResourceId")
@BindView(R.id.log_in) TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newaccount);
        ButterKnife.bind(this);
        signUp.setOnClickListener(this);
        login.setOnClickListener(this);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
      if(view.getId()==signUp.getId()){
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
      } else if (view.getId() == login.getId()) {
          Intent intent= new Intent(NewAccount.this, MainActivity.class);
          startActivity(intent);
      }
    }
}