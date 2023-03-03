package com.example;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DayofYear extends UDF {

    public Integer evaluate(String str){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int i = 0;
        try{
            Date date = simpleDateFormat.parse(str);
            Calendar ca = Calendar.getInstance();
            ca.setTime(date);
            i = ca.get(Calendar.DAY_OF_YEAR);
            System.out.println(i);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new DayofYear().evaluate("2021-03-21"));
    }
}
