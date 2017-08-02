package com.honsin.portal.common.utils;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class FastJsonUtil {

	/**
	 * 获取传入参数
	 * 
	 * @return {"CurrentPage":"1","PageRecord":"10","PersonalId":"000"}
	 */
	public static JSONObject getParams(String datas) {
		JSONObject data = JSON.parseObject(datas);
		return data.getJSONObject("table").getJSONObject("row");
	}

	/**
	 * 获取多子表参数
	 * 
	 * @return JSONArray param
	 */
	public static JSONArray getParams(JSONObject datas, String tableName) {
		JSONArray param = new JSONArray();
		JSONArray ja = datas.getJSONArray("table");
		for (int i = 0; i < ja.size(); i++) {
			JSONObject jo = ja.getJSONObject(i);
			if (jo.getString("tableName").equals(tableName)) {
				param = jo.getJSONArray("row");
			}
		}
		return param;
	}

	/**
	 * 获取返回结果参数
	 * 
	 * @return {"CurrentPage":"1","PageRecord":"10","PersonalId":"000"}
	 */
	public static JSONObject getResultJson(String datas) {
		JSONObject data = JSON.parseObject(datas);
		return data.getJSONObject("datas").getJSONObject("table")
				.getJSONObject("row");
	}

	/**
	 * 获取返回结果参数
	 * 
	 * @return {"CurrentPage":"1","PageRecord":"10","PersonalId":"000"}
	 */
	public static JSONArray getRetrunJSONArray(String datas) {
		JSONObject data = JSON.parseObject(datas);
		return data.getJSONObject("datas").getJSONObject("table")
				.getJSONArray("row");
	}

	/**
	 * @author 2016-02-15
	 * @return {"tableName":"Pub_Query","row":"dd"}
	 */
	public static JSONObject getTableRow(String tableName, Object row) {
		JSONObject tab = new JSONObject();
		tab.put("tableName", tableName);
		tab.put("row", row);
		return tab;
	}

	/**
	 * @author 2016-02-15
	 * @return 返回 "{"table":{"tableName":"Pub_Query","row":"dd"}}
	 */
	public static JSONObject getTable(String tableName, Object row) {
		JSONObject tab = new JSONObject();
		tab.put("table", getTableRow(tableName, row));
		return tab;
	}

	/**
	 * @return 返回{"result:"1","info":"dd", "datas":"datas"}
	 */
	public static String getResult(String info, Object data) {
		JSONObject rs = new JSONObject();
		rs.put("result", "1");
		rs.put("info", info);
		rs.put("datas", data);
		return rs.toString();
	}

	/**
	 * @return 返回{"result:"1","info":"dd"}
	 */
	public static String getResult(int result, String info) {
		JSONObject rs = new JSONObject();
		rs.put("result", String.valueOf(result));
		rs.put("info", info);
		return rs.toString();
	}

	/**
	 * 封装结果集
	 * 
	 * @return
	 */
	public static String resultBack(Map rs, String info, String tableName) {
		if (rs == null) {
			return Consant.NO_RECORD;
		}
		return getResult(info, getTable(tableName, rs));
	}

	/**
	 * 封装结果集
	 * 
	 * @return
	 */
	public static String resultBack(List<Map> rs, String info, String tableName) {
		if (rs == null || rs.isEmpty()) {
			return Consant.NO_RECORD;
		}
		return getResult(info, getTable(tableName, rs));
	}

	/**
	 * 封装结果集
	 * 
	 * @param page
	 * @param count
	 *            统计参数
	 * @return
	 */
	/*public static String resultBack(List<Map> rs, String info,
			String tableName, Page page, Map<String, String> count) {
		if (rs == null || rs.isEmpty()) {
			return Consant.NO_RECORD;
		}
		JSONObject datas = getTableRow(tableName, rs);
		JSONObject pages = JSON.parseObject(page.toString());
		if (count != null) {
			pages.putAll(count);
		}
		pages.put("table", datas);
		return getResult(info, getTable("Pub_Count", pages));
	}*/


	/**
	 * 检验手机号
	 * 
	 * @param phone
	 * @return
	 */
	public static boolean isPhone(String phone) {
		// phone = isNull(phone);
		Pattern regex = Pattern
				.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]||17[0,6,7,8]))\\d{8}$");
		Matcher matcher = regex.matcher(phone);
		boolean isMatched = matcher.matches();
		return isMatched;
	}

	/**
	 * UUID 主键
	 * 
	 * @return 主键
	 */
	public static String getId() {
		UUID uuid = UUID.randomUUID();
		String uid = uuid.toString();
		return uid;
	}

}
