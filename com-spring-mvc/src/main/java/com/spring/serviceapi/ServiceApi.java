package com.spring.serviceapi;

import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.spring.entities.FileUploadBean;
import com.spring.entities.Users;
@Service
public interface ServiceApi {
	
	public List<Users> getUser();
	public boolean saveFile(Users user);
	public boolean signUpUser(Users user);

}
