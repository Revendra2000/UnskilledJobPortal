package com.persistent.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

//@EnableWebSecurity
//@Configuration
//@Order(1)
public class SecurityConfigurationUser //extends WebSecurityConfigurerAdapter
{

//	@Autowired
//	private UserDetailsService userDetailService;
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		System.out.println("Reached config file"+auth);
//		//		auth.userDetailsService(userDetailService);
//		auth.authenticationProvider(authProvider2());
//
//	}
//
////	@Bean
////	public PasswordEncoder getPasswordEncoder() {
////		return NoOpPasswordEncoder.getInstance();
////	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.antMatchers("/").hasRole("USER")
//		.and()
//		.logout()
//		.permitAll()
//		.and()
//		.formLogin(form -> form
//				.defaultSuccessUrl("/dashboard")
//				.loginPage("/login")
//				.failureUrl("/login?error=true")
//				);
//	}
//
//	@Bean
//	public DaoAuthenticationProvider authProvider2() {
//		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//		authenticationProvider.setPasswordEncoder(com.persistent.config.SecurityConfiguration.getPasswordEncoder());
//		authenticationProvider.setUserDetailsService(userDetailService);
//		return authenticationProvider;
//	}

}
