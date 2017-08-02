package com.honsin.portal.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 
* 类功能说明
* 类修改者	修改日期
* 修改说明
* <p>Title: JSONUtils.java</p>
* @version V1.0
 */
public class JSONUtils {
	
	public static String encode(Object value){
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(value);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			objectMapper=null;
		}
		return null;
		
	}
	public static <T> T decode(String content, Class<T> valueType){
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(content, valueType);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			objectMapper=null;
		}
		return null;
	}
	public static  <T> T decode(String content,TypeReference<T> typeReference){
		ObjectMapper objectMapper = new ObjectMapper();
		java.text.DateFormat myFormat = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		objectMapper.setDateFormat(myFormat);
		try {
			return objectMapper.readValue(content,typeReference);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			objectMapper=null;
		}
		return null;
	}
	public static void main(String[] args) throws Exception {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		Map<String,Object> a = new HashMap<String, Object>();
		a.put("type", "view");
		a.put("name", "领红包");
		list.add(a);
		a = new HashMap<String, Object>();
		a.put("type", "view");
		a.put("name", "领红包");
		list.add(a);
		
		List<Map<String,Object>> clist = new ArrayList<Map<String,Object>>();
		
		Map<String,Object> c = new HashMap<String, Object>();
		c.put("type", "view");
		c.put("name", "测评");
		clist.add(c);
		c = new HashMap<String, Object>(); 
		c.put("type", "view");
		c.put("name", "排行");
		clist.add(c);
		c = new HashMap<String, Object>(); 
		c.put("type", "view");
		c.put("name", "话题");
		clist.add(c);
		
		Map<String,Object> b = new HashMap<String, Object>();
		b.put("name", "1");
		b.put("sub_button", clist);
		list.add(b);
		
		
		Map<String,List<Map<String,Object>>> listB = new HashMap<String, List<Map<String,Object>>>();
		listB.put("button", list);
		String content = JSONUtils.encode(listB);
		System.out.println(content);
		
	   
	}
}
