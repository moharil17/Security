package com.spring.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.spring.daoapi.DaoApi;
import com.spring.entities.Users;
import com.spring.serviceapi.ServiceApi;

@Service
public class ServiceImpl implements ServiceApi {

	@Autowired
	DaoApi dao;
	
	@Autowired
	MailSender mailsender;
	public List<Users> getUser() {
		
		return dao.getUsers();
	}
	public boolean saveFile(Users user) {
		
		return dao.saveFile(user);
	}
	
	public boolean signUpUser(Users user) {
	 final String Alpha_Numeric_String ="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	 int count=5;
	 StringBuilder builder = new StringBuilder();
	 while(count--!=0) {
		 int character =(int) (Math.random()*Alpha_Numeric_String.length());
		 builder.append(Alpha_Numeric_String.charAt(character));
	 }
	 user.setUserPassword(builder.toString());
	 if(dao.signUpUser(user)) {
		 System.out.println("inside if of dao");
		 SimpleMailMessage message = createMailMessage(user);
		 send(message);
		 return true;
	 }
		return false;
	}
	@Async
	void send(SimpleMailMessage mail) {
		try
		{
			System.out.println("inside send");
			mailsender.send(mail);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
private SimpleMailMessage createMailMessage(Users user) {
	System.out.println("inside createMailMessage");
	SimpleMailMessage mail = new SimpleMailMessage();
	mail.setTo(user.getUserEmail());
	mail.setSubject("welcome to Spring MVC");
	mail.setText("Hi " + user.getUserName() + " your password is " + user.getUserPassword());
	return mail;
}
}
