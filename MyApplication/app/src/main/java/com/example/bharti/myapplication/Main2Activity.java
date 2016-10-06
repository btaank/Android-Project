package com.example.bharti.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.example.bharti.myapplication.R.id.start;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }



    public void logged(View view){

        EditText usrname = (EditText) findViewById(R.id.editText);
        EditText pwd = (EditText) findViewById(R.id.editText2);
        if(usrname.length()== 0) {
            Toast.makeText(getApplicationContext(), "Enter username", Toast.LENGTH_SHORT).show();

        }
        else if(pwd.length()== 0) {
            Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_SHORT).show();

        }
        else
            startActivity(new Intent(this, LogPage.class));
    }

    public void registering(View v){
        startActivity(new Intent(this,Main3Activity.class));

    }
}
