package com.pccw.assignment.userapi.service;

import java.util.List;

import com.pccw.assignment.userapi.model.CreateUserRequest;
import com.pccw.assignment.userapi.model.UpdateUserRequest;
import com.pccw.assignment.userapi.model.User;

/**
 * @author naveen
 *
 */
public interface UserService {

	Long save(CreateUserRequest user);

	User get(Long id);

	List<User> getUserDetails(Integer page, Integer size);

	Long update(UpdateUserRequest user);

	void delete(Long id);

}
