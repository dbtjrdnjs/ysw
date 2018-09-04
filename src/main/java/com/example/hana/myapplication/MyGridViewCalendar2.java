package com.example.hana.myapplication;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MyGridViewCalendar2 extends DialogFragment {

    private TextView tvCalendarTitle2;
    private TextView tvSelectedDate2;
    private GridView gvCalendar2;

    private ArrayList<DayInfo2> arrayListDayInfo2;
    Calendar mThisMonthCalendar2;
    CalendarAdapter2 mCalendarAdapter2;
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd(EEE)", Locale.getDefault());
    Date selectedDate2;

    public void setSelectedDate2(Date date){
        selectedDate2 = date;

        if(mCalendarAdapter2 != null) {
            mCalendarAdapter2.selectedDate2 = date;
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View dialog = inflater.inflate(R.layout.grid_view_calendar2, null, false);

        Button btnPreviousCalendar2 = dialog.findViewById(R.id.btn_previous_calendar2);
        Button btnNextCalendar2 = dialog.findViewById(R.id.btn_next_calendar2);

        tvCalendarTitle2 = dialog.findViewById(R.id.tv_calendar_title2);
        tvSelectedDate2 = dialog.findViewById(R.id.tv_selected_date2);
        gvCalendar2 = dialog.findViewById(R.id.gv_calendar2);

        btnPreviousCalendar2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mThisMonthCalendar2.add(Calendar.MONTH, -1);

                getCalendar(mThisMonthCalendar2.getTime());
            }
        });
        btnNextCalendar2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mThisMonthCalendar2.add(Calendar.MONTH, +1);

                getCalendar(mThisMonthCalendar2.getTime());
            }
        });

        gvCalendar2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                  setSelectedDate2(((DayInfo2)view.getTag()).getDate());

                  tvSelectedDate2.setText(sdf2.format(mCalendarAdapter2.selectedDate2));

                  mCalendarAdapter2.notifyDataSetChanged();
              }
        });

        Button btnConfirm2 = dialog.findViewById(R.id.btn_confirm2);
        Button btnCancel2 = dialog.findViewById(R.id.btn_cancel2);

        btnConfirm2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                MyGridViewCalendar2.this.getDialog().cancel();
                ((layout3)getActivity()).selectedDate2 = selectedDate2;
                ((layout3)getActivity()).tvSelectedDate2.setText(sdf2.format(selectedDate2));
            }
        });

        btnCancel2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                MyGridViewCalendar2.this.getDialog().cancel();
            }
        });

        arrayListDayInfo2 = new ArrayList<>();

        builder.setView(dialog);
        return builder.create();
    }

    @Override
    public void onResume() {
        super.onResume();

        mThisMonthCalendar2 = Calendar.getInstance();
        getCalendar(mThisMonthCalendar2.getTime());
    }

    private void getCalendar(Date dateForCurrentMonth){
        int dayOfWeek;
        int thisMonthLastDay;

        arrayListDayInfo2.clear();

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(dateForCurrentMonth);

        calendar2.set(Calendar.DATE, 1);//1일로 변경
        dayOfWeek = calendar2.get(Calendar.DAY_OF_WEEK);//1일의 요일 구하기
        Log.d("CalendarTest", "dayOfWeek = " + dayOfWeek+"");

        if(dayOfWeek == Calendar.SUNDAY){ //현재 달의 1일이 무슨 요일인지 검사
            dayOfWeek += 7;
        }

        thisMonthLastDay = calendar2.getActualMaximum(Calendar.DAY_OF_MONTH);

        setCalendarTitle();

        DayInfo2 day2;

        calendar2.add(Calendar.DATE, -1*(dayOfWeek-1)); //현재 달력화면에서 보이는 지난달의 시작일
        for(int i=0; i<dayOfWeek-1; i++){
            day2 = new DayInfo2();
            day2.setDate(calendar2.getTime());
            day2.setInMonth(false);
            arrayListDayInfo2.add(day2);

            calendar2.add(Calendar.DATE, +1);
        }

        for(int i=1; i <= thisMonthLastDay; i++){
            day2 = new DayInfo2();
            day2.setDate(calendar2.getTime());
            day2.setInMonth(true);
            arrayListDayInfo2.add(day2);

            calendar2.add(Calendar.DATE, +1);
        }

        for(int i=1; i<42-(thisMonthLastDay+dayOfWeek-1)+1; i++) {
            day2 = new DayInfo2();
            day2.setDate(calendar2.getTime());
            day2.setInMonth(false);
            arrayListDayInfo2.add(day2);

            calendar2.add(Calendar.DATE, +1);
        }

        mCalendarAdapter2 = new CalendarAdapter2(arrayListDayInfo2, selectedDate2);
        gvCalendar2.setAdapter(mCalendarAdapter2);

        tvSelectedDate2.setText(sdf2.format(selectedDate2));
    }

    private void setCalendarTitle(){
        StringBuilder sb2 = new StringBuilder();

        sb2.append(mThisMonthCalendar2.get(Calendar.YEAR))
                .append("년 ")
                .append((mThisMonthCalendar2.get(Calendar.MONTH) + 1))
                .append("월");
        tvCalendarTitle2.setText(sb2.toString());
    }
}
