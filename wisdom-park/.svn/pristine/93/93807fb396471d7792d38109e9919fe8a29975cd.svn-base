package com.honsin.portal.common.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapType;

/**
 * 利用Jackson框架对对象与json互转的工具类
 * @author wdc
 *
 */
public class JacksonUtils<T> {
	private static Logger logger = LoggerFactory.getLogger(JacksonUtils.class);

	private static ObjectMapper objectMapper = null;
	
	/**
	 * 初始化ObjectMapper对象
	 */
	public static void init(){
		if(null==objectMapper){
			objectMapper = new ObjectMapper();
			// 不显示为null的字段
			objectMapper.setSerializationInclusion(Include.ALWAYS);  
		}
	}
	
	
	/**
	 * 将对象实体转化成json字符串
	 * @param entity		带转换的实体对象
	 * @return
	 */
	public static String transEntityToJson(Object entity){
		String jsonstr = null;
		
		if(null!=entity) {
			init();
			
			try{
				jsonstr = objectMapper.writeValueAsString(entity);
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
		
		return jsonstr;
	}
	
	
	/**
	 * 将字符串转化成map对象
	 * @param jsonstr		待转换的json字符串
	 * @return
	 */
	public static Map<String, Object> transJsonstrToMap(String jsonstr){
		Map<String, Object> map = null;
		if(null!=jsonstr && !jsonstr.trim().equals("")) {
			init();
			
			try {
				MapType maptype = objectMapper.getTypeFactory().constructMapType(HashMap.class, String.class, Object.class);
				map = objectMapper.readValue(jsonstr, maptype);
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		
		return map;
	}
	
	
	/**
	 * 将字符串转换成list对象
	 * @param jsonstr		待转换的json字符串
	 * @param elementcls	集合内对象class熟悉
	 * @return
	 */
	public List<T> transJsonstrToList(String jsonstr, Class<T> elementcls) {
		init();
		
		CollectionType collectiontype = objectMapper.getTypeFactory().constructCollectionType(List.class, elementcls);
		
		List<T> list = null;
		try {
			if(null!=jsonstr && !jsonstr.trim().equals("")) {
				list = objectMapper.readValue(jsonstr, collectiontype);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return list;
	}
	
	
	/**
	 * 将字符串转换成指定类型的对象
	 * @param jsonstr		待转换的json字符串
	 * @param classes		将要转换的对象class属性
	 * @return
	 */
	public T transJsonToObject(String jsonstr, Class<T> classes){
		if(null!=jsonstr && !jsonstr.trim().equals("")) {
			init();
			try {
				T t = objectMapper.readValue(jsonstr, classes);
				return t;
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		
		return null;
	}
	
	/**
	 * 将List<Map>转为json字符串
	 * @param map
	 * @return
	 */
	public static String mapToJson(List<Map> map){
		String jsonstr = null;
		if(null!=map) {
			init();
			
			try{
				jsonstr = objectMapper.writeValueAsString(map);
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}
		return jsonstr;
		
	}
	
}


