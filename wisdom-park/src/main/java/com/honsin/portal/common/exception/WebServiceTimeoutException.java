package com.honsin.portal.common.exception;

/**
 * webservice异常
 * @author hasee
 *
 */
public class WebServiceTimeoutException extends Exception {

	private static final long serialVersionUID = 4979167355475156447L;

	public WebServiceTimeoutException(String msg){ 
	        super(msg);
    } 
}
