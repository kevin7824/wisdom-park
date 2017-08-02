package com.honsin.portal.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfKit {
	private static Properties props = new Properties();
	
	static {
		try (InputStream in = ConfKit.class.getResourceAsStream("/config.properties")){
			props.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String get(String key) {
		return props.getProperty(key);
	}
	
	public static void main(String[] args) {
		System.out.println(ConfKit.get("jnidName"));
	}
}
