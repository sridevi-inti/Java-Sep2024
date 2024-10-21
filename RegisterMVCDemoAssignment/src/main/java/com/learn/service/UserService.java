package com.learn.service;

import com.learn.bean.UserBean;
import com.learn.dao.UserDAO;

public class UserService {

	UserDAO userDAO = new UserDAO();
	
	public String autheticateAndPopulateUSer(UserBean userBean) {
		String error = null;
		
		userBean = userDAO.getUserBean(userBean);
		
		if(userBean.getFirstName() == null) {
			
			error="Invalid User Credentials";
			
		}
		return error;
		
		
	}

	public String validateUserNameExistOrNot(UserBean userBean) {
		// TODO Auto-generated method stub
		
		String error = null;
		
		UserBean userBean1 = userDAO.isUserNameExists(userBean);

		
		if(userBean.getUsername() != null) {
			
			error = "User Already Exists";
		}
		
		else {
			
			userBean= userDAO.createUserBean(userBean);

		}
			
			
		
		return error;
	}

}
