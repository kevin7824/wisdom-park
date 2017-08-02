package com.honsin.portal.common.utils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class StringUtil {

	/**
     * UUID 主键
     * @author chuwc 2016-03-23
     * @return 主键
     */
    public static String getId(){
    	return UUID.randomUUID().toString();
    }
    
	/**
     * 校验字符串是否为空
     * @author chuwc 2016-03-24
     * @param str
     * @return 为空：true
     */
    public static boolean isEmptyOrWhitespaceOnly(String str){
		if(str == null || str.length() == 0){
			return true;
		}
		int length = str.length();
		for(int i = 0; i < length; i++){
			if(!Character.isWhitespace(str.charAt(i))){
				return false;
			}
		}
		return true;
	}
    
	/**
     * 去除传入JSON参数中的空键值对
     * @author chuwc 2016-03-24
     * @param obj
     */
    public static void removeNull(Object obj){
		if(obj instanceof JSONObject){
			JSONObject json = (JSONObject) obj;
			Iterator<String> keys = ((JSONObject) obj).keySet().iterator(); //迭代器，允许调用者移除其指向的集合中的元素
			while(keys.hasNext()){
				String key = keys.next();
				if(isEmptyOrWhitespaceOnly(json.getString(key))){
					keys.remove();
				}else{
					removeNull(json.get(key));  //递归调用，可除去多层嵌套的空键值对
				}
			}
		}else if(obj instanceof JSONArray) {
			Iterator<Object> keys = ((JSONArray) obj).iterator();
			while(keys.hasNext()){
				removeNull(keys.next()); //递归调用，可除去多层嵌套的空键值对
			}
		}
	}
    
    /**
     * 校验传入参数（第一层table）
     * @author chuwc 2016-03-23
     * @param jsObj
     * @param params
     * @return 校验通过返回true
     */
    public static boolean checkParam(JSONObject jsObj,String[] params){
        for(String str:params){
            if(!jsObj.containsKey(str) || jsObj.getString(str).isEmpty()){
                return false;
            }
        }       
        return true;
    }
    
    /**
     * 校验JSONArray参数
     * @author chuwc 2016-03-23
     * @return 校验通过返回true
     */
    public static boolean checkMixtrueParam(JSONArray jsObj,String[] params){
        for(int i=0;i<jsObj.size();i++){
            JSONObject jsonRow = (JSONObject) jsObj.get(i);
            for(String str:params){
                if(!jsonRow.containsKey(str) || jsonRow.getString(str).isEmpty()){
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * 校验特定参数格式 多逗号分隔
     * @author chuwc 2016-03-23
     * @param str
     * @return 校验通过返回true
     */
    public static boolean checkParam(String str){
        Pattern p = Pattern.compile("(\\,$)|(^,)");
        Matcher m = p.matcher(str);
        if(m.find()){
                return false;
        }
        return true;
    }
    
    /**
     * 产生n位数字不重复随机数(n<9)
     * @author chuwc 2016-03-23
     * @param 
     * @return 1568
     */
    public static String getRandomNums(int n){
        String[] num = new String[] { "1","2", "3", "4", "5", "6", "7", "8", "9"}; 
        List<String> list = Arrays.asList(num);  
        Collections.shuffle(list);  
        StringBuilder sb = new StringBuilder();  
        for (int i = 0; i < list.size(); i++) {  
            sb.append(list.get(i));  
        }  
        String afterShuffle = sb.toString();  
        String result = afterShuffle.substring(1, n + 1);
        return result;
    }
    
    /**
     * 产生n位字母不重复随机字符串(n<26)
     * @author chuwc 2016-03-23
     * @return abcdef
     */
    public static String getRandomChars(int n){
        String[] num = new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m",
                            "n","o","p","q","r","s","t","u","v","w","x","y","z"};
        List<String> list = Arrays.asList(num);  
        Collections.shuffle(list);  
        StringBuilder sb = new StringBuilder();  
        for (int i = 0; i < list.size(); i++) {  
            sb.append(list.get(i));  
        }  
        String afterShuffle = sb.toString();  
        String result = afterShuffle.substring(1, n + 1); 
        return result;
    }
    
    public static String getRandomString(int n) {
    	String base = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    	Random random = new Random();
    	StringBuffer sb = new StringBuffer();
    	for(int i=0;i<n;i++) {
    		int number = random.nextInt(base.length());
    		sb.append(base.charAt(number));
    	}
    	return sb.toString().toUpperCase();
    }
    
    /**
     * 获取项目根目录
     * @return
     */
    public static String getRootPath() {
    	String path = "";
    	try {
    		File f = new File(StringUtil.class.getResource("/").toURI());
    		path = f.getParentFile().getParentFile().getCanonicalPath();
    	}catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	//	System.out.println("项目根路径:"+path);
		return path;
    }
    
    public static String getApplyCode() {
    	String applyCode = DateUtil.dateStr3(new Date()) + getRandomNums(2);
		String rs = applyCode.substring(2);
		return rs;
    }
    
//    public static void main(String[] args) {
//    	System.out.println(StringUtil.getRootPath());
//	}
    
    /**
	 * 如果str为null，返回“”,否则返回str
	 * 
	 * @param str
	 * @return
	 */
	public static String isNull(String str) {
		if (str == null) {
			return "";
		}
		// v1.6.7.1 去除参数前后空格 xx 2013-11-04 start
		return str.trim();
		// v1.6.7.1 去除参数前后空格 xx 2013-11-04 end
	}
	
	public static boolean isBlank(String str){
		return StringUtil.isNull(str).equals("");
	}
	
	public static int formatActualAmount(double money) {
		int rs = (int) (money*100);
		return rs;
	}
	
	public static double formatDouble(double num) {
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.valueOf(df.format(num));
	}
}
