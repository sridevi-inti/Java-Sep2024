package com.learn.controller;

import java.io.IOException;

import com.learn.bean.UserBean;
import com.learn.service.UserService;
import com.learn.util.UserUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserService userService = new UserService();

    /**
     * Default constructor. 
     */
    public RegisterServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String error = UserUtil.validateRequest(request);
		HttpSession session = request.getSession();

		if (error == null) {

			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			UserBean userBean = new UserBean();
			userBean.setFirstName(firstname);
			userBean.setLastName(lastname);			
			userBean.setUsername(username);
			userBean.setPassword(password);

			error = userService.validateUserNameExistOrNot(userBean);

						if (error == null) {
				session.setAttribute("username", userBean.getUsername());
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.jsp");
				requestDispatcher.forward(request, response);
			}

		}
		if (error != null) {
			session.setAttribute("error", error);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
			requestDispatcher.forward(request, response);
		}

	}
}