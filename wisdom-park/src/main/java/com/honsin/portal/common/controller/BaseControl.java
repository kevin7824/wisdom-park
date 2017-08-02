package com.honsin.portal.common.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.WebRequest;

import com.honsin.portal.common.utils.AjaxResult;
import com.honsin.portal.common.utils.JacksonUtils;

/**
 * 控制器基类
 * 
 */
public class BaseControl<T> {

	protected JacksonUtils<AjaxResult> jacksonUtils = new JacksonUtils<AjaxResult>();
	protected AjaxResult<T> reAjaxResult = new AjaxResult<T>();;
	
	
	//将字符串转换为Date类
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期格式
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        注册自定义的编辑器
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
       
    }
	
	
	public void sendJson(HttpServletResponse response, StringBuffer str) {
		PrintWriter out = null;
		try {
			response.setContentType("application/json; charset=utf-8");
			response.setHeader("Cache-Control", "no-cache");
			out = response.getWriter();
			out.print(str);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

	/**
	 * 发送json格式数据
	 * 
	 * @param str
	 */
	public void sendJson(HttpServletResponse response, String str) {
		PrintWriter out = null;
		try {
			response.setContentType("application/json; charset=utf-8");
			response.setHeader("Cache-Control", "no-cache");

			out = response.getWriter();
			out.print(str);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

	/**
	 * 发送HTMl格式文本
	 * 
	 * @param str
	 */
	public void sendHtml(HttpServletResponse response, String str) {
		PrintWriter out = null;
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setHeader("Cache-Control", "no-cache");
			out = response.getWriter();
			out.print(str);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

	/**
	 * 发送HTMl格式文本
	 * 
	 * @param str
	 */
	public void sendHtml(HttpServletResponse response, StringBuffer sb) {
		PrintWriter out = null;
		try {
			response.setContentType("text/html; charset=utf-8");
			response.setHeader("Cache-Control", "no-cache");
			out = response.getWriter();
			out.print(sb);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
	
	public StringBuffer deleteLastChar(StringBuffer str){
		return str.lastIndexOf(",")==-1?str:str.deleteCharAt(str.length()-1);
	}
	
	
	/**
	 * 获取上传路径
	 * 
	 * @return
	 */
	public static String getChildDir() {
		Calendar cal = Calendar.getInstance();
		String child;
		if (cal.get(Calendar.MONTH) < 9) {
			child = String.valueOf(cal.get(Calendar.YEAR)) + "0" + String.valueOf(cal.get(Calendar.MONTH) + 1);
		} else {
			child = String.valueOf(cal.get(Calendar.YEAR)) + String.valueOf(cal.get(Calendar.MONTH) + 1);
		}
		return child;
	}
	
	/**
	 * 返回成功消息封装
	 * @param ajaxResult
	 * @return
	 */
	public  AjaxResult<T> successMessage(AjaxResult<T> ajaxResult){
		if(reAjaxResult.getSuccess()){
			reAjaxResult.setSuccess(AjaxResult.CODE_SUCCESS);
			reAjaxResult.setEcode(AjaxResult.E000000);
			reAjaxResult.setMsg(AjaxResult.MSG_REQUEST_SUCCESS);
		}else{
			reAjaxResult.setSuccess(AjaxResult.CODE_FAIL);
			reAjaxResult.setMsg(AjaxResult.MSG_REQUEST_FAILURE);
			reAjaxResult.setEcode(AjaxResult.E000001);
		}
		reAjaxResult.setCommand("getPriKnowledge");
		return ajaxResult;
	}
	
	/**
	 * 失败返回消息封装
	 */
	public  AjaxResult<T> errorMessage(AjaxResult<T> ajaxResult){		
		reAjaxResult.setSuccess(AjaxResult.CODE_FAIL);
		reAjaxResult.setMsg(AjaxResult.MSG_REQUEST_WS_FAILURE);
		reAjaxResult.setEcode(AjaxResult.E000002);
		reAjaxResult.setCommand("getPriKnowledge");
		return ajaxResult;
	}
	
}
