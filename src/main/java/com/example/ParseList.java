package com.example;

import org.apache.avro.generic.GenericData;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONTokener;

import java.util.ArrayList;
import java.util.List;

public class ParseList extends UDF {

    public Integer evaluate(Object obj) {
        List<String> idList= new ArrayList<>();
        try{
            JSONArray jsonArray = new JSONArray(obj.toString());
            if (jsonArray.length()>0){
                for (int i =0;i<jsonArray.length();i++){
                    JSONArray jsonArray1 = (JSONArray)jsonArray.get(i);
                    System.out.println(jsonArray1.toString());
                    if(jsonArray1.length()>0){
                        for(int j=0;j<jsonArray1.length();j++){
                            String id = jsonArray1.getString(j);
                            System.out.println(id);
                            if (!idList.toString().contains(id)){
                                idList.add(id);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idList.size();
    }

    public static void main(String[] args) {
        System.out.println(new ParseList().evaluate(null));
    }
}
