package com.honsin.portal.common.interceptor;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ClientLoginInterceptor extends AbstractPhaseInterceptor<SoapMessage>{
	private String token;  
    
    public void setToken(String token) {
		this.token = token;
	}
	/** 
     * 创建一个新的实例 ClientLoginInterceptor. 
     * 
     * @param username 
     * @param password 
     */
	public ClientLoginInterceptor(String token) {  
        super(Phase.PREPARE_SEND);  
        this.token = token ;
    }  
    /* (non-Javadoc) 
     * @see org.apache.cxf.interceptor.Interceptor#handleMessage(org.apache.cxf.message.Message) 
     */  
    public void handleMessage(SoapMessage soap) throws Fault {  
        // TODO Auto-generated method stub  
        List<Header> headers = soap.getHeaders();  
          
        Document doc = DOMUtils.createDocument();  
          
        Element auth = doc.createElement("authrity");  
        Element token = doc.createElement("token");  
          
        token.setTextContent(this.token);  
          
        auth.appendChild(token);  
        //doc.appendChild(auth);  
          
        headers.add(0, new Header(new QName("tiamaes"),auth));  
    }
}
