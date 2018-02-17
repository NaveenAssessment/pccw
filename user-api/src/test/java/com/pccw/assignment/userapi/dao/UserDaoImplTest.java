package com.pccw.assignment.userapi.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pccw.assignment.userapi.entity.Users;

/**
 * @author naveen
 * DAO unit test
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoImplTest {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void whenRegisterNewUser_thenCreateUser() {
		Users users = new Users();
		users.setEmail("naveenmaidargi@gmail.com");
		users.setName("naveen maidargi");
		users.setUsername("naveen");
		Long usersId = userDao.addUser(users);

		assertNotNull(usersId);
	}
	
	@Test
	public void whenGetAllUsers_thenReturnUsers() {
		//given id
		Users users1 = new Users();
		users1.setEmail("user1maidargi@gmail.com");
		users1.setName("user1 maidargi");
		users1.setUsername("user1");
		Long usersId1 = userDao.addUser(users1);
		
		Users users2 = new Users();
		users2.setEmail("user2maidargi@gmail.com");
		users2.setName("user2 maidargi");
		users2.setUsername("user2");
		Long usersI2 = userDao.addUser(users2);
		
	    // when
	    List<Users> users = userDao.getUserDetails(null, null);
	 
	    // then
	    assertNotNull(users);
	    assertThat(users.size())
	      .isEqualTo(2);
   
	}
	
	@Test
	public void whenGetUserById_thenReturnUser() {
		//given id
		Users users = new Users();
		users.setEmail("sachitmaidargi@gmail.com");
		users.setName("sachit maidargi");
		users.setUsername("sachit");
		Long usersId = userDao.addUser(users);

	    // when
	    Users found = userDao.getUser(new Long(3));
	 
	    // then
	    assertNotNull(found);
	    assertThat(found.getName())
	      .isEqualTo("sachit maidargi");
	    assertThat(found.getEmail())
	      .isEqualTo("sachitmaidargi@gmail.com");
	    assertThat(found.getUsername())
	      .isEqualTo("sachit");
	    
	}
	
	@Test
	public void whenDeleteUserById_thenReturnUser() {
	    // when
	    boolean isDelete = userDao.deleteUser(new Long(2));
	
	    // then
	    assertTrue(isDelete);    
	}	

}
