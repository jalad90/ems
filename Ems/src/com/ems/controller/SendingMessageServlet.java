package com.ems.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ems.dao.SendMessageDao;
import com.ems.daoImpl.SendMessageDaoImpl;
import com.ems.dto.SendMailDto;

/**
 * Servlet implementation class SendingMessageServlet
 */
public class SendingMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SendMailDto sendMailDto = new SendMailDto();
	SendMessageDao sendMessageDao = new SendMessageDaoImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendingMessageServlet() {
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

		sendMailDto.setFrom(request.getParameter("from"));
		sendMailDto.setTo(request.getParameter("to"));
		sendMailDto.setSubject(request.getParameter("subject"));
		sendMailDto.setText(request.getParameter("text"));
		sendMailDto.setUserName(request.getParameter("username"));
		sendMailDto.setPassWord(request.getParameter("password"));

		int _getResuSet = 0;

		_getResuSet = sendMessageDao.sendTo(sendMailDto);

		System.out.println("Your FeedBack Id is >>>>" + _getResuSet);

	}

}
