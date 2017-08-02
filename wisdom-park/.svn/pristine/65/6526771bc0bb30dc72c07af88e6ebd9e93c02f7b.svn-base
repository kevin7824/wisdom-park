package com.honsin.portal.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public DateUtil() {
        super();
    }
    
    /**
     * @author chuwc 2016-03-23
     * @param date
     * @return "MM月dd日 hh:mm"格式日期
     */
    public static String dateStr(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日 hh:mm");
        String str = format.format(date);
        return str;
    }
    
    /**
     * @author chuwc 2016-03-23
     * @param date
     * @param f
     * @return 自定义日期格式"f"
     */
    public static String dateStr(Date date,String f) {
        SimpleDateFormat format = new SimpleDateFormat(f);
        String str = format.format(date);
        return str;
    }
    
    /**
     * @author chuwc 2016-03-23
     * @param date
     * @return "yyyy-MM-dd"格式日期
     */
    public static String dateStr1(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String str = format.format(date);
        return str;
    }
    
    public static String dateStr2(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String str = format.format(date);
        return str;
    }
    
    /**
     * @author chuwc 2016-03-23
     * @param date
     * @return "yyyyMMddHHmmss"格式日期
     */
    public static String dateStr3(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String str = format.format(date);
        return str;
    }
    
    /**
     * @author chuwc 2016-03-23
     * @param date
     * @return "yyyy-MM-dd HH:mm:ss"格式日期
     */
    public static String dateStr4(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        return str;
    }
    
    /**
     * @author chuwc 2016-03-23
     * @param date
     * @return "yyyy年MM月dd日HH时mm分ss秒"格式日期
     */
    public static String dateStr5(Date date) {
        // 招商贷需求变更 短信时间由12小时改为24小时制 高才 2012/08/12 update start
        // SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        String str = format.format(date);
        return str;
    }
    
    /**
     * 获取当前时间的秒数字符串
     * @author chuwc 2016-03-23
     * @return
     */
    public static String getNowTimeStr(){
        String str=Long.toString(System.currentTimeMillis()/1000 );
        return str;
    }
    
    public static Date getDate(String times) {
        long time = Long.parseLong(times);
        return new Date(time*1000);
    }
    
    /**
     * 获得当前日期与本周日相差的天数
     * @author chuwc 2016-03-23
     * @return
     */
    @SuppressWarnings("unused")
	private static int getMondayPlus() {    
        Calendar cd = Calendar.getInstance();    
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......    
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK)-1;         //因为按中国礼拜一作为第一天所以这里减1    
        if (dayOfWeek == 1) {    
            return 0;    
        } else {    
            return 1 - dayOfWeek;    
        }    
    }    
            
    /**
     * 获得本周一的日期
     * @author chuwc 2016-03-23
     * @return "2016-03-21"
     */
    public static String getMondayOFWeek(Date date){    
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	Calendar c = Calendar.getInstance();
    	c.setTimeInMillis(System.currentTimeMillis());
    	c.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
    	String monday = format.format(c.getTime());
   	  	return monday;
    } 
    
    /**
     * 获取本周日的日期
     * @author chuwc 2016-03-23
     * @return "2016-03-27"
     */
  	public static String getCurrentWeekday(Date date) {    
  		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	Calendar c = Calendar.getInstance();
    	c.setTime(date);
    	c.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
    	if(!date.equals(c.getTime())){
    		c.add(Calendar.DAY_OF_WEEK, 7);
    	}
    	String sunday = format.format(c.getTime());
   	  	return sunday;    
      }    
    
  	/**
     * 获取当前月第一天
     * @author chuwc 2016-03-23
     * @return "2016-03-01 00:00:00"
     */
    public static String getFirstDayOfMonth(){
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
   	  	Calendar c = Calendar.getInstance();   
   	  	c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
	   	c.set(Calendar.HOUR_OF_DAY, 0);
	    c.set(Calendar.SECOND, 0);
	    c.set(Calendar.MINUTE, 0);
   	  	String first = format.format(c.getTime());
   	  	return first;
    }
    
    /**
     * 获取当月最后一天
     * @author chuwc 2016-03-23
     * @return "2016-03-31 23:59:59"
     */
    public static String getLastDayOfMonth(){
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    	Calendar ca = Calendar.getInstance(); 
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH)); 
        ca.set(Calendar.HOUR_OF_DAY, 23);
        ca.set(Calendar.SECOND, 59);
        ca.set(Calendar.MINUTE, 59);
        String last = format.format(ca.getTime());
    	return last;
    }
    
    /**
     * 获取当前日期后加 "00:00:00"
     * @author chuwc 2016-03-23
     * @return "2016-03-23 00:00:00"
     */
    public static Date getFirstTimeOfNow(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        return calendar.getTime();
    }
    
    /**
     * 获取当前日期后加 "23:59:59"
     * @author chuwc 2016-03-23
     * @return "2016-03-23 23:59:59"
     */
    public static Date getLastTimeOfNow(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MINUTE, 59);
        return calendar.getTime();
    }
    
    /**
     * 获取前 n 天
     * @author chuwc 2016-03-23
     * @param type true: 00:00:00   false: 23:59:59
     * @update chuwc 2016-08-15
     */
    public static Date getBeforeNDay(Date date, int n, boolean type) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -n);
        if(type){
        	calendar.set(Calendar.HOUR, 0);
        	calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MINUTE, 0);
        } else {
        	calendar.set(Calendar.HOUR, 23);
        	calendar.set(Calendar.MINUTE, 59);
        	calendar.set(Calendar.SECOND, 59);
        }
        return calendar.getTime();
    }
    
    /**
     * 获取近 n 个月
     * @author chuwc 2016-03-23
     * @param date
     * @return
     */
    public static Date getFBNMonth(Date date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -n);
    	calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        return calendar.getTime();
    }
    
    public static void main(String[] args) throws ParseException {
//		System.out.println(dateStr4(getFirstDayOfLastestNMonth(new Date(), 0)));
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	String dstr = "2016-08-1";
    	Date date = format.parse(dstr);
    	System.out.println(dateStr4(getBeforeNDay(date, 1, true)));
    	System.out.println(dateStr4(getFBNMonth(date, 1)));
	}
}
