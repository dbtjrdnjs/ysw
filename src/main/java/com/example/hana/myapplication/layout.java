package com.example.hana.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class layout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        TextView address = (TextView) findViewById(R.id.address);
        EditText detail_addr = (EditText) findViewById(R.id.detail_addr);
        EditText bussiness_name = (EditText) findViewById(R.id.bussiness_name);
        EditText bussiness_tel = (EditText) findViewById(R.id.bussiness_tel);
        EditText bussiness_table = (EditText) findViewById(R.id.bussiness_table);
        EditText bussiness_parking = (EditText) findViewById(R.id.bussiness_parking);
        CheckBox kor_food_cb = (CheckBox) findViewById(R.id.kor_food_cb);
        CheckBox chi_jp_food_cb = (CheckBox) findViewById(R.id.chi_jp_food_cb);
        CheckBox meat_cb = (CheckBox) findViewById(R.id.meat_cb);
        CheckBox cafe_cb = (CheckBox) findViewById(R.id.cafe_cb);
        CheckBox hof_cb = (CheckBox) findViewById(R.id.hof_cb);
        CheckBox chicken_cb = (CheckBox) findViewById(R.id.chicken_cb);
        CheckBox sashimi_cb = (CheckBox) findViewById(R.id.sashimi_cb);
        Button img_btn = (Button) findViewById(R.id.img_btn);

        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 이미지 업로드 페이지 이동
            }
        });

        kor_food_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CheckBox)view).isChecked()) {
                    // 체크
                } else {
                    // 언체크
                }
            }
        });

        chi_jp_food_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CheckBox)view).isChecked()) {
                    // 체크
                } else {
                    // 언체크
                }
            }
        });
        meat_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CheckBox)view).isChecked()) {
                    // 체크
                } else {
                    // 언체크
                }
            }
        });
        cafe_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CheckBox)view).isChecked()) {
                    // 체크
                } else {
                    // 언체크
                }
            }
        });
        hof_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CheckBox)view).isChecked()) {
                    // 체크
                } else {
                    // 언체크
                }
            }
        });
        chicken_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CheckBox)view).isChecked()) {
                    // 체크
                } else {
                    // 언체크
                }
            }
        });
        sashimi_cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (((CheckBox)view).isChecked()) {
                    // 체크
                } else {
                    // 언체크
                }
            }
        });
    }
}