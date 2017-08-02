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
import com.honsin.portal.common.utils.AjaxResult;
import com.honsin.portal.common.utils.BaseContext;
import com.honsin.portal.common.utils.StringUtils;
import com.honsin.portal.modules.sys.entity.Office;
import com.honsin.portal.modules.sys.service.OfficeService;
import com.honsin.portal.modules.sys.vo.OfficeVo;
import com.honsin.portal.modules.sys.vo.UserVo;

/**
 * @deprecated: 本类是与机构管理相关联的业务层control
 * History:
 * (author)          (time)            (version)               (desc)
 * 	cd            2017-08-01         1.0                     初始化
 */
 
@RestController
public class OfficeControl extends BaseControl<OfficeVo>{
	
	@Autowired
	private OfficeService officeServiceImpl;

	@RequestMapping(value = "/office/{id}", method = RequestMethod.GET)
    public AjaxResult<OfficeVo> getOffice(@PathVariable("id") String id) {
    	try {
    		OfficeVo office = officeServiceImpl.get(id);
    	
    		UserVo user = BaseContext.getThreadLocalUser();
    		if (office.getParent()==null || office.getParent().getId()==null){
    			office.setParent(user.getOffice());
    		}
    		office.setParent(officeServiceImpl.get(office.getParent().getId()));
//    		if (office.getArea()==null){
//    			office.setArea(user.getOffice().getArea());
//    		}
    		// 自动获取排序号
    		if (StringUtils.isBlank(office.getId())&&office.getParent()!=null){
    			int size = 0;
    			List<OfficeVo> list = officeServiceImpl.findAll();
    			for (int i=0; i<list.size(); i++){
    				OfficeVo e = list.get(i);
    				if (e.getParent()!=null && e.getParent().getId()!=null
    						&& e.getParent().getId().equals(office.getParent().getId())){
    					size++;
    				}
    			}
    			office.setCode(office.getParent().getCode() + StringUtils.leftPad(String.valueOf(size > 0 ? size+1 : 1), 3, "0"));
    		}
    		
			reAjaxResult.setData(office);
			reAjaxResult.setSuccess(AjaxResult.CODE_SUCCESS);
			reAjaxResult.setEcode(AjaxResult.E000000);
			reAjaxResult.setMsg(AjaxResult.MSG_REQUEST_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			reAjaxResult.setSuccess(AjaxResult.CODE_FAIL);
			reAjaxResult.setMsg(AjaxResult.MSG_REQUEST_FAILURE);
			reAjaxResult.setEcode(AjaxResult.E000001);
		}
    	reAjaxResult.setCommand("getOffice");
        return reAjaxResult;    
    }    
  
    @RequestMapping(value = "/office/{id}", method = RequestMethod.DELETE)    
    public AjaxResult<OfficeVo> deleteOffice(@PathVariable("id") String id) {    
    	try {
    		
    		officeServiceImpl.deleteByMark(id);
			reAjaxResult.setSuccess(AjaxResult.CODE_SUCCESS);
			reAjaxResult.setEcode(AjaxResult.E000000);
			reAjaxResult.setMsg(AjaxResult.MSG_REQUEST_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			reAjaxResult.setSuccess(AjaxResult.CODE_FAIL);
			reAjaxResult.setMsg(AjaxResult.MSG_REQUEST_FAILURE);
			reAjaxResult.setEcode(AjaxResult.E000001);
		}
    	reAjaxResult.setCommand("deleteOffice");
        return reAjaxResult;   
    }    
  
    @RequestMapping(value = "/office", method = RequestMethod.POST)    
    public AjaxResult<OfficeVo> addOffice(OfficeVo office) { 
    	try {
    		office.setId(UUID.randomUUID().toString());
    		officeServiceImpl.insert(office);
			reAjaxResult.setSuccess(AjaxResult.CODE_SUCCESS);
			reAjaxResult.setEcode(AjaxResult.E000000);
			reAjaxResult.setMsg(AjaxResult.MSG_REQUEST_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			reAjaxResult.setSuccess(AjaxResult.CODE_FAIL);
			reAjaxResult.setMsg(AjaxResult.MSG_REQUEST_FAILURE);
			reAjaxResult.setEcode(AjaxResult.E000001);
		}
    	reAjaxResult.setCommand("addOffice");
        return reAjaxResult;    
   }    
  
    @RequestMapping(value = "/office", method = RequestMethod.PUT)    
    public AjaxResult<OfficeVo> updateOffice(OfficeVo office) {    
    	try {
    		officeServiceImpl.update(office);
			reAjaxResult.setSuccess(AjaxResult.CODE_SUCCESS);
			reAjaxResult.setEcode(AjaxResult.E000000);
			reAjaxResult.setMsg(AjaxResult.MSG_REQUEST_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			reAjaxResult.setSuccess(AjaxResult.CODE_FAIL);
			reAjaxResult.setMsg(AjaxResult.MSG_REQUEST_FAILURE);
			reAjaxResult.setEcode(AjaxResult.E000001);
		}
    	reAjaxResult.setCommand("updateOffice");
        return reAjaxResult; 
    }    
  
    @RequestMapping(value = "/office", method = RequestMethod.PATCH)    
    public AjaxResult<OfficeVo>  listOffice(@RequestParam(value = "pageNum", required = true) Integer pageNum,
    		@RequestParam(value = "pageSize", required = true) Integer pageSize) {    
    	try {
    		//分页条件
    		PageHelper.startPage(pageNum, pageSize);
			//查询条件
			Map<String,Object> params = new HashMap<String,Object>();
			List<OfficeVo> list = officeServiceImpl.selectByParams(params);
			PageInfo<OfficeVo> page= new PageInfo<OfficeVo>(list);
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
    	reAjaxResult.setCommand("listOffice");
        return reAjaxResult;   
    }  


}

