package com.demo.email;

import javax.mail.*;

/**
 * 描述：
 * 作者：zc741
 * 时间：2018/8/1 12:45.
 */

public class Authentication extends Authenticator {
	String username = null;
	String password = null;

	public Authentication() {
	}

	public Authentication(String username, String password) {
		this.username = username;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		PasswordAuthentication pa = new PasswordAuthentication(username, password);
		return pa;
	}
}