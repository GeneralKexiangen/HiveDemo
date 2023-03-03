package com.example;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.codehaus.jettison.json.JSONArray;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ChoiceDs extends UDF {

    public String evaluate(String ds) {
        List<String> dsList= new ArrayList<>();
        try{
            for(int i=1;i<=12;i++){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                Calendar c = Calendar.getInstance();
                c.setTime(sdf.parse(ds));
                c.add(Calendar.MONTH, -i);
                Date m = c.getTime();
//                System.out.println(sdf.format(m));
                dsList.add(sdf.format(m));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsList.toString().replace("[","").replace("]","");
    }

    public static void main(String[] args) {
        System.out.println(new ChoiceDs().evaluate("20220531"));
    }
}
