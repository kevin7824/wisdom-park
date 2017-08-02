package com.honsin.portal.common.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

/**
 * 服务通用的工具类
 * @author wdc
 *
 */

public class CommonUtils {
	
	private static Logger logger = LoggerFactory.getLogger(CommonUtils.class);
	
	/**
	 * 获取当前日期+4位随机数的随机字符串(18位)
	 * @return
	 */
	public static String getRandomStr(){
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timestr = sdf.format(new Date());
		sb.append(timestr);
		try{
			sb.append(String.valueOf(new Random().nextDouble()).substring(6, 10));
		}catch(Exception e){
			sb.append(String.valueOf(new Random().nextDouble()).substring(6, 10));
		}
		return sb.toString();
	}
	
	/**
	 * 获取num个长度的随机数字串
	 * @param num
	 * @return
	 */
	public static String getRandomStr(int num) {
		StringBuffer sb = new StringBuffer();
		Random ran = new Random();
		for(int i=0; i<num; i++) {
			int m = (int) (ran.nextFloat()*9);
			sb.append(m);
		}
		return sb.toString();
	}
	
	/**
	 * 根据偏移量和页面数据条数获取分页区间
	 * @param offset		页面偏移量
	 * @param pagesize		页面数据条数
	 * @param param			参数map
	 * @return
	 */
	public static void setSplitRange(Integer offset, Integer pagesize, Map<String, Object> param){
		if(null==offset){
			offset = 0;
		}
		if(null==pagesize){
			pagesize = 20;
		}
		
		param.put("lowno", offset);
		param.put("highno", (pagesize));
	}

	
	/**
	 * 将以 character 分割的字符串转变成字符串集合
	 * @param 	str				待转换的字符串
	 * @param	character		分割字符
	 * @return	List<String>  	转换后的字符串集合
	 */
	public static List<String> getStringList(String str, String character){
		try {
			if(null!=str && str.trim().length()>0){
				List<String> list = new ArrayList<String>();
				String[] values = str.trim().split(character);
				for(String s:values){
					list.add(s);
				}
				return list;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	
	/**
	 * 计算输入的时间字符串和现在相差的天数
	 * @param timestr		时间字符串(yyyyMMddHHmmss)
	 * @return
	 */
	public static int getDifferDays(String timestr){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date strdate = new Date();
		try {
			strdate = sdf.parse(timestr);
		} catch (ParseException e) {
			logger.error("转化日期错误");
		}
		
		long strmill = strdate.getTime();
		long nowmill = new Date().getTime();
		
		if(strmill > nowmill){
			return 0;
		} else{
			int days = (int) ((nowmill-strmill)/(1000*60*60*24));
			return days;
		}
	}
	

	/**
	 * 计算输入的时间字符串和现在相差的天数
	 * @param timestr		时间字符串(yyyyMMddHHmmss)
	 * @return
	 */
	public static int getDifferDays(Date enddate){
		
		long strmill = enddate.getTime();
		long nowmill = new Date().getTime();
		
		int days = (int) ((nowmill-strmill)/(1000*60*60*24));
		return Math.abs(days);
	}
	
	/**
	 * 计算输入时间和当前时间的分钟差
	 * @param date 
	 * @return
	 */
	public static int getDifferMinu(Date date){
		Date now = new Date();
		
		long diff = date.getTime()-now.getTime();
		
		int diffminu = (int) (diff/(1000*60)+1);
		
		return Math.abs(diffminu);
	}
	
	/**
	 * 计算两个时间之间的分钟差(默认+1)
	 * @param startdate		起始时间(小)
	 * @param enddate		结束时间(大)
	 * @return
	 */
	public static int getDifferMinu(Date startdate, Date enddate) {
		if(null!=startdate && null!=enddate) {
			long diff = enddate.getTime() - startdate.getTime();
			int diffminu = (int)(diff/(1000*60)+1);
			
			return Math.abs(diffminu);
		} else if(null!=startdate ) {
			return getDifferMinu(startdate);
		}
		
		return 0;
	}
	
	
	/**
	 * 比较date1是否大于date2(年月日时分秒比较)
	 * @param date1			
	 * @param date2
	 * @param precision 		比较精度：Calendar.year/month...
	 * @return 1(date1大); 0(相等); -1(date2大)
	 */
	public static int copareTwoDate(Date date1, Date date2, int precision) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		
		// 比较年份
		int year1 = cal1.get(Calendar.YEAR);
		int year2 = cal2.get(Calendar.YEAR);
		if(year1 == year2) {
			if(precision > Calendar.YEAR) {
				// 比较月份
				int mon1 = cal1.get(Calendar.MONTH);
				int mon2 = cal2.get(Calendar.MONTH);
				if(mon1 == mon2) {
					if(precision > Calendar.MONTH) {
						// 比较日
						int day1 = cal1.get(Calendar.DAY_OF_MONTH);
						int day2 = cal2.get(Calendar.DAY_OF_MONTH);
						if(day1 == day2) {
							if(precision > Calendar.DAY_OF_MONTH) {
								// 比较时
								int hour1 = cal1.get(Calendar.HOUR_OF_DAY);
								int hour2 = cal2.get(Calendar.HOUR_OF_DAY);
								if(hour1 == hour2) {
									if(precision > Calendar.HOUR_OF_DAY) {
										// 比较分
										int min1 = cal1.get(Calendar.MINUTE);
										int min2 = cal2.get(Calendar.MINUTE);
										if(min1 == min2){
											if(precision > Calendar.MINUTE) {
												// 比较秒
												int sec1 = cal1.get(Calendar.SECOND);
												int sec2 = cal2.get(Calendar.SECOND);
												if(sec1 == sec2 ) {
													return 0;
												} else if(sec1 > sec2) {
													return 1;
												}
											} else{
												return 0;
											}
										} else if(min1 > min2) {
											return 1;
										}
									} else{
										return 0;
									}
								} else if(hour1 > hour2) {
									return 1;
								}
							} else{
								return 0;
							}
						} else if( day1 > day2) {
							return 1;
						}
					} else{
						return 0;
					}
				} else if(mon1>mon2) {
					return 1;
				}
			} else{
				return 0;
			}
		} else if(year1>year2){
			return 1;
		}
		
		return -1;
	}

	
	/**
	 * 在本地保存post传送过来的文件，并返回文件路径
	 * @param request
	 * @param mfile
	 * @return
	 */
	public static String savePostFile(HttpServletRequest request, MultipartFile mfile, String userid){
		String filepath = null;
		if(null!=mfile){
			try {
				String path = request.getSession().getServletContext().getRealPath("/");
				// 获取文件类型
				String orifilename = mfile.getOriginalFilename();
				String filetype = orifilename.substring(orifilename.lastIndexOf('.'));
				// 生成文件名称
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String timestr = sdf.format(new Date());
				String ranstr = getRandomStr(2);
				String filename = userid + "_" + timestr + ranstr + filetype;
				File targetfile = new File(path, filename);
				// 如果目标文件不存在，创建文件
				if(!targetfile.exists()){
					targetfile.mkdirs();
				}
				
				// 保存内容到目标文件中
				mfile.transferTo(targetfile);
				filepath = targetfile.getPath();
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		
		return filepath;
	}
	
	/**
	 * 将16进制字符串转Int
	 * @param hexstr
	 * @return
	 */
	public static int hexstrToInt(String hexstr){
		try {
			return Integer.parseInt(hexstr, 16);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return -1;
	}
	
	
	/**
	 * 根据文件绝对路径获取文件名
	 * @param filepath
	 * @return
	 */
	public static String getFilename(String filepath) {
		if(null!=filepath && filepath.trim().length()>0) {
			File file = new File(filepath);
			return file.getName();
		}
		return null;
	}
	
	
	/**
	 * 转化Map为key:value字符串
	 * @param targetmap
	 * @return
	 */
	public static String transMapToString(Map<String, String> targetmap, String splitchar) {
		if(null!=targetmap) {
			StringBuffer sb = new StringBuffer();
			Iterator<Entry<String, String>> mapite = targetmap.entrySet().iterator();
			while(mapite.hasNext()) {
				Entry<String, String> entry = mapite.next();
				sb.append(entry.getKey() + ":" +entry.getValue() + splitchar);
			}
			
			if(sb.length()>=1) {
				sb.deleteCharAt(sb.length()-1);
			}
			
			return sb.toString();
		}
		
		return null;
	}
	
	
	/**
	 * 设置double类型2位小数
	 * @param oridouble
	 * @return
	 */
	public static double setDoubleTowAccuracy(double oridouble){
		DecimalFormat df = new DecimalFormat("#.00");
		try {
			double tradouble = Double.valueOf(df.format(oridouble));
			return tradouble;
		} catch (Exception e) {
			return -1;
		}
	}
	
	/**
	 * 将map转化成JsonObject对象
	 * @param map
	 * @return
	 */
	public static JSONObject transMapToJsonObject(Map<String, Object> map) {
		JSONObject json = new JSONObject();
		if(null!=map) {
			for (Entry<String, Object> entry : map.entrySet()) {
				json.put(entry.getKey(), (String) entry.getValue());
			}
		}
		
		return json;
	}
	
	/**
	 * 处理时间相加减，返回处理后的时间
	 * @param orgiDate			初始时间，null表示系统时间
	 * @param field				加减的字段
	 * @param inteval			加减的数量
	 * @return
	 */
	public static Date handleDateAdd(Date orgiDate, int field, int inteval) {
		if(null == orgiDate) {
			orgiDate = new Date();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(orgiDate);
		cal.add(field, inteval);
		return cal.getTime();
	}
	
	/**
	 * 获取输入时间的日期 yyyy-MM-dd 00:00:00
	 * @param oridate
	 * @return
	 */
	public static Date getMidnight(Date oridate) {
		if(null==oridate) {
			oridate = new Date();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(oridate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		
		return cal.getTime();
	}
	
	/**
	 * 根据输入时间(yyyy-MM)获取当月开始结束日期
	 * @param timestr
	 * @return
	 */
	public static Map<String, Date> getDaterangeByTimestr(String timestr) {
		Calendar cal = Calendar.getInstance();
		
		if(null!=timestr && timestr.matches("^\\d{4}-\\d{1,2}$")) {
			String[] strs = timestr.split("-");
			cal.set(Calendar.YEAR, Integer.valueOf(strs[0]));
			cal.set(Calendar.MONTH, Integer.valueOf(strs[1])-1);
		}
		
		// 获取月份第一天
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		Date startdate = cal.getTime();
		
		// 获取月份最后一天
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		
		Date enddate = cal.getTime();
		
		Map<String, Date> daterange = new HashMap<String, Date>();
		daterange.put("startdate", startdate);
		daterange.put("enddate", enddate);
		return daterange;
	}
	
	/**
	 * 获取下月开始结束日期
	 * @param timestr
	 * @return
	 */
	public static Map<String, Date> getDaterangeOfNextMonth() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		// 获取下个月第一天
		Date startdate = cal.getTime();
		
		// 获取下个月最后一天
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		Date enddate = cal.getTime();
		
		Map<String, Date> result = new HashMap<String, Date>();
		result.put("startdate", startdate);
		result.put("enddate", enddate);
		
		return result;
	}
	
	/**
	 * md5加密算法， 返回32位小写字符串
	 * @param preSign
	 * @return
	 */
	public static String to32LowcaseMD5(String preSign){
		// 定义十六进制字节数组
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' }; 
		
		try {
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			byte[] md = md5.digest(preSign.getBytes("utf-8"));
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];  
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
                str[k++] = hexDigits[byte0 & 0xf];  
            }  
            return new String(str).toLowerCase();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 请求短信验证码接口时，校验冗余字段
	 * @param phone
	 * @param checkcode phone取余phone的234位数字
	 * @return
	 */
	public static boolean verifyCheckCode(String phone, String checkcode) {
		if(null!=phone && null!=checkcode) {
			try {
				Long mycode = Long.valueOf(phone) % Long.valueOf(phone.substring(1, 4));
				if(mycode.longValue() == Long.valueOf(checkcode).longValue()) {
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
}






