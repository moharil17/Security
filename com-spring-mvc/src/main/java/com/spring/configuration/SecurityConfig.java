package com.spring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.spring.serviceimpl.CustomSecurity;

@Configuration
@EnableWebSecurity
//@ComponentScan("com.spring")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	 /*@Bean
	  public UserDetailsService userDetailsService() {
	    return new CustomSecurity();
	  };*/
	
	@Autowired
	UserDetailsService userdetailservice;
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userdetailservice);
		
		//auth.inMemoryAuthentication().withUser("kalyani92moharil@gmail.com").password("kalyani").authorities("ROLE_ADMIN");
		
	}
 @Override
 public void configure(HttpSecurity http) throws Exception {
	 http
	 .authorizeRequests()
	 .antMatchers("/homePage").access("hasRole('ROLE_ADMIN')")
	 .antMatchers("/upload").access("hasRole('ROLE_USER')")
	 .and()
	 .formLogin()
	 .defaultSuccessUrl("/success")
	 .defaultSuccessUrl("/failure")
	 .usernameParameter("userEmail")
	 .passwordParameter("userPassword");
	 
 }
 
}
