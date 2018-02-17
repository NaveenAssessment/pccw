package com.pccw.assignment.userapi.dao;

import java.util.List;

import com.pccw.assignment.userapi.entity.Users;

/**
 * @author naveen
 *
 */
public interface UserDao {

	public List<Users> getUserDetails(Integer page, Integer size);
	public Long addUser(Users users);
	public Users getUser(Long userId);
	public Long updateUser(Users users);
	public boolean deleteUser(Long userId);
}
