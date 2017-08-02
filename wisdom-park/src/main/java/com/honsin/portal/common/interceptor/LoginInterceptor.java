package com.honsin.portal.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.honsin.portal.MyBootApplication;
import com.honsin.portal.common.token.Token;
import com.honsin.portal.common.token.TokenManager;
import com.honsin.portal.common.token.TokenService;
import com.honsin.portal.common.utils.AjaxResult;
import com.honsin.portal.common.utils.BaseContext;
import com.honsin.portal.common.utils.JacksonUtils;
import com.honsin.portal.common.utils.StringUtils;

/**
 * 自定义拦截器1
 */
public class LoginInterceptor implements HandlerInterceptor {

	protected final Logger logger = LoggerFactory.getLogger(MyBootApplication.class);
	
	private TokenService tokenService =new TokenManager();
	
	protected JacksonUtils<AjaxResult> jacksonUtils = new JacksonUtils<AjaxResult>();
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println(">>>MyInterceptor1>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
//    	logger.debug("preHandle");
//    	Token token = BaseContext.getThreadlocaltoken().get();
//    	response.setContentType("text/plain; charset=utf-8");
//		AjaxResult<String> ajaxResult = new AjaxResult<String>();
//		ajaxResult.setCommand("checkToken");
//		ajaxResult.setSuccess(AjaxResult.CODE_FAIL);
//		if(token == null ){
//			ajaxResult.setMsg(AjaxResult.MSG_ACCESO_ILEGAL);
//			ajaxResult.setEcode(AjaxResult.E000009);
//			response.getWriter().print(jacksonUtils.transEntityToJson(ajaxResult));
//			response.getWriter().close();
//
//			return false;
//		}
//		
//		String tokenStr = tokenService.validateToken(token);
//		if(null != tokenService.getToken(tokenStr)){ //token未超时
//			BaseContext.getThreadlocaltoken().set(token);
//			return true;
//		}else{  //token超时
//			ajaxResult.setMsg(AjaxResult.MSG_TOKEN_OVERDUE);
//			ajaxResult.setEcode(AjaxResult.E000004);
//			response.getWriter().print(jacksonUtils.transEntityToJson(ajaxResult));
//			response.getWriter().close();
//			return false;
//		}
       // 只有返回true才会继续向下执行，返回false取消当前请求   
	    return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println(">>>MyInterceptor1>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println(">>>MyInterceptor1>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }

}