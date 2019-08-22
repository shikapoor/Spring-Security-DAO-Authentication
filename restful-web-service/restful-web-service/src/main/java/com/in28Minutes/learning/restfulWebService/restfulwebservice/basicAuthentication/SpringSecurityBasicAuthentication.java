package com.in28Minutes.learning.restfulWebService.restfulwebservice.basicAuthentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.in28Minutes.learning.restfulWebService.restfulwebservice.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SpringSecurityBasicAuthentication extends WebSecurityConfigurerAdapter {
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//
//		http
//			
//		    .csrf().disable()
//		 	.authorizeRequests()
//		 	.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//				.anyRequest().authenticated()
//				.and()
//			//.formLogin().and()
//			.httpBasic();
//
//		    
//		
//	}
	
	    @Bean
	    public UserDetailsService userDetailsService() {
	        return new UserDetailsServiceImpl();
	    }
	    
	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(passwordEncoder());
	        return authProvider;
	    }
	    
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) {
	        auth.authenticationProvider(authenticationProvider());
	    }
	    
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
		        .authorizeRequests().antMatchers("/").permitAll()
		        .and()
	            .authorizeRequests().antMatchers("/console/**").permitAll()
	            .and()
	            .authorizeRequests().antMatchers("/login", "/resource/**").permitAll()
	            .and()
//	            .authorizeRequests().anyRequest().authenticated()
//	            .and()
	            .formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").permitAll()
	                .loginProcessingUrl("/doLogin")
	                .successForwardUrl("/postLogin")
	                .failureUrl("/loginFailed")
	                .and()
	                .logout().logoutUrl("/doLogout").logoutSuccessUrl("/logout").permitAll()
	            .and()
	            .csrf().disable()
	            .headers().frameOptions().disable();
	    }



}
