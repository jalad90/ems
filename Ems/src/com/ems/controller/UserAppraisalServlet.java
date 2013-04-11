package com.ems.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.UserAppraisal;
import com.ems.daoImpl.UserAppraisalDaoImpl;
import com.ems.dto.AppraisalDetailDTO;
import com.ems.util.Util;

/**
 * Servlet implementation class UserAppraisalServlet
 */

public class UserAppraisalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AppraisalDetailDTO appraisalDto = new AppraisalDetailDTO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAppraisalServlet() {
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
		
			UserAppraisal appraisalDao = new UserAppraisalDaoImpl();
			
			appraisalDto.setFirstName(request.getParameter("first_name_app"));
			appraisalDto.setDivision(request.getParameter("department"));
			appraisalDto.setDepartment(request.getParameter("department"));
			appraisalDto.setLastAppraisalDate(Util.convertStringToDate(request.getParameter("last_appraisal_date")));
			appraisalDto.setFutureAppraisalDate(Util.convertStringToDate(request.getParameter("future_appraisal_date")));
			
			int getResultSet = appraisalDao.dbUpdateAppraisal(appraisalDto);
			
			String getAppraisalId = Util.generateAppraisalId(getResultSet);
			
			request.setAttribute("getAppraisalId",getAppraisalId);
			
			request.getRequestDispatcher("appraisalSuccess.jsp").forward(request, response);
			
			
	}

}
