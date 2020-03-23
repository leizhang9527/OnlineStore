package com.model;

/**
 * sessionInfo模型，只要登录成功，就需要设置到session里面，便于系统使用
 * 
 */
public class SessionInfo implements java.io.Serializable {

	private TAdmin user;

	public TAdmin getUser() {
		return user;
	}

	public void setUser(TAdmin user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return user.getUserName();
	}

}
