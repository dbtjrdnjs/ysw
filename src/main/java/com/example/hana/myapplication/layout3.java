package com.example.hana.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class layout3 extends AppCompatActivity {
    Button btnShow, btnShow2;
    Date selectedDate, selectedDate2;
    TextView tvSelectedDate, tvSelectedDate2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout3);

        btnShow = findViewById(R.id.btn_show);
        btnShow2 = findViewById(R.id.btn_show2);
        tvSelectedDate = findViewById(R.id.tv_selected_date);
        tvSelectedDate2 = findViewById(R.id.tv_selected_date2);

        btnShow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                MyGridViewCalendar myGridViewCalendar = new MyGridViewCalendar();
                myGridViewCalendar.setSelectedDate(new Date());
                myGridViewCalendar.show(getSupportFragmentManager(), "grid_view_calendar");
            }
        });

        btnShow2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                MyGridViewCalendar2 myGridViewCalendar2 = new MyGridViewCalendar2();
                myGridViewCalendar2.setSelectedDate2(new Date());
                myGridViewCalendar2.show(getSupportFragmentManager(), "grid_view_calendar2");
            }
        });
    }
}