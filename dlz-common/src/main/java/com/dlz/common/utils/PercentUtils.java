package com.dlz.common.utils;

import java.text.NumberFormat;

public class PercentUtils {

    public static String getPercentFormat(double d,int IntegerDigits,int FractionDigits){
        NumberFormat nf = java.text.NumberFormat.getPercentInstance();
        nf.setMaximumIntegerDigits(IntegerDigits);//小数点前保留几位
        nf.setMinimumFractionDigits(FractionDigits);// 小数点后保留几位
        String str = nf.format(d);
        return str;
    }

}
