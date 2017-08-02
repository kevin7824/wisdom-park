package com.honsin.portal.modules.sys.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.honsin.portal.common.service.BaseService;
import com.honsin.portal.common.utils.AjaxResult;
import com.honsin.portal.modules.sys.vo.UserVo;

/**
 * @deprecated: 本类是与用户管理相关联的业务层接口
 * 
 * Function List: 常用方法
 * 
 * @version: Ver. 1.0
 * 
 * @since: Ver. 1.0
 * 
 * @author: gdg
 * 
 * History:
 * (author)          (time)            (version)               (desc)
 * 	gdg              2017-08-01         1.0                     初始化
 */
public interface UserService extends BaseService<UserVo> {
	
	public UserVo selectByName(String jsonParams);


   
}

