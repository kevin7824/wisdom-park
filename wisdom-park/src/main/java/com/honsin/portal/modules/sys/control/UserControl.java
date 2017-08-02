package com.honsin.portal.modules.sys.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.honsin.portal.common.controller.BaseControl;
import com.honsin.portal.common.converter.DateTimeConverter;
import com.honsin.portal.common.utils.AjaxResult;
import com.honsin.portal.modules.sys.vo.UserVo;
import com.honsin.portal.modules.sys.service.UserService;

/**
 * @deprecated: 本类是与用户管理相关联的业务层control
 * History:
 * (author)          (time)            (version)               (desc)
 * 	gdg            2017-08-01         1.0                     初始化
 */
 
@RestController
public class UserControl extends BaseControl<UserVo>{
	
	@Autowired
	private UserService userServiceImpl;

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public AjaxResult<UserVo> getUser(@PathVariable("id") String id) {
    	try {
    		
    		UserVo vo = userServiceImpl.get(id);
			reAjaxResult.setData(vo);
			reAjaxResult.setSuccess(AjaxResult.CODE_SUCCESS);
			reAjaxResult.setEcode(AjaxResult.E000000);
			reAjaxResult.setMsg(AjaxResult.MSG_REQUEST_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			reAjaxResult.setSuccess(AjaxResult.CODE_FAIL);
			reAjaxResult.setMsg(AjaxResult.MSG_REQUEST_FAILURE);
			reAjaxResult.setEcode(AjaxResult.E000001);
		}
    	reAjaxResult.setCommand("getUser");
        return reAjaxResult;    
    }    
  
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)    
    public AjaxResult<UserVo> deleteUser(@PathVariable("id") String id) {    
    	try {
    		
    		userServiceImpl.deleteByMark(id);
			reAjaxResult.setSuccess(AjaxResult.CODE_SUCCESS);
			reAjaxResult.setEcode(AjaxResult.E000000);
			reAjaxResult.setMsg(AjaxResult.MSG_REQUEST_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			reAjaxResult.setSuccess(AjaxResult.CODE_FAIL);
			reAjaxResult.setMsg(AjaxResult.MSG_REQUEST_FAILURE);
			reAjaxResult.setEcode(AjaxResult.E000001);
		}
    	reAjaxResult.setCommand("deleteUser");
        return reAjaxResult;   
    }    
  
    @RequestMapping(value = "/user", method = RequestMethod.POST)    
    public AjaxResult<UserVo> addUser(UserVo user) {    
    	try {
    		user.setId(UUID.randomUUID().toString());
    		userServiceImpl.insert(user);
			reAjaxResult.setSuccess(AjaxResult.CODE_SUCCESS);
			reAjaxResult.setEcode(AjaxResult.E000000);
			reAjaxResult.setMsg(AjaxResult.MSG_REQUEST_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			reAjaxResult.setSuccess(AjaxResult.CODE_FAIL);
			reAjaxResult.setMsg(AjaxResult.MSG_REQUEST_FAILURE);
			reAjaxResult.setEcode(AjaxResult.E000001);
		}
    	reAjaxResult.setCommand("addUser");
        return reAjaxResult;    
   }    
  
    @RequestMapping(value = "/user", method = RequestMethod.PUT)    
    public AjaxResult<UserVo> updateUser(UserVo user) {    
    	try {
    		userServiceImpl.update(user);
			reAjaxResult.setSuccess(AjaxResult.CODE_SUCCESS);
			reAjaxResult.setEcode(AjaxResult.E000000);
			reAjaxResult.setMsg(AjaxResult.MSG_REQUEST_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			reAjaxResult.setSuccess(AjaxResult.CODE_FAIL);
			reAjaxResult.setMsg(AjaxResult.MSG_REQUEST_FAILURE);
			reAjaxResult.setEcode(AjaxResult.E000001);
		}
    	reAjaxResult.setCommand("updateUser");
        return reAjaxResult; 
    }    
  
    @RequestMapping(value = "/user", method = RequestMethod.PATCH)    
    public AjaxResult<UserVo>  listUser(@RequestParam(value = "pageNum", required = true) Integer pageNum,
    		@RequestParam(value = "pageSize", required = true) Integer pageSize) {    
    	try {
    		//分页条件
    		PageHelper.startPage(pageNum, pageSize);
			//查询条件
			Map<String,Object> params = new HashMap<String,Object>();
			
			List<UserVo> list = userServiceImpl.selectByParams(params);
			PageInfo<UserVo> page= new PageInfo<UserVo>(list);
			
			reAjaxResult.setPage(page);
			reAjaxResult.setSuccess(AjaxResult.CODE_SUCCESS);
			reAjaxResult.setEcode(AjaxResult.E000000);
			reAjaxResult.setMsg(AjaxResult.MSG_REQUEST_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			reAjaxResult.setSuccess(AjaxResult.CODE_FAIL);
			reAjaxResult.setMsg(AjaxResult.MSG_REQUEST_FAILURE);
			reAjaxResult.setEcode(AjaxResult.E000001);
		}
    	reAjaxResult.setCommand("listUser");
        return reAjaxResult;   
    }  
    
    
    @RequestMapping(value = "/user/login", method = RequestMethod.PATCH)    
    public AjaxResult<UserVo> checkLogin(@RequestParam(value = "loginName", required = true) String loginName,
    		@RequestParam(value = "password", required = true) String password) {    
    	try {
    		UserVo user = new UserVo();
    		user = userServiceImpl.selectByName(loginName);
			//DateTimeConverter.transMap2Bean((Map<String,Object>)reAjaxResult.getData(),user);
			String psd = user.getPassword();
			if(psd.equals(password)){
    			reAjaxResult.setSuccess(AjaxResult.CODE_SUCCESS);
    			reAjaxResult.setEcode(AjaxResult.E000000);
    			reAjaxResult.setMsg("请求成功");
    		}
		} catch (Exception e) {
			e.printStackTrace();
			reAjaxResult.setSuccess(AjaxResult.CODE_FAIL);
			reAjaxResult.setMsg("请求失败");
			reAjaxResult.setEcode(AjaxResult.E000001);
		}
        return reAjaxResult;   
    }


}

