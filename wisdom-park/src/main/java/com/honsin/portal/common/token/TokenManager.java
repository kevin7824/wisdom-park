package com.honsin.portal.common.token;

import com.alibaba.fastjson.JSONObject;
import com.honsin.portal.common.utils.EncodeUtil;
import com.honsin.portal.common.utils.JSONUtils;

/**
 * token相关操作
 */
public class TokenManager implements TokenService {
	
	private static String KEY ="honsintech";

	@Override
	public String createToken(String userId, String roleId) {
		// TODO Auto-generated method stub
		Token token= new Token();
		token.setUserId(userId);
		token.setRoleId(roleId);
		token.setExpiration(System.currentTimeMillis());
		
		return this.addToken(token);
	}

	@Override
	public String validateToken(String token) {
		Token t=getToken(token);
		//10分钟失效
		if(t==null || System.currentTimeMillis()-t.getExpiration()>600000){
			return null;
		}
		t.setExpiration(System.currentTimeMillis());
		return addToken(t);
	}
	
	private String addToken(Token token){
		String jstr = JSONObject.toJSONString(token);
		String rStr = null;
		try {
			rStr = EncodeUtil.aesEncrypt(jstr, KEY);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rStr;
	}
	
	public Token getToken(String token) {
		String jstr=null;
		Token toke= new Token();
		try{
			jstr= EncodeUtil.aesDecrypt(token, KEY);
		}catch(Exception e){
			e.printStackTrace();
		}
		toke = JSONUtils.decode(jstr, Token.class);
		return toke;
	}
	
	public static void main(String[] args) {
		System.out.println(new TokenManager().createToken("1", "1"));
	}

	@Override
	public String validateToken(Token token) {
		//10分钟失效
		if(token==null || System.currentTimeMillis()-token.getExpiration()>600000){
			return null;
		}
		token.setExpiration(System.currentTimeMillis());
		return addToken(token);
	}

}
