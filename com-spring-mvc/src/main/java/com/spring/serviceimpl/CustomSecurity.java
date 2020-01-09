package com.spring.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.daoapi.DaoApi;
import com.spring.entities.UserRoles;
import com.spring.entities.Users;

@Service
public class CustomSecurity implements UserDetailsService {

	@Autowired
	DaoApi dao;
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = dao.getUserByEmail(username) ;
		if(user == null) {
			throw new UsernameNotFoundException("username not found");
		}
		List<GrantedAuthority> authorities = getAuthorityList(user.getRole());
         return new User(user.getUserEmail(), user.getUserPassword(),true,true,true,true, authorities);
	}
	private List<GrantedAuthority> getAuthorityList(Set<UserRoles> role) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		 for(UserRoles userProfile : role){
	            authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getRoleName()));
	        }
	        return authorities;
	    }
	}
	
	


