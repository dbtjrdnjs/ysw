package com.example.hana.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;


public class membership extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.membership);


        EditText email = (EditText) findViewById(R.id.email_text);
        EditText pw = (EditText) findViewById(R.id.password_text);
        EditText pwcheck = (EditText) findViewById(R.id.passwordcheck_text);
        EditText tel = (EditText) findViewById(R.id.tel_text);
        EditText address = (EditText) findViewById(R.id.address_text);
        EditText simple = (EditText) findViewById(R.id.simple_text);
    }
}