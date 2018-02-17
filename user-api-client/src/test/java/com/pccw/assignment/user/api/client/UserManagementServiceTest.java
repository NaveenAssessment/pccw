package com.pccw.assignment.user.api.client;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.pccw.assignment.user.api.client.model.CreateUserRequest;
import com.pccw.assignment.user.api.client.model.UpdateUserRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagementServiceTest {
	@Autowired
	private UserManagementService service;
	
	@Test
	public void testCreateUser( ) {
		CreateUserRequest user1 = new CreateUserRequest();
		user1.setEmail("akarshmaidargi@gmail.com");
		user1.setName("akarsh maidargi");
		user1.setUsername("akarsh");
		user1.setPassword("password");
		ResponseEntity<String> result = service.createUser(user1);
		System.out.println("---------------------------");
		System.out.println(result);
		assertEquals(result.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void testGetUser( ) {
		ResponseEntity<String> result = service.getUser("1");
		System.out.println("---------------------------");
		System.out.println(result);
		assertEquals(result.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void testUpdateUser( ) {
		UpdateUserRequest user1 = new UpdateUserRequest();
		user1.setEmail("akarshmaidargi@yahoo.com");
		user1.setName("akarsh maidargi");
		user1.setUsername("akarshm");
		user1.setPassword("newpassword");
		ResponseEntity<String> result = service.updateUser(user1);
		System.out.println("---------------------------");
		System.out.println(result);
		assertEquals(result.getStatusCode(), HttpStatus.OK);
	}
	
	
	@Test
	public void testGetAllUsers( ) {
		ResponseEntity<String> result = service.getAllUsers();
		System.out.println("---------------------------");
		System.out.println(result);
		assertEquals(result.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void testDeleteUsers( ) {
		ResponseEntity<String> result = service.deleteUser("1");
		System.out.println("---------------------------");
		System.out.println(result);
		assertEquals(result.getStatusCode(), HttpStatus.OK);
	}

}
