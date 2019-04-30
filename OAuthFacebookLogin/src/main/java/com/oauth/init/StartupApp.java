package com.oauth.init;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableWebSecurity
@SpringBootApplication
@EnableOAuth2Sso
public class StartupApp extends WebSecurityConfigurerAdapter  {
	public static void main(String[] args) {
		SpringApplication.run(StartupApp.class, args);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .csrf().disable()
        .antMatcher("/**")
        .authorizeRequests()
          .antMatchers("/", "/startPage**")
          .permitAll()
        .anyRequest()
          .authenticated();
        
	}
	  @RequestMapping("/user")
	  public Principal user(Principal principal) {
	      return principal;
	  }
}
