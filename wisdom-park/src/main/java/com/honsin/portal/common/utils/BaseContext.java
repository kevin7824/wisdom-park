package com.honsin.portal.common.utils;

import com.honsin.portal.common.token.Token;
import com.honsin.portal.modules.sys.entity.User;
import com.honsin.portal.modules.sys.vo.UserVo;


public class BaseContext {
	//ThreadLocal 变量 在单个线程中有效
	public static final ThreadLocal<String> ipThreadLocal = new ThreadLocal<String>();
	public static final ThreadLocal<UserVo> threadLocalUser = new ThreadLocal<UserVo>();
	public static final ThreadLocal<Token> threadLocalToken = new ThreadLocal<Token> ();
	public static ThreadLocal<Token> getThreadlocaltoken() {
		return threadLocalToken;
	}
	public static final String getClientIP() {
		Object retObj = BaseContext.ipThreadLocal.get();
		return retObj == null ? "未知IP" : retObj.toString();
	}
	public static final void setClientIP(String ip){
		if (ip!=null) {
			ipThreadLocal.set(ip);
		}else{
			ipThreadLocal.set("未知IP");
		}
	}
	public static final UserVo getThreadLocalUser(){
		Object retObject=BaseContext.threadLocalUser.get();
		return (UserVo) retObject;
	}
	
	public static final void setThreadLocalUser(UserVo user){
		if (user!=null) {
			BaseContext.threadLocalUser.set(user);
		}else{
			BaseContext.threadLocalUser.set(new UserVo());
		}
	}
}
