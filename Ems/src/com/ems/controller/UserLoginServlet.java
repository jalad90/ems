package com.ems.controller;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.UserLogin;
import com.ems.daoImpl.UserLoginDetailImpl;
import com.ems.dto.LoginDetailDTO;

/**
 * Servlet implementation class UserLogin
 */

public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDetailDTO loginDetailDto = new LoginDetailDTO();
	UserLogin userLoginDao = new UserLoginDetailImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String user = request.getParameter("user_name");
		String pass = request.getParameter("pass_word");
		String userType = request.getParameter("user_type");

		loginDetailDto.setUserName(user);
		loginDetailDto.setPassWord(pass);
		loginDetailDto.setUserType(userType);

		System.out.println("Do Post");

		int id = (Integer) userLoginDao.dbCheckUser(loginDetailDto);

		request.setAttribute("user", user);

		request.setAttribute("user", user);
		request.getRequestDispatcher("/jsp/register.jsp").forward(request,
				response);

	}

}
