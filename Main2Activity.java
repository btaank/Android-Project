package com.example.bharti.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends Activity {

    LoginDBadapter loginDBadapter;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        loginDBadapter = new LoginDBadapter(this);
        loginDBadapter = loginDBadapter.open();
        btnLogin = (Button) findViewById(R.id.button2);

    }

    public void login(View view) {

        final EditText usrnameOnLoginPage = (EditText) findViewById(R.id.editText);
        final EditText pwdOnLoginPage = (EditText) findViewById(R.id.editText2);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String password = pwdOnLoginPage.getText().toString();
                String userName = usrnameOnLoginPage.getText().toString();

                String storedPassword = loginDBadapter.getSingleEntry(userName);

                if (usrnameOnLoginPage.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Enter username", Toast.LENGTH_SHORT).show();
                } else if (pwdOnLoginPage.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_SHORT).show();
                } else if (password.equals(storedPassword)) {
                    Toast.makeText(getApplicationContext(), "Congrats.Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Main2Activity.this, LogPage.class));
                } else
                    Toast.makeText(getApplicationContext(), "Password not correct.", Toast.LENGTH_SHORT).show();

            }

        });


    }

    public void registering(View v){
        startActivity(new Intent(this,Main3Activity.class));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginDBadapter.close();
    }
}
