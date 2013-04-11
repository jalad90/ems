package com.ems.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.UpdateLeaveRequest;
import com.ems.daoImpl.UpdateLeaveRequestDaoImpl;
import com.ems.dto.UpdateLeaveRequestDTO;

/**
 * Servlet implementation class UpdateLeaveRequestServlet
 */
public class UpdateLeaveRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UpdateLeaveRequest updateLeaveDao = new UpdateLeaveRequestDaoImpl();
    UpdateLeaveRequestDTO updateRequestDto = new UpdateLeaveRequestDTO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLeaveRequestServlet() {
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
	
		updateRequestDto.setId(Integer.parseInt(request.getParameter("leaveid")));
		
		int getResltSet=0;
		
		
		
		int getId = updateRequestDto.getId();
		
		int getResultSet =  updateLeaveDao.updateUserLeaveRequest(getId);
	
		if(!(getResultSet == 0)){
			request.getRequestDispatcher("leaveSuccess.jsp").forward(request, response);
		}
		
		
	}

}
