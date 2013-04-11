package com.ems.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.RegisterUser;
import com.ems.daoImpl.RegisterUserDaoImpl;
import com.ems.dto.RegisterUserDTO;
import com.ems.util.Util;

/**
 * Servlet implementation class RgisterUserServlet
 */

public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    RegisterUser registerDao = new RegisterUserDaoImpl();
    RegisterUserDTO registerDto = new RegisterUserDTO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		registerDto.setFirstName(request.getParameter("first_name"));
		registerDto.setLastName(request.getParameter("last_name"));
		registerDto.setDateOfBirth(Util.convertStringToDate(request.getParameter("date_of_birth")));
		registerDto.setGender(request.getParameter("gender"));
		registerDto.setMobileNumber(request.getParameter("mobile_number"));
		registerDto.setUidNumber(Util.convertStringToLong((request.getParameter("uid_number"))));
		registerDto.setEmailId(request.getParameter("email_id"));
		registerDto.setPanNumber(Util.convertStringToLong((request.getParameter("pan_number"))));
		registerDto.setDepartment(request.getParameter("department"));
		registerDto.setDivision(request.getParameter("designation"));
		registerDto.setAddress(request.getParameter("address"));
		registerDto.setUserRegisterType(request.getParameter("user_type"));
		
		
		int getResultSet = (Integer)registerDao.dbRegisterUser(registerDto);//1
		
		String userId = Util.generateUserId(getResultSet);//EMPCODE001
		
		request.setAttribute("userId",userId);
		
		request.getRequestDispatcher("Success.jsp").forward(request, response);
		
	}

}
