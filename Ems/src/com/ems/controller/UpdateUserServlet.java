package com.ems.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ems.dao.UpdateUser;
import com.ems.daoImpl.UpdateUserDetailDaoImpl;
import com.ems.dto.RegisterUserDTO;
import com.ems.dto.UpdateUserDetailDto;
import com.ems.util.Util;

/**
 * Servlet implementation class UpdateUserServlet Code by JaladK
 */

public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UpdateUserDetailDto userDetailDto = new UpdateUserDetailDto();
	UpdateUser updateUserDao = new UpdateUserDetailDaoImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserServlet() {
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

		  

		userDetailDto.setId(Util.convertIntToString(request
				.getParameter("user_register_id")));

		List<UpdateUserDetailDto> userDetailList = updateUserDao.dbUpdateUserDetail(userDetailDto);

		UpdateUserDetailDto dto= null;
		
		if(userDetailList.size() > 0) {
			
		
		String firstName = userDetailList.get(0).getFirstName();

		String lastName = userDetailList.get(0).getLastName();

		String dateOfBirth = Util.convertDateToString(userDetailList.get(0).getDateOfBirth());

		String emailId = userDetailList.get(0).getEmailId();
		
		String uidNumber = Util.convertLongToString(userDetailList.get(0).getUidNumber());
		
		String panNumber = Util.convertLongToString(userDetailList.get(0).getPanNumber());
		
		String address = userDetailList.get(0).getAddress();
		
		String gender = userDetailList.get(0).getGender();
		
		String designation = userDetailList.get(0).getDivision();
		
		String department = userDetailList.get(0).getDepartment();
		
		String mobileNumber = userDetailList.get(0).getMobileNumber();
		
		String userType = userDetailList.get(0).getUserRegisterType();
		
		String userId = String.valueOf(userDetailList.get(0).getId());
		
		request.setAttribute("firstName", firstName);

		request.setAttribute("lastName", lastName);

		request.setAttribute("dateOfBirth", dateOfBirth);

		request.setAttribute("emailId", emailId);

		request.setAttribute("uidNumber", uidNumber);

		request.setAttribute("panNumber", panNumber);

		request.setAttribute("address", address);

		request.setAttribute("gender", gender);

		request.setAttribute("designation", designation);

		request.setAttribute("department", department);

		request.setAttribute("mobileNumber", mobileNumber);

		request.setAttribute("userType", userType);
		
		request.setAttribute("userId",userId);

		request.getRequestDispatcher("updateUser.jsp").forward(request,
				response);
		}
		else {
			request.getRequestDispatcher("error.jsp").forward(request,
					response);
			
		}

	}

}
