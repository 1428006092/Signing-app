package com.example.a14280.signinapp;


import java.util.Calendar;

public class DateUntil {
    public static int GetYear()
    {
        return Calendar.getInstance().get(Calendar.YEAR);
    }
    public  static  int GetMonth()
    {
        return Calendar.getInstance().get(Calendar.MONTH)+1;
    }
    public static int GetCurrentDayOfMonth()
    {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }
    public  static  int GetCurrentDayOfWeek()
    {
        return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
    }
    public static int GetHour()
    {
        return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    }
    public static int GetMinute()
    {
        return Calendar.getInstance().get(Calendar.MINUTE);
    }
    public static int GetSecond()
    {
        return Calendar.getInstance().get(Calendar.SECOND);
    }
}
public static int[][] getDayOfMonthFormat(int year,int month){
    Calendar calendar=Calendar.getInstance();
    calendar.set(year,month-1,1);
    int days[][]=new int[6][7];
    int daysOfFirstWeek=calendar.get(Calendar.DAY_OF_WEEK);
    int daysOfMonth=getDaysOfMonth(year, month);
    int daysOfLastMonth=getLastDaysOfMonth(year,month);
    int dayNum=1;
    int nextDayNum=1;
    for(int i=1;i<days.length;i++)
    {
        for(int j=0;j<days[i].length;j++){
            if(i==0&&j<daysOfFirstWeek-1)
            {
                days[i][j]=daysOfLastMonth-daysOfFirstWeek+2+j ;
            }
            else if(dayNum<=daysOfMonth){
                days[i][j]=dayNum++;
            }else {
                days[i][j]=nextDayNum++;
            }
        }
    }
    return days;
}

    private static int getLastDaysOfMonth(int year, int month) {
    int lastDaysOfMonth=0;
    if(month==1){
        lastDaysOfMonth=getDaysOfMonth(year-1,12);
    }
    else{
        lastDaysOfMonth=getDaysOfMonth(year, month-1);
    }
    return lastDaysOfMonth;
    }

    private static int getDaysOfMonth(int year, int month) {
    switch (month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            return 31;
        case 2:
            if (isLeaper(year)) {
                return 29;
            } else {
                return 28;
            }
        case 4:
        case 6:
        case 9:
        case 11:
            return 30;
    }return -1;

    }

    private static boolean isLeaper(int year) {
    if((year%100!=0&&year%4==0)||year%400==0){
        return true;
    }
    return false;
}
}
