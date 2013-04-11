package com.ems.daoImpl;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ems.dao.SendMessageDao;
import com.ems.dto.SendMailDto;
import com.ems.util.HibernateUtil;

public class SendMessageDaoImpl implements SendMessageDao {

	int getResult = 0;
   

	@SuppressWarnings("finally")
	@Override
	public int sendTo(SendMailDto sendMailDto) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		org.hibernate.Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		Properties props = new Properties();
		props.put("mail.smtp.host", "localhost");
		props.put("mail.smtp.port", "25");
		props.put("mail.smtp.auth", "true");
		
		final String username = sendMailDto.getUserName();
		final String password = sendMailDto.getPassWord();

		Session mailSession = Session.getDefaultInstance(props,new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("username","password");
			}
		});
		
		
		Message simpleMessage = new MimeMessage(mailSession);

		InternetAddress fromAddress = null;
		InternetAddress toAddress = null;
		try {
			fromAddress = new InternetAddress(sendMailDto.getFrom());
			toAddress = new InternetAddress(sendMailDto.getTo());
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("From >>>>>" + fromAddress);

		try {
			simpleMessage.setFrom(fromAddress);
			simpleMessage.setRecipient(RecipientType.TO, toAddress);
			simpleMessage.setSubject(sendMailDto.getSubject());
			simpleMessage.setText(sendMailDto.getText());

			getResult = (Integer) session.save(sendMailDto);

			transaction.commit();

			Transport.send(simpleMessage);
			System.out.println("Message send");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
			return getResult;
		}
	}
}
