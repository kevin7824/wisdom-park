package com.honsin.portal.modules.sys.dao;

import com.honsin.portal.common.dao.BaseDao;
import com.honsin.portal.common.utils.AjaxResult;
import com.honsin.portal.modules.sys.vo.UserVo;

/**
 * @deprecated: 本类是与用户管理相关联的dao的接口
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
 * 	gdg             2017-08-01         1.0                     初始化
 */


public interface UserDao extends BaseDao<UserVo>{

	UserVo selectByName(String jsonParams);

   
}
