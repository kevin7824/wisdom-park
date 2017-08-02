package com.honsin.portal.modules.sys.vo;

import com.honsin.portal.modules.sys.entity.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @deprecated: 本类是与用户管理相关联的VO类
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
public class UserVo extends User{
	
	private static final long serialVersionUID = 1L;
	
	private OfficeVo office;		//所属机构
	
}
