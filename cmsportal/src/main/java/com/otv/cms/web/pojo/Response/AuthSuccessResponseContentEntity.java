package com.otv.cms.web.pojo.Response;

public class AuthSuccessResponseContentEntity extends AuthResponseContentEntity {
	public String hashedCode;

	public String getHashedCode() {
		return hashedCode;
	}

	public void setHashedCode(String hashedCode) {
		this.hashedCode = hashedCode;
	}
}
