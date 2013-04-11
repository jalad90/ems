package com.ems.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.UpdateDbUserDetail;
import com.ems.daoImpl.UpdateDbUserDetailDaoImpl;
import com.ems.dto.RegisterUserDTO;
import com.ems.dto.UpdateDbUserDetailDto;
import com.ems.dto.UpdateUserDetailDto;
import com.ems.util.Util;

/**
 * Servlet implementation class UpdateDbUserServlet
 */

public class UpdateDbUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UpdateDbUserDetailDto userDetailDto = new UpdateDbUserDetailDto();
	UpdateDbUserDetail dbUserDetailDao = new UpdateDbUserDetailDaoImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateDbUserServlet() {
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

		if (!(userDetailDto == null)) {

			userDetailDto.setFirstName(request.getParameter("firstname"));

			userDetailDto.setLastName(request.getParameter("lastname"));
			userDetailDto.setDateOfBirth(Util.convertStringToDate(request
					.getParameter("dateofbirth")));

			userDetailDto.setGender(request.getParameter("gender"));
			userDetailDto.setMobileNumber(request.getParameter("mobilenumber"));

			userDetailDto.setUidNumber(Util.convertStringToLong((request
					.getParameter("uidnumber"))));

			userDetailDto.setEmailId(request.getParameter("emailid"));

			userDetailDto.setPanNumber(Util.convertStringToLong((request
					.getParameter("pannumber"))));
			userDetailDto.setDepartment(request.getParameter("department"));
			userDetailDto.setDivision(request.getParameter("designation"));
			userDetailDto.setAddress(request.getParameter("address"));
			userDetailDto.setUserRegisterType(request.getParameter("usertype"));
			
			userDetailDto.setId(Integer.parseInt((request
					.getParameter("userid"))));

			int getUserId = Integer.parseInt(request.getParameter("userid"));

			System.out.println("Updated Part");

			dbUserDetailDao.dbUpdateShowUserDetail(userDetailDto);

			request.setAttribute("getUserId", getUserId);

			request.getRequestDispatcher("updatedSuccessfully.jsp").forward(
					request, response);

		} else {
			System.out.println("Else Part");
		}

	}

}
