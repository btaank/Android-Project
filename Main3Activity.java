package com.example.bharti.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.bharti.myapplication.R.id.button4;

public class Main3Activity extends Activity {

    public static final String name = "usernameKey";
    public static final String pwd = "passwordKey";
    LoginDBadapter loginDBadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        loginDBadapter = new LoginDBadapter(this);
        loginDBadapter = loginDBadapter.open();

    }
    public void register(View view){
        EditText username = (EditText) findViewById(R.id.editText9) ;
        EditText password = (EditText) findViewById(R.id.editText10) ;
        EditText cPassword = (EditText) findViewById(R.id.editText11) ;
        EditText email = (EditText) findViewById(R.id.editText12) ;
        EditText phn = (EditText) findViewById(R.id.editText13) ;
        RadioButton female = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton male = (RadioButton) findViewById(R.id.radioButton4);

        String userName = username.getText().toString();
        String pwd = password.getText().toString();
        String cpwd = cPassword.getText().toString();
        String eMail = email.getText().toString();
        String phone = phn.getText().toString();

      //  String existedUsername = loginDBadapter.getUsername();

        if((username.length()==0) || (password.length()==0) || (cPassword.length() == 0) ||
                (email.length()==0) || (phn.length()==0)) {
            Toast.makeText(getApplicationContext(),"Field is empty",Toast.LENGTH_SHORT).show();
        }
    /*    else if(userName.equals(existedUsername)){
            Toast.makeText(getApplicationContext(), "This username already exist. Please choose a new username", Toast.LENGTH_SHORT).show();
        }
    */    else if(!(cpwd.equals(pwd))) {
            Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
        }
        else if (!(android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches())){
            Toast.makeText(getApplicationContext(),"Email not valid",Toast.LENGTH_SHORT).show();
        }
        else if (phn.length()!=10){
            Toast.makeText(getApplicationContext(),"Phone number not valid. Enter 10 digit phone number",Toast.LENGTH_SHORT).show();
        }
        else if (!(female.isChecked() || male.isChecked())){
            Toast.makeText(getApplicationContext(),"gender not selected",Toast.LENGTH_SHORT).show();
        }
        else {
            loginDBadapter.insertEntry(userName, pwd,eMail,phone);
            startActivity(new Intent(this, Main2Activity.class));
            Toast.makeText(getApplicationContext(),"Successfully added. Login now",Toast.LENGTH_SHORT).show();



                }

        }
    }
