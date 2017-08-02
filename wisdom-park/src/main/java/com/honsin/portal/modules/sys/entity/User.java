package com.honsin.portal.modules.sys.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

import com.honsin.portal.common.entity.BaseModel;

/**
 * @deprecated: 本类是与用户管理相关联的BO类
 * 
 * Function List: 常用方法
 * 
 * @version: Ver. 1.0
 * 
 * @author: gdg
 * 
 * History:
 * (author)          (time)            (version)               (desc)
 * 	gdg              2017-08-01         1.0                     初始化
 */

@Data
@EqualsAndHashCode(callSuper=false)
public class User extends BaseModel{

	private static final long serialVersionUID = 1L;

	private String id;				//ID
	private String companyId;				//归属公司
	private String officeId;				//归属部门
	private String loginName;				//登录名
	private String password;				//密码
	private String no;				//工号
	private String name;				//姓名
	private String email;				//邮箱
	private String phone;				//电话
	private String mobile;				//手机
	private Integer userType;				//用户类型
	private String photo;				//用户头像
	private String loginIp;				//最后登陆IP
	private Date loginDate;				//最后登陆时间
	private String loginFlag;				//是否可登录
	private String remarks;				//备注信息
	
	
}
