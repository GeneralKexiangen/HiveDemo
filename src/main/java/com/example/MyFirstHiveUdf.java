package com.example;

import org.apache.hadoop.hive.ql.exec.UDF;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyFirstHiveUdf extends UDF {


    public String evaluate(String str){
        return "Hello:"+matchConstellation(str);
    }

    private String matchConstellation(String dateStr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String init_year = dateStr.substring(0,4);
        String constellation = null;
        try {
            Date yourDate = simpleDateFormat.parse(dateStr);
            if(yourDate.compareTo(simpleDateFormat.parse(init_year + "-03-21")) >= 0 &&
                    yourDate.compareTo(simpleDateFormat.parse(init_year + "-04-20")) <= 0) {
                constellation = "白羊座";
            }else if(yourDate.compareTo(simpleDateFormat.parse(init_year + "-04-21")) >= 0 &&
                    yourDate.compareTo(simpleDateFormat.parse(init_year + "-05-21")) <= 0) {
                constellation = "金牛座";
            }else if(yourDate.compareTo(simpleDateFormat.parse(init_year + "-05-22")) >= 0 &&
                    yourDate.compareTo(simpleDateFormat.parse(init_year + "-06-21")) <= 0){
                constellation = "双子座";
            }else if(yourDate.compareTo(simpleDateFormat.parse(init_year + "-06-22")) >= 0 &&
                    yourDate.compareTo(simpleDateFormat.parse(init_year + "-07-22")) <= 0){
                constellation = "巨蟹座";
            }else if(yourDate.compareTo(simpleDateFormat.parse(init_year + "-07-23")) >= 0 &&
                    yourDate.compareTo(simpleDateFormat.parse(init_year + "-08-23")) <= 0){
                constellation = "狮子座";
            }else if(yourDate.compareTo(simpleDateFormat.parse(init_year + "-08-24")) >= 0 &&
                    yourDate.compareTo(simpleDateFormat.parse(init_year + "-09-23")) <= 0){
                constellation = "处女座";
            }else if(yourDate.compareTo(simpleDateFormat.parse(init_year + "-09-24")) >= 0 &&
                    yourDate.compareTo(simpleDateFormat.parse( init_year + "-10-23")) <= 0){
                constellation = "天秤座";
            }else if(yourDate.compareTo(simpleDateFormat.parse(init_year + "-10-24")) >= 0 &&
                    yourDate.compareTo(simpleDateFormat.parse(init_year + "-11-22")) <= 0){
                constellation = "天蝎座";
            }else if(yourDate.compareTo(simpleDateFormat.parse(init_year + "-11-23")) >= 0 &&
                    yourDate.compareTo(simpleDateFormat.parse(init_year + "-12-21")) <= 0){
                constellation = "射手座";
            }else if(yourDate.compareTo(simpleDateFormat.parse(init_year + "-12-22")) >= 0 &&
                    yourDate.compareTo(simpleDateFormat.parse(String.valueOf((Integer.parseInt(init_year)+1)) + "-01-20")) <= 0){
                constellation = "摩羯座";
            }else if(yourDate.compareTo(simpleDateFormat.parse(init_year + "-01-21")) >= 0 &&
                    yourDate.compareTo(simpleDateFormat.parse(init_year + "-02-19")) <= 0){
                constellation = "水瓶座";
            }else if(yourDate.compareTo(simpleDateFormat.parse(init_year + "-02-20")) >= 0 &&
                    yourDate.compareTo(simpleDateFormat.parse(init_year + "-03-20")) <= 0){
                constellation = "巨蟹座";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return constellation;
    }

    public static void main(String[] args) {
        System.out.println(new MyFirstHiveUdf().evaluate("1990-03-21"));
    }

}
