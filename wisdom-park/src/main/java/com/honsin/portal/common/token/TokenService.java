package com.honsin.portal.common.token;

public interface TokenService {

	String createToken(String userId, String roleId);
	
	String validateToken(String token);
	
	Token getToken(String token);
	
	String validateToken(Token token);
	
}
