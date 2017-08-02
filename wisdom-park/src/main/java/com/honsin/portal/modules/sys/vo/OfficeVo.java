package com.honsin.portal.modules.sys.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.honsin.portal.modules.sys.entity.Office;

/**
 * @deprecated: 本类是与机构管理相关联的VO类
 * 
 * Function List: 常用方法
 * 
 * @version: Ver. 1.0
 * 
 * @author: cd
 * 
 * History:
 * (author)          (time)            (version)               (desc)
 * 	cd              2017-08-01         1.0                     初始化
 */

@Data
@EqualsAndHashCode(callSuper=false)
public class OfficeVo extends Office{
	
	private static final long serialVersionUID = 1L;
	
	private Office parent;	//父级机构
	
	
	
	
}
