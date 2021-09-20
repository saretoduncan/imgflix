package com.example.imgflix.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imgflix.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
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
@SuppressLint("NonConstantResourceId")
@BindView(R.id.signUpProgressBar)
ProgressBar progressBar;
@SuppressLint("NonConstantResourceId")
@BindView(R.id.edUserName) EditText userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newaccount);
        ButterKnife.bind(this);
        mAuth= FirebaseAuth.getInstance();
        createAuthStateListener();
        signUp.setOnClickListener(this);
        login.setOnClickListener(this);

    }

    private void createAuthStateListener() {
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    Intent intent = new Intent(CreateAccountActivity.this,MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        };
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
      if (view == login) {
          Intent intent= new Intent(CreateAccountActivity.this, LoginActivity.class);
          intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
          startActivity(intent);
          finish();
      }
      if (view == signUp){
         createNewAccount();

      }
    }
    private void createNewAccount(){ //create account method
        final String name = userName.getText().toString().trim();
        final String email = registrationEmail.getText().toString().trim();
        final String password = firstPassword.getText().toString().trim();
        final String passwordConfirmation= confirmPassword.getText().toString().trim();
        boolean profileName = isValidName(name);
        boolean profileEmail = isValidEmail(email);
        boolean profilePassword = isValidPassword(password, passwordConfirmation);
        if(!profileEmail || !profileName || !profilePassword) return;

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, task ->{
                    if(task.isSuccessful()){
                        Log.d(CreateAccountActivity.class.getSimpleName(),"Authentication success");
                    }else {
                        Toast.makeText(CreateAccountActivity.this,"Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    //validation
    private boolean isValidEmail(String email){// email validation
       boolean isCorrectMail = (email!=null && Patterns.EMAIL_ADDRESS.matcher(email).matches());
       if(!isCorrectMail){
           registrationEmail.setError("Please enter valid email");
           return false;
       }

        return true;
    }
    private boolean isValidName(String name){//name validation
        if(name.equals("")){
            userName.setError("please enter your name");
            return false;
        }
        return true;
    }
    private boolean isValidPassword(String password, String confirmationPassword){//password validation
        if(password.length()<6){
            firstPassword.setError("Password too short, please create a password containing at least 6 characters");
            return false;
        } else if(!password.equals(confirmationPassword)){
            confirmPassword.setError("passwords do not match");
            return false;
        }
        return true;
    }
    //.....//
    @Override
    public void onStart(){ //start db listening
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);

    }
    @Override
    public void onStop(){ //stop db listening
        super.onStop();
        if(mAuthListener!=null){
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}