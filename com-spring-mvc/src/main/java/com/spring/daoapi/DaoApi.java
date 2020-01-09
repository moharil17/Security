package com.spring.daoapi;

import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.spring.entities.Users;

@Repository
public interface DaoApi {

	public List<Users> getUsers();
	public boolean saveFile(Users user);
	public boolean signUpUser(Users user);
	public Users getUserByEmail(String email);
}
