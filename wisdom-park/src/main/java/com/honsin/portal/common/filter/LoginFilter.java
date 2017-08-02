package com.honsin.portal.common.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.honsin.portal.common.token.Token;
import com.honsin.portal.common.token.TokenManager;
import com.honsin.portal.common.token.TokenService;
import com.honsin.portal.common.utils.AjaxResult;
import com.honsin.portal.common.utils.BaseContext;
import com.honsin.portal.common.utils.JacksonUtils;
import com.honsin.portal.common.utils.StringUtils;

/**
 * 使用注解标注过滤器
 * @WebFilter将一个实现了javax.servlet.Filter接口的类定义为过滤器
 * 属性filterName声明过滤器的名称,可选
 * 属性urlPatterns指定要过滤 的URL模式,也可使用属性value来声明.(指定要过滤的URL模式是必选属性)
 */
@WebFilter(filterName="myFilter",urlPatterns="/*")
public class LoginFilter implements Filter {
	
	@Autowired
	//private UserService userServiceImpl;
	
	private TokenService tokenService =new TokenManager();
	
    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        System.out.println("执行过滤操作");

//        String ipaddress = getRemoteHost((HttpServletRequest) request);
//		BaseContext.setClientIP(ipaddress);
//		String tokenStr = ((HttpServletRequest) request).getParameter("token");
//		
//		if(StringUtils.isNotEmpty(tokenStr)){
//			Token token = tokenService.getToken(tokenStr);
//			if(token != null && StringUtils.isNotEmpty(token.getUserId())){
//				BaseContext.getThreadlocaltoken().set(token);
//				if(BaseContext.getThreadLocalUser()==null && StringUtils.isNotEmpty(tokenService.validateToken(tokenStr))){
//					
//					AjaxResult<String> ajaxResult = new AjaxResult<String>();
//					Map<String, Object> param = new HashMap<String, Object>();
//					param.put("id", token.getUserId());
//					ajaxResult.setMap(param);
//					JacksonUtils<AjaxResult> jacksonUtils = new JacksonUtils<AjaxResult>();
//					AjaxResult<UserVo>  reAjaxResult = userServiceImpl.selectByName(jacksonUtils.transEntityToJson(ajaxResult));
//					
//					UserVo localUser = reAjaxResult.getData();
//					BaseContext.setThreadLocalUser(localUser);
//				}
//			}	
//		}
        chain.doFilter(request, response);
//		BaseContext.ipThreadLocal.remove();
//		BaseContext.threadLocalUser.remove();
//		BaseContext.threadLocalToken.remove();
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器初始化");
    }

    
    private String getRemoteHost(javax.servlet.http.HttpServletRequest request){
	    String ip = request.getHeader("x-forwarded-for");
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
	        ip = request.getRemoteAddr();
	    }
	    return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
	}
}