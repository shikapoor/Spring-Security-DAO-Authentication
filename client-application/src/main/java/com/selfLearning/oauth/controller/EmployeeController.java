package com.selfLearning.oauth.controller;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.selfLearning.oauth.dto.AuthorizationToken;
import com.selfLearning.oauth.dto.Employee;

@RestController
public class EmployeeController {
	@RequestMapping(value = "/getEmployees", method = RequestMethod.GET)
    public ModelAndView getEmployeeInfo() {
        return new ModelAndView("getEmployees");
    }
	
	@RequestMapping(value = "/showEmployees", method = RequestMethod.GET)
    public ModelAndView getEmployeeInfo1(@RequestParam("code") String code) throws IOException {
		
		ResponseEntity<AuthorizationToken> response = null;
		RestTemplate restTemplate = new RestTemplate();

		
		System.out.println("Authorization code : "+ code);
		String credentials = "javainuse:secret";
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Basic " + encodedCredentials);
		HttpEntity<String> request = new HttpEntity<String>(headers);
		String access_token_url = "http://localhost:8080/oauth/token";
		access_token_url += "?code=" + code;
		access_token_url += "&grant_type=authorization_code";
		access_token_url += "&redirect_uri=http://localhost:8090/showEmployees";
        response = restTemplate.exchange(access_token_url, HttpMethod.POST, request, AuthorizationToken.class);
        System.out.println("Access Token Response ---------" + response.getBody());
        
        String url = "http://localhost:8080/user/employeeslist";
		// Use the access token for authentication
		HttpHeaders headers1 = new HttpHeaders();
		headers1.add("Authorization", "Bearer " + response.getBody().getAccess_token());
		headers1.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(headers1);
//		ResponseEntity<String> employees = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//		System.out.println("****************************"+employees);
		ResponseEntity<Employee[]> employees = restTemplate.exchange(url, HttpMethod.GET, entity, Employee[].class);
		System.out.println(employees);
		Employee[] employeeArray = employees.getBody();
		//Employee[] employeeArray =null;

		ModelAndView model = new ModelAndView("showEmployees");
		model.addObject("employees", Arrays.asList(employeeArray));
		return model;
        
		
        //return "showEmployees";
    }
}
