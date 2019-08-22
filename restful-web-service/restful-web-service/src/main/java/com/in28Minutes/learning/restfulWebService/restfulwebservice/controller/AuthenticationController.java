package com.in28Minutes.learning.restfulWebService.restfulwebservice.controller;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.in28Minutes.learning.restfulWebService.restfulwebservice.dto.AuthenticationDTO;
import com.in28Minutes.learning.restfulWebService.restfulwebservice.dto.CustomizedUserDetails;
import com.in28Minutes.learning.restfulWebService.restfulwebservice.entity.UserEntity;

@RestController
@CrossOrigin(origins="*")
@SessionAttributes({"currentUser"})
public class AuthenticationController {
	private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

	@RequestMapping(path = "/todo/basicAuthenticate" , method = RequestMethod.GET)
    public AuthenticationDTO authenticateBasic()
    {
		AuthenticationDTO auth = new AuthenticationDTO();
		auth.setMessage("successfull Authentication");
		return auth;
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
    @RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
    public String loginError() {
        log.info("Login attempt failed");
        return "login failed";
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(SessionStatus session) {
        SecurityContextHolder.getContext().setAuthentication(null);
        session.setComplete();
        return "Logout";
    }
    @RequestMapping(value = "/postLogin", method = RequestMethod.POST)
    public String postLogin( HttpSession session) {
        log.info("postLogin()");
        // read principal out of security context and set it to session
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        validatePrinciple(authentication.getPrincipal());
        UserEntity loggedInUser = ((CustomizedUserDetails) authentication.getPrincipal()).getUserDetails();
        
        session.setAttribute("userId", loggedInUser.getId());
        return "successfull Authentication";
    }
    private void validatePrinciple(Object principal) {
        if (!(principal instanceof CustomizedUserDetails)) {
            throw new  IllegalArgumentException("Principal can not be null!");
        }
    }
}
