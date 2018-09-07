package com.example.abdulrahman.tabingifts.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

// This class to convert BigDecimal to string or float
public class BigDecimalUtil {
    //Convert to string
    public static String getValue(BigDecimal bigDecimal){
        DecimalFormat df = new DecimalFormat("##,##,##,00");
        return String.valueOf(df.format(bigDecimal));
    }
    //Convert to float .. to use in action bar .
    public static float getFloat(BigDecimal bigDecimal){
        return bigDecimal.floatValue();
    }

}
