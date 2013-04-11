package com.ems.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.UserLeave;
import com.ems.daoImpl.UserLeaveDetailDaoImpl;
import com.ems.dto.RegisterUserDTO;
import com.ems.dto.UserLeaveDetailDto;
import com.ems.util.Util;
import com.sun.org.apache.xerces.internal.impl.dv.xs.DayDV;

/**
 * Servlet implementation class UserLeaveDetailServlet
 */

public class UserLeaveDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserLeaveDetailDto userLeaveDto = new UserLeaveDetailDto();
	RegisterUserDTO objRegisterUserDTO = new RegisterUserDTO();
    UserLeave userLeaveDao = new UserLeaveDetailDaoImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLeaveDetailServlet() {
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
	
		Date getDate1 = Util.convertStringToDate(request.getParameter("date_from"));
		
		Date getDate2 = Util.convertStringToDate(request.getParameter("date_to"));
		
		System.out.println("Date-- 1>>>>>>>"+request.getParameter("date_from"));
		
		System.out.println("Date-- 2>>>>>>>"+request.getParameter("date_to"));
		
		
		System.out.println("Date 1>>>>>>>"+getDate1);
		
		System.out.println("Date 2>>>>>>>"+getDate2);
		
		long getNumberOfDays = Util.getNumberOfDays(getDate1, getDate2);
		
		userLeaveDto.setEmployeeName(request.getParameter("employeename"));
		
		userLeaveDto.setDateRange(getNumberOfDays);
		
		userLeaveDto.setDescription(request.getParameter("description"));
		
		userLeaveDto.setUserRegisterId((Integer.parseInt(request.getParameter("user_leave_id"))));
		
		userLeaveDto.setDepartment(request.getParameter("department"));
		
		objRegisterUserDTO.setId((Integer.parseInt(request.getParameter("user_leave_id"))));
		
		int getLeaveId = userLeaveDao.dbInsertLeaveApplication(userLeaveDto);
		
		if(!(getLeaveId == 0)){
			
			request.setAttribute("getLeaveId", getLeaveId);
			
			request.getRequestDispatcher("leaveProcess.jsp").forward(request, response);
		}else{
			System.out.println("Not Found");
		}
		
		
	
	}

}
