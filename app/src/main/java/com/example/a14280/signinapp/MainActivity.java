package com.example.a14280.signinapp;

import android.app.Activity;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{
    private GridView record_gridView;
    private DateAdapter dateAdapter;
    private ImageView record_left;
    private ImageView record_right;
    private TextView record_title;
    private int year;
    private int month;
    private String title;
    private int[][] days = new int[6][7];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        initDate();
        initView();
        initEvent();
    }

    private void initEvent() {
        record_left.setOnClickListener(this);
        record_right.setOnClickListener(this);
    }

    private void initView() {
        record_gridView=(GridView)findViewById(R.id.record_gridView);
        days=DateUtils.getDayOfMonthFormat(2016,8);
        dateAdapter=new DateAdapter(this,days,years,momth);
        record_gridView.setAdapter(dateAdapter);
        record_gridView.setVerticalSpacing(60);
        record_gridView.setEnabled(false);
        record_left=(ImageView)findViewById(R.id.record_left);
        record_right=(ImageView)findViewById(R.id.record_right);
        record_title=(TextView)findViewById(R.id.record_title);
    }
    private int[][] nextMonth()
    {
        if(month==12){
            month=1;
            year++;
        }else{
            month++;
        }
        days=DateUtils.getDayOfMonthFormat(year,month);
        return days;
    }
    private int[][] prevMonth() {
        if (month == 1) {
            month = 12;
            year--;
        } else {
            month--;
        }
        days = DateUtils.getDayOfMonthFormat(year, month);
        return days;
    }

    private void initDate() {
        year= DateUtils.getYear();
        month=DateUtils.getMonth();
    }
    private void setTile() {
        title = year + "年" + month + "月";
        record_title.setText(title);
    }

    @Override
    public void onClick(View v) {
        switch (view.getId()) {
            case R.id.record_left:
                days = prevMonth();
                dateAdapter = new DateAdapter(this, days, year, month);
                record_gridView.setAdapter(dateAdapter);
                dateAdapter.notifyDataSetChanged();
                setTile();
                break;
            case R.id.record_right:
                days = nextMonth();
                dateAdapter = new DateAdapter(this, days, year, month);
                record_gridView.setAdapter(dateAdapter);
                dateAdapter.notifyDataSetChanged();
                setTile();
                break;
        }
    }
    }

