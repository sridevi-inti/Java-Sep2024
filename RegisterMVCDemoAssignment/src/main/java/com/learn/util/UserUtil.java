package com.learn.util;

import jakarta.servlet.http.HttpServletRequest;

public class UserUtil {

	public static String validateRequest(HttpServletRequest request) {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String error = null;
		if(userName.isEmpty() || password.isEmpty()) {
			error = "Username or Password is Empty";
	}
	return error;
}

	public static String validateRequestForRegisterUser(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
