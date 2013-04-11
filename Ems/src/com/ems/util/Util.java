package com.ems.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;

public class Util {

	@SuppressWarnings("finally")
	public static Date convertStringToDate(String getStr) {

		String[] formats = { "yyyy/MM/dd", "yyyy-MM-dd", "yyyyMMdd", "yyMMdd" };
		for (String format : formats) {
			try {
				return new SimpleDateFormat(format).parse(getStr);
			} catch (Exception e) {
			}
		}
		return null;
			
	}

	public static long convertStringToLong(String getStr) {

		Logger LOGGER = Logger.getLogger(Util.class.getName());

		long convertLong = 0;

		try {

			convertLong = Long.parseLong(getStr);

		} catch (Exception e) {
			LOGGER.info("ERROR LONG >>>>>>" + e.toString());
		} finally {
			return convertLong;
		}

	}

	public static String generateUserId(int getId) {

		String EMP_ID = "EMPCODE00";

		return EMP_ID + String.valueOf(getId);

	}

	public static String generateAppraisalId(int getId) {

		String APP_ID = "APPCODE00";

		return APP_ID + String.valueOf(getId);

	}

	public static List<String> getDepartment() {

		List<String> departmentLists = new ArrayList<String>();

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		SQLQuery query = session.createSQLQuery("SELECT * FROM department ");

		List list = query.list();

		Iterator iter = (Iterator) list.iterator();

		while (iter.hasNext()) {
			departmentLists.add(String.valueOf(iter.next()));
		}

		return departmentLists;
	}

	public static List<String> getUserDesignation() {

		List<String> desigantionLists = new ArrayList<String>();

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		SQLQuery query = session.createSQLQuery("SELECT * FROM designation");

		List list = query.list();

		Iterator iter = list.iterator();

		while (iter.hasNext()) {
			desigantionLists.add(String.valueOf(iter.next()));
		}

		return desigantionLists;

	}

	public static List getUserTypeList() {

		List userTypeLists = new ArrayList<String>();

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		SQLQuery query = session.createSQLQuery("SELECT * FROM userType");

		List list = query.list();

		Iterator iter = list.iterator();

		while (iter.hasNext()) {
			userTypeLists.add(String.valueOf(iter.next()));
		}

		transaction.commit();

		session.close();

		return userTypeLists;
	}

	public static List<String> getReportToList() {

		List<String> reportNameList = new ArrayList<String>();

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		SQLQuery query = session.createSQLQuery("SELECT * FROM userType");

		List list = query.list();

		Iterator iter = list.iterator();

		while (iter.hasNext()) {
			reportNameList.add(String.valueOf(iter.next()));
		}

		transaction.commit();

		session.close();

		return reportNameList;

	}

	public static int convertIntToString(String getStr) {

		return Integer.parseInt(getStr);

	}

	public static List<Integer> getUserIdLists() {

		List<Integer> userIdLists = new ArrayList<Integer>();

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		StringBuffer strSQL = new StringBuffer();

		strSQL.append("SELECT user_reg_id FROM register_user");

		SQLQuery query = session.createSQLQuery(strSQL.toString());

		List list = query.list();

		Iterator iter = list.iterator();

		while (iter.hasNext()) {
			userIdLists.add((Integer) iter.next());
		}

		transaction.commit();

		session.close();

		return userIdLists;

	}

	public static String convertDateToString(Date getDate) {
		return String.valueOf(getDate);
	}

	public static String convertLongToString(Long getLong) {
		return String.valueOf(getLong);
	}

	public static List getEmployeeNameList() {

		List getUserName = new ArrayList();

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		SQLQuery query = session
				.createSQLQuery("SELECT first_name_nn FROM register_user");

		List list = query.list();

		Iterator iter = list.iterator();

		while (iter.hasNext()) {
			getUserName.add(iter.next());
		}

		transaction.commit();

		session.close();

		return getUserName;

	}

	public static Date parseDate(String dateString) {
		String[] formats = { "yyyy/MM/dd", "yyyy-MM-dd", "yyyyMMdd", "yyMMdd" };
		for (String format : formats) {
			try {
				return new SimpleDateFormat(format).parse(dateString);
			} catch (Exception e) {
			}
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	public static long getNumberOfDays(Date d1, Date d2) {
		
		System.out.println(d2.getTime());
		
		System.out.println(d1.getTime());

		long days = (((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24)));

		System.out.println(days);

		return days;

	}
	
	

}
