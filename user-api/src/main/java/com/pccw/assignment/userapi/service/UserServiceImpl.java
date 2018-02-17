package com.pccw.assignment.userapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pccw.assignment.userapi.dao.UserDao;
import com.pccw.assignment.userapi.entity.Users;
import com.pccw.assignment.userapi.model.CreateUserRequest;
import com.pccw.assignment.userapi.model.UpdateUserRequest;
import com.pccw.assignment.userapi.model.User;
import com.pccw.assignment.userapi.util.ObjectMapperUtil;

/**
 * @author naveen
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public Long save(CreateUserRequest user) {
		return userDao.addUser(ObjectMapperUtil.convertToEntity(user));
	}

	@Override
	public User get(Long id) {
		return ObjectMapperUtil.convertToModel(userDao.getUser(id));
	}

	@Override
	public Long update(UpdateUserRequest user) {
		return userDao.updateUser(ObjectMapperUtil.convertToEntity(user));
	}

	@Override
	public void delete(Long id) {
		userDao.deleteUser(id);
	}

	@Override
	public List<User> getUserDetails(Integer page, Integer size) {
		List<Users> usersLst = userDao.getUserDetails(page, size);
		List<User> userLst = ObjectMapperUtil.mapAll(usersLst, User.class);
		return userLst;
	}

}
