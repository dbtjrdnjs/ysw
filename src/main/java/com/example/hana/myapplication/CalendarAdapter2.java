package com.example.hana.myapplication;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CalendarAdapter2 extends BaseAdapter {
    private ArrayList<DayInfo2> arrayListDayInfo2;
    public Date selectedDate2;

    public CalendarAdapter2(ArrayList<DayInfo2> arrayLIstDayInfo2, Date date) {
        this.arrayListDayInfo2 = arrayLIstDayInfo2;
        this.selectedDate2 = date;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return arrayListDayInfo2.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return arrayListDayInfo2.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DayInfo2 day2 = arrayListDayInfo2.get(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.day2, parent, false);
        }

        if(day2 != null){
            TextView tvDay2 = convertView.findViewById(R.id.day_cell_tv_day2);
            tvDay2.setText(day2.getDay());

            ImageView ivSelected2 = convertView.findViewById(R.id.iv_selected2);
            if(day2.isSameDay(selectedDate2)){
                ivSelected2.setVisibility(View.VISIBLE);
            }else{
                ivSelected2.setVisibility(View.INVISIBLE);
            }

            if(day2.isInMonth()){
                if((position%7 + 1) == Calendar.SUNDAY){
                    tvDay2.setTextColor(Color.RED);
                }else if((position%7 + 1) == Calendar.SATURDAY){
                    tvDay2.setTextColor(Color.BLUE);
                }else{
                    tvDay2.setTextColor(Color.BLACK);
                }
            }else{
                tvDay2.setTextColor(Color.GRAY);
            }
        }
        convertView.setTag(day2);

        return convertView;
    }

}