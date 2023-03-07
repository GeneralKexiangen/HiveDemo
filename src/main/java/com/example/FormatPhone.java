package com.example;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hive.ql.exec.UDF;
import java.util.regex.Pattern;

public class FormatPhone extends UDF {

    public String evaluate(String phone) {
        if (StringUtils.isBlank(phone)){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = phone.length();
        for (int i = 0; i < length; i++) {
            String subStr = phone.substring(i, i + 1);
            if (isNumeric(subStr)||subStr.equals("-")) {  //如果这个字符是数字，则保存在sb中。
                sb.append(subStr);
            } else {
                continue;
            }
        }
        if (sb.toString().contains("-")){
            String[] phones = sb.toString().split("-");
            if (phones[0].length()<3){
                if (phones.length>1) {
                    sb = new StringBuilder(phones[1]);
                }else {
                    sb = new StringBuilder("");
                }
            } else if(phones[0].length()==11){
                sb = new StringBuilder(phones[0]);
            }
        }

        return sb.toString();

    }

    /**
     * 判断是否是数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) { //可以正常使用

        Pattern pattern = Pattern.compile("[0-9]*");

        return pattern.matcher(str).matches();

    }



    public static void main(String[] args) {
        System.out.println(new FormatPhone().evaluate("010-13487082762"));
    }

}
