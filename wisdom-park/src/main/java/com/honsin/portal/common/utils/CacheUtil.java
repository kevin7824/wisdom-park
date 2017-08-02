package com.honsin.portal.common.utils;

import org.apache.ibatis.io.Resources;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

public class CacheUtil {
	//public static CacheManager manager = CacheManager.create( Info.CACHE_SRC ); //�ǵ���ģʽ
	public static CacheManager manager = null;
			
	public static Cache getCacheByName(String name){
		try{
		manager = CacheManager.newInstance(Resources.getResourceAsStream("ehcache.xml") );
		}catch(Exception e){
			System.out.println("CacheUtil 异常");
			e.printStackTrace();
		}
		return manager.getCache(name);
	}
	public static void main(String[] args) {
		System.out.println(CacheUtil.getCacheByName("TOKEN"));
	}
}
