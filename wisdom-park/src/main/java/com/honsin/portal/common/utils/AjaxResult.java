package com.honsin.portal.common.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

/**
 * 
* 类功能说明
* 类修改者	修改日期
* 修改说明
* @author cd
* @version V1.0
 */
public class AjaxResult<T> {
	
	/**
	 * 处理请求成功
	 */
	public static final boolean CODE_SUCCESS = true;
	/**
	 * 处理请求失败
	 */
	public static final boolean CODE_FAIL = false;
	
	public static final String E000000="E000000";  //请求成功
	public static final String E000001="E000001";  //请求失败
	public static final String E000002="E000002";  //访问ws服务器失败
	public static final String E000003="E000003";  //访问ws服务器超时
	public static final String E000004="E000004";  //token已过期
	public static final String E000005="E000005";	//用户不存在
	public static final String E000006="E000006";  //缺少此权限
	public static final String E000007="E000007";  //缺少必填参数
	public static final String E000008="E000008";  //ws服务器出现异常
	public static final String E000009="E000009";  //非法访问
	public static final String E0000010="E0000010";  //用户已经存在
	public static final String E0000011="E0000011";  //用户名或密码错误
	public static final String E0000012="E0000012";  //文件上传失败
	
	
	public static final String MSG_REQUEST_SUCCESS="请求成功";  //请求成功
	public static final String MSG_REQUEST_FAILURE="请求失败";  //请求失败
	public static final String MSG_REQUEST_WS_FAILURE="访问ws服务器失败";  //访问ws服务器失败
	public static final String MSG_REQUEST_WS_TIMEOUT="访问ws服务器超时";  //访问ws服务器超时
	public static final String MSG_TOKEN_OVERDUE="token已过期";  //token已过期
	public static final String MSG_USER_WITHOUT="用户不存在";	//用户不存在
	public static final String MSG_LACK_PERMISSION ="缺少此权限";  //缺少此权限
	public static final String MSG_LACK_PARAMS="缺少必填参数";  //缺少必填参数
	public static final String MSG_WS_EXCEPTION="ws服务器出现异常";  //ws服务器出现异常
	public static final String MSG_ACCESO_ILEGAL="非法访问";  //非法访问
	public static final String MSG_USER_EXIST="用户已经存在";  //用户已经存在
	public static final String MSG_NAMEORPASS_ERROR="用户名或密码错误";  //用户名或密码错误
	public static final String MSG_FILE_UPLOAD_FAILURE="文件上传失败";  //文件上传失败
	
	/**
	 * token认证
	 */
	private String token;
	/**
	 * 接口方法名
	 */
	private String command;
	
	/**
	 * 调用接口返回数据成功与否
	 */
	private boolean success;
	
	/**
	 * 返回操作结果编码
	 */
	private String ecode;
	
	/**
	 * 返回文本消息 
	 */
	private String msg;
	
	/**
	 * 列表数据
	 */
	private List<T> list = new ArrayList<T>();
	/**
	 * 服务器时间
	 */
	private Date nowDate;
	
	/**
	 * 多条数据
	 */
	private Map<String,Object> map= new HashMap<String,Object>();
	
	/**
	 * 单条记录
	 */
	private T data;
	
	/**
	 * 分页数据
	 */
	PageInfo<T> page = new PageInfo<T>();
	
	public AjaxResult() {
		// TODO Auto-generated constructor stub
	}
	
	public AjaxResult(String command,boolean success,String ecode, String msg) {
		super();
		this.command=command;
		this.ecode = ecode;
		this.msg = msg;
		this.success=success;
	}
	
	public AjaxResult(String command,boolean success,String ecode, String msg, T data) {
		super();
		this.command=command;
		this.ecode = ecode;
		this.msg = msg;
		this.data = data;
		this.success=success;
	}
	
	public AjaxResult(String command,boolean success,String ecode, String msg, T data,String token) {
		super();
		this.command=command;
		this.ecode = ecode;
		this.msg = msg;
		this.data = data;
		this.success=success;
		this.token=token;
	}
	
	
	public AjaxResult(String command,boolean success,String ecode, String msg,int totalCount, List<T> list) {
		super();
		this.command=command;
		this.ecode = ecode;
		this.msg = msg;
		this.list = list;
		this.success=success;
	}
	
	public AjaxResult(String command,boolean success,String ecode, String msg,int totalCount, List<T> list,String token) {
		super();
		this.command=command;
		this.ecode = ecode;
		this.msg = msg;
		this.list = list;
		this.success=success;
		this.token=token;
	}
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getEcode() {
		return ecode;
	}

	public void setEcode(String ecode) {
		this.ecode = ecode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getNowDate() {
		return new Date();
	}

	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public PageInfo<T> getPage() {
		return page;
	}

	public void setPage(PageInfo<T> page) {
		this.page = page;
	}
	
	
}
