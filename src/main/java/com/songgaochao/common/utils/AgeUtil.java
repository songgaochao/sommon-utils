package com.songgaochao.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//根据所给的日期算出年龄

public class AgeUtil {
	private static int getAgeByBirth(Date birthday) {
        int age = 0;
        try {
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());// 当前时间

            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday);

            if (birth.after(now)) {//如果传入的时间，在当前时间的后面，返回0岁
                age = 0;
            } else {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
            }
            return age;
        } catch (Exception e) {//兼容性更强,异常后返回数据
           return 0;
        }
    }

public static int getAgeUtli(String date) {
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Date bithday = null;
	try {
		bithday = format.parse(date);
	} catch (ParseException e) {
		e.printStackTrace();
	}
    int age = getAgeByBirth(bithday);   
    return age;
}

public static void main(String[] args) {
	AgeUtil ageUtil = new AgeUtil();
	
	@SuppressWarnings("static-access")
	int ageUtli = ageUtil.getAgeUtli("1997-2-24");
	System.out.println(ageUtli);
}
}
