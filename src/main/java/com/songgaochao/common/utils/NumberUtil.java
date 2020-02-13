package com.songgaochao.common.utils;

import java.text.DecimalFormat;

public class NumberUtil {

	//根据两个数的和算出百分比
	
	public static String getPercent(float a,float b) {
		DecimalFormat df = new DecimalFormat("#");
	    return df.format(Float.valueOf((a/b))*100)+"%";		
	}
	
	public static void main(String[] args) {
		String percent = getPercent(51,68);
		System.out.println(percent);
	}
}
