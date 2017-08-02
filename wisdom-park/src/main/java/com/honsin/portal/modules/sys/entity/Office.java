package com.honsin.portal.modules.sys.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.honsin.portal.common.entity.BaseModel;

/**
 * @deprecated: 本类是与机构管理相关联的BO类
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
public class Office extends BaseModel{

	private static final long serialVersionUID = 1L;

	private String id;				//ID
	private String parentId;				//父级id
	private String parentIds;				//所有id
	private String name;				//名称
	private Integer sort;				//排序
	private String areaId;				//归属区域
	private String code;				//区域编码
	private String type;				//机构类型
	private String grade;				//机构等级
	private String address;				//联系地址
	private String zipCode;				//邮政编码
	private String master;				//负责人
	private String phone;				//电话
	private String fax;				//传真
	private String email;				//邮箱
	private Integer useable;				//是否启用
	private String primaryPerson;				//主负责人
	private String deputyPerson;				//副负责人
	
	
}
