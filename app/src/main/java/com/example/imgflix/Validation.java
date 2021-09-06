package com.example.imgflix;
import java.lang.reflect.Parameter;
import java.util.regex.Pattern;

import android.widget.EditText;

public class Validation {

    private static final String EMAIL_REGEX="(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";


    //error messge
    private static  final String REQUIRED_MSG = "required";
    private static final String EMAIL_MSG = "invalid email";

    //call to check mail
  public static boolean isValid(EditText editText, String regex, String errMsg, boolean required){
      String text = editText.getText().toString().trim();
      editText.setError(null);
      if(required && !hasText(editText))return false;
      if(required && !Pattern.matches(regex, text)){
          editText.setError(errMsg);
          return false;
      }
      return true;
  }
  //check input field has any text or not
    public  static boolean hasText(EditText editText){
        String text =editText.getText().toString().trim();
        editText.setError(null);
        if(text.length()==0){
            editText.setError(REQUIRED_MSG);
            return false;

        }
        return true;
    }
    //check email verification
    public static boolean isEmailAddress(EditText editText, boolean required){
      return isValid(editText, EMAIL_REGEX, EMAIL_MSG, required);
    }
    //check passcode


}
