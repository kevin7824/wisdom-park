package com.honsin.portal.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * web请求接口返回数据封装对象
 * @author wondercher
 *
 */
public class WebReturnObject {
	/** 业务请求返回码: 0业务执行成功 -1未定义 */
	private int code;
	/** 返回数据具体内容 */
	private Map<String, Object> data;
	
	public WebReturnObject() {
		this.code = -1;
		this.data = new HashMap<String, Object>();
	}
	
	/**
	 * 添加内容到返回对象
	 * @param key			
	 * @param value
	 */
	public void addRetContent(String key, Object value) {
		this.data.put(key, value);
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
}
