package com.ems.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.UserDetailDelete;
import com.ems.daoImpl.UserDetailDeleteDaoImpl;
import com.ems.dto.UserDetailDeleteDTO;

/**
 * Servlet implementation class UserDetailServlet
 */
public class UserDetailDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDetailDeleteDTO deleteDto = new UserDetailDeleteDTO();
	UserDetailDelete deleteDao = new UserDetailDeleteDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailDeleteServlet() {
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

		deleteDto.setId(Integer.parseInt(request.getParameter("user_register_id")));
		
		deleteDao.dbDeleteUserDetail(deleteDto);
		
		System.out.println("Deleted successfully");
		
	}

}
