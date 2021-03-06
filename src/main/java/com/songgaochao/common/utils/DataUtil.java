package com.songgaochao.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * @ClassName:  DataUtil   
 * @Description:日期工具类    
 * @date:   2020年1月3日 上午9:06:21
 */
public class DataUtil {
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * @Title: format   
	 * @Description: 格式化日期   
	 * @param: @param theDate
	 * @param: @param format
	 * @param: @return
	 * @param: @throws ParseException      
	 * @return: String      
	 * @throws
	 */
	public static String format(Date theDate,String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(theDate);
	}
	/**
	 * @Title: parse   
	 * @Description: 解析日期   
	 * @param: @param theDateStr
	 * @param: @param format
	 * @param: @return      
	 * @return: Date      
	 * @throws
	 */
	public static Date parse(String theDateStr,String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		try {
			return simpleDateFormat.parse(theDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @Title: getAge   
	 * @Description: 根据指定日期计算年龄  
	 * @param: @param theDate
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public static int getAge(Date theDate) {
		/** 获取当前日期的年月日 **/
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		/** 获取生日的年月日 **/
		calendar.setTime(theDate);
		int theYear = calendar.get(Calendar.YEAR);
		int theMonth = calendar.get(Calendar.MONTH);
		int theDay = calendar.get(Calendar.DAY_OF_MONTH);
		/** 年龄 **/
		int age = year-theYear;
		/** 判断月份 **/
		if(month<theMonth) {
			age--;
		}
		/** 判断日期 **/
		if(month==theMonth && day<theDay) {
			age--;
		}
		return age;
	}
	/**
	 * @Title: getAge   
	 * @Description: 根据指定日期计算年龄   
	 * @param: @param theDateStr
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public static int getAge(String theDateStr) {
		Date theDate = parse(theDateStr, "yyyy-MM-dd");
		return getAge(theDate);
	}
	/**
	 * @Title: getDayNum   
	 * @Description: 求两个时间之间的天数
	 * @param: @param date1
	 * @param: @param date2
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public static int getDayNum(Date date1,Date date2) {
		int dayTime = 1000*60*60*24;
		Long time1 = date1.getTime();
		Long time2 = date2.getTime();
		Long abs = Math.abs(time1-time2);
		Double dayNumDouble = abs/dayTime*1.0;
		return dayNumDouble.intValue();
	}
	/**
	 * @Title: getDayNum   
	 * @Description: 求两个时间之间的天数   
	 * @param: @param date1Str
	 * @param: @param date2Str
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public static int getDayNum(String date1Str,String date2Str) {
		Date date1 = parse(date1Str, "yyyy-MM-dd");
		Date date2 = parse(date2Str, "yyyy-MM-dd");
		return getDayNum(date1,date2);
	}
	/**
	 * @Title: getDayNum   
	 * @Description: 未来或过去距离现在还有多少天   
	 * @param: @param date1Str
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public static int getDayNum(String date1Str) {
		Date date1 = new Date();
		Date date2 = parse(date1Str, "yyyy-MM-dd");
		return getDayNum(date1,date2);
	}
	/**
	 * @Title: compare   
	 * @Description: 0-相等
					1- date1大于date2
					-1 date1小于date2   
	 * @param: @param date1
	 * @param: @param date2
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static int compare(Date date1,Date date2) {
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		if(time1==time2) {
			return 0;
		}
		if(time1>time2) {
			return 1;
		}
		return -1;
	}
	/**
	 * @Title: inWeek   
	 * @Description: 判断给定的日期是否在本周之内   
	 * @param: @param theDate
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public static boolean inWeek(Date theDate) {
		Calendar calendar = Calendar.getInstance();
		int theDay = calendar.get(Calendar.DAY_OF_WEEK);
		/** 当前周到第一天 **/
		calendar.set(Calendar.DAY_OF_WEEK, 1-theDay);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date startDate = calendar.getTime();
		/** 当前周到最后一天 **/
		calendar.add(Calendar.DAY_OF_WEEK, 6);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		Date endDate = calendar.getTime();
		return compare(theDate,startDate)==1 && compare(endDate, theDate)==1;
	}
	/**
	 * @Title: inWeek   
	 * @Description: 判断给定的日期是否在本周之内  
	 * @param: @param theDateStr
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean inWeek(String theDateStr) {
		Date theDate = parse(theDateStr, "yyyy-MM-dd");
		return inWeek(theDate);
	}
	/**
	 * @Title: inMonth   
	 * @Description: 判断指定日期是否在本月   
	 * @param: @param theDate
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean inMonth(Date theDate) {
		Date nowDate = new Date();
		String nowYyyymm = format(nowDate, "yyyy-MM");
		String theYyyymm = format(theDate, "yyyy-MM");
		return nowYyyymm.equals(theYyyymm);
	}
	/**
	 * @Title: inMonth   
	 * @Description: 判断指定日期是否在本月   
	 * @param: @param theDateStr
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public static boolean inMonth(String theDateStr) {
		Date theDate = parse(theDateStr, "yyyy-MM-dd");
		return inMonth(theDate);
	}
	
	/**
	 * @Title: getFirstDayOfMonth   
	 * @Description: 获取指定日期月的结束的时间  
	 * @param: @param theDate
	 * @param: @return      
	 * @return: Date      
	 * @throws
	 */
	public static Date getFirstDayOfMonth(Date theDate) {
		String theDateStr = format(theDate, "yyyy-MM-01");
		return parse(theDateStr, "yyyy-MM-dd");
	}
	/**
	 * @Title: getFirstDayOfMonth   
	 * @Description: 获取指定日期月的第一天    
	 * @param: @param theDateStr
	 * @param: @return      
	 * @return: Date      
	 * @throws
	 */
	public static Date getFirstDayOfMonth(String theDateStr) {
		Date theDate = parse(theDateStr, "yyyy-MM-dd");
		return getFirstDayOfMonth(theDate);
	}
	/**
	 * @Title: getLastDayOfMonth   
	 * @Description: 获取指定日期月份结束的时间
	 * @param: @param theDate
	 * @param: @return      
	 * @return: Date      
	 * @throws
	 */
	public static Date getLastDayOfMonth(Date theDate) {
		/** 取当月的第一天 **/
		Date firstDayOfMonth = getFirstDayOfMonth(theDate);
		/** 实例化日历控件 **/
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(firstDayOfMonth);
		/** 下月1号 **/
		calendar.add(Calendar.MONTH, 1);
		/** 减1秒，上月的最后日期 **/
		calendar.add(Calendar.SECOND, -1);
		return calendar.getTime();
	}
	/**
	 * @Title: getLastDayOfMonth   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param theDateStr
	 * @param: @return      
	 * @return: Date      
	 * @throws
	 */
	public static Date getLastDayOfMonth(String theDateStr) {
		Date theDate = parse(theDateStr, "yyyy-MM-dd HH:mm:ss");
		return getLastDayOfMonth(theDate);
	}
	/**
	 * @Title: getRandomDate   
	 * @Description: 获取随机时间 
	 * @param: @param date1
	 * @param: @param date2
	 * @param: @return      
	 * @return: Date      
	 * @throws
	 */
	public static Date getRandomDate(Date date1,Date date2) {
		Long randomLong = Math.abs(date1.getTime()-date2.getTime());
		long random = (long) (randomLong*Math.random());
		long newDateLong = compare(date1, date2)==1?date2.getTime()+random:date1.getTime()+random;
		return new Date(newDateLong);
	}
	
	 //把传入的日期向前 推减24 个小时。 即 1天
		public static Date subDate(Date date) {
			//用当前系统时间去实例化一个日历类
			Calendar c = Calendar.getInstance();
			//用传入的日期示例化日历类
			c.setTime(date);
			
			//借助日历类，减去1天
			c.add(Calendar.DATE, -1);
			
			return c.getTime();
			
		}
		
		 /**
	       * 
	       * @Title: randomDate 
	       * @Description: 随机返回一个在start--end 之间的日期
	       * @param start
	       * @param end
	       * @return
	       * @return: Date
	       */
		public static Date randomDate(Date start,Date end) {
			//获取开始日期的毫秒数
			long t1 = start.getTime();
			//获取结束日期的毫秒数
			long t2 = end.getTime();
			
			long t =(long) ((Math.random() * (t2-t1)+1) +t1);
			
			return new Date(t);
		}

	
	public static void main(String[] args) {
	
		
		
		//随机获取时间
		Date date1= parse("2010-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
		Date date2 = new Date();
		Date randomDate = getRandomDate(date1, date2);		
		System.out.println(format(randomDate, "yyyy-MM-dd HH:mm:ss"));
		
		//根据时间算年龄
		int age = getAge("1998-2-2");
		//System.out.println(age);
		
		//根据两个时间算天数
		int dayNum = getDayNum("2018-3-2", "2019-2-3");
		//System.out.println(dayNum);
		
		
	}

}
