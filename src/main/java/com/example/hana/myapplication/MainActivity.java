package com.example.hana.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button btnShow;
    Date selectedDate;
    TextView tvSelectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button member_btn = (Button) findViewById(R.id.member_btn);
        Button login_btn = (Button) findViewById(R.id.login_btn);
        Button btn = (Button) findViewById(R.id.btn);
        Button btn2 = (Button) findViewById(R.id.btn2);

        EditText id_et = (EditText) findViewById(R.id.Id_Input);
        EditText pw_et = (EditText) findViewById(R.id.Pw_Input);
        CheckBox cb = (CheckBox) findViewById(R.id.auto_login_cb);


/*        member_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 회원가입 페이지 이동
            }
        });*/

        login_btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), layout.class);
                startActivity(intent);
            }
        });

        member_btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), membership.class);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), layout3.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), layout4.class);
                startActivity(intent);
            }
        });

/*
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CheckBox)view).isChecked()) {
                    // 체크
                } else {
                    // 언체크
                }
            }
        });
        */
    }
}