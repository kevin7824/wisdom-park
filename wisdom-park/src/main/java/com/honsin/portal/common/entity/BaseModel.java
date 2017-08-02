package com.honsin.portal.common.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * Entity基础接口
 * 
 * @author chen
 * 
 */
@Data
public abstract class BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String createBy;	// 创建者
	protected Date createDate;	// 创建日期
	protected String updateBy;	// 更新者
	protected Date updateDate;	// 更新日期
	protected String delFlag; 	// 删除标记（0：正常；1：删除；2：审核）
}
