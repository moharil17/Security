package com.spring.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.daoapi.DaoApi;
import com.spring.entities.Book;
import com.spring.entities.FileUploadBean;
import com.spring.entities.Users;

@Repository
@Transactional
public class DaoImpl implements DaoApi {
	@Autowired
	private SessionFactory factory;

	public List<Users> getUsers() {
		
			List l;
			l = factory.getCurrentSession().createCriteria(Users.class).list();
			System.out.println(l);
			return l;
		 

	}

	public boolean saveFile(Users user) {
		Query query = factory.getCurrentSession().createQuery("update Users set file=:file" + " where id=:id");
		query.setBinary("file", user.getFile());
		query.setParameter("id", user.getUserId());
		query.executeUpdate();
		System.out.println("inside dao");
		return true;
	}

	public boolean signUpUser(Users user) {
		try {
			System.out.println("inside dao");
			factory.getCurrentSession().persist(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public Users getUserByEmail(String email) {

		List<Users> list = new ArrayList<Users>();
		list = factory.getCurrentSession().createQuery("from Users where userEmail=:email").setParameter("email", email)
				.list();
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}