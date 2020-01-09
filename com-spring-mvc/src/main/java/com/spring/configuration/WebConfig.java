package com.spring.configuration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



@EnableWebMvc
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
private static final Log log = LogFactory.getLog(WebConfig.class);
	
	public WebConfig() {
	}

}
