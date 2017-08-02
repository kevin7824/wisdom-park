package com.honsin.portal.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.honsin.portal.common.service.impl.BaseServiceImpl;
import com.honsin.portal.common.utils.AjaxResult;

import org.springframework.stereotype.Service;
import com.honsin.portal.modules.sys.vo.UserVo;
import com.honsin.portal.modules.sys.service.UserService;
import com.honsin.portal.modules.sys.dao.UserDao;

/**
 * @deprecated: 本类是与用户管理相关联的业务类
 * Function List: 常用方法
 * History:
 * (author)          (time)            (version)               (desc)
 * 	gdg              2017-08-01         1.0                     初始化
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserVo> implements UserService{ 
	@Autowired
	private UserDao userDao;
	@Autowired
	public void setBaseDao(UserDao userDao){
		super.baseDao = userDao;
	}

	@Override
	public UserVo selectByName(String jsonParams) {
		return userDao.selectByName(jsonParams);
	}
}

