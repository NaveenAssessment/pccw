package com.pccw.assignment.user.api.client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.pccw.assignment.user.api.client.model.CreateUserRequest;
import com.pccw.assignment.user.api.client.model.UpdateUserRequest;

@Service
@Transactional
public class UserManagementService {
	

    @Autowired
    private RestTemplate restTemplate;

	public ResponseEntity<String> getUser(String id){
 	    final String uri = "http://localhost:8080/users/{id}";   
 	    HttpHeaders headers = setHeaders();
 	    Map<String, Object> params = new HashMap<>();
		params.put("id", id);
	
 	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
 	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class, params);
 	     
 	    return result;
 	}
	
	public ResponseEntity<String> getAllUsers(){
 	    final String uri = "http://localhost:8080/users";   
 	    HttpHeaders headers = setHeaders();
 	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
 	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
 	    return result;
 	}
	
	public ResponseEntity<String> createUser(CreateUserRequest user){
 	    final String uri = "http://localhost:8080/users";   
 	    HttpHeaders headers = setHeaders();
 	    HttpEntity<CreateUserRequest> entity = new HttpEntity<CreateUserRequest>(user, headers);
 	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.PUT, entity, String.class);
 	    return result;
 	}
	
	public ResponseEntity<String> updateUser(UpdateUserRequest user){
 	    final String uri = "http://localhost:8080/users";   
 	    HttpHeaders headers = setHeaders();
 	    HttpEntity<UpdateUserRequest> entity = new HttpEntity<UpdateUserRequest>(user, headers);
 	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
 	    return result;
 	}
	
	public ResponseEntity<String> deleteUser(String id){
 	    final String uri = "http://localhost:8080/users/{id}";   
 	    HttpHeaders headers = setHeaders();
 	    Map<String, Object> params = new HashMap<>();
		params.put("id", id);
 	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
 	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.DELETE, entity, String.class, params); 
 	    return result;
 	}

	private HttpHeaders setHeaders() {
		HttpHeaders headers = new HttpHeaders();
 	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
 	    headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}


}
