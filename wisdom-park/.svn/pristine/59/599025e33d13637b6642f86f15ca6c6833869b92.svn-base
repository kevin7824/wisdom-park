package com.honsin.portal.common.interceptor;

import java.util.List;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class AuthInterceptor extends AbstractPhaseInterceptor<SoapMessage>{
	public AuthInterceptor(){
		super(Phase.PRE_INVOKE);
	}

	@Override
	public void handleMessage(SoapMessage soap) throws Fault {
		System.out.println("开始验证用户消息");
		List<Header> headers = soap.getHeaders();
		
		//检查headers是否存在  
        if(headers == null | headers.size()<1){  
            throw new Fault(new IllegalArgumentException("找不到Header，无法验证用户信息"));  
        }  
          
        Header header = headers.get(0);  
          
        Element el = (Element)header.getObject();  
        NodeList users = el.getElementsByTagName("username");  
        NodeList passwords = el.getElementsByTagName("password");  
          
        //检查是否有用户名和密码元素  
        if(users.getLength()<1){  
            throw new Fault(new IllegalArgumentException("找不到用户信息"));  
        }  
        String username = users.item(0).getTextContent().trim();  
          
        if(passwords.getLength()<1){  
            throw new Fault(new IllegalArgumentException("找不到密码信息"));  
        }  
        String password = passwords.item(0).getTextContent();  
          
        //检查用户名和密码是否正确  
        if(!"admin".equals(username) || !"admin".equals(password)){  
            throw new Fault(new IllegalArgumentException("用户名或密码不正确"));  
        }else{  
            System.out.println("用户名密码正确允许访问");  
        }  
	}
	
	
}
