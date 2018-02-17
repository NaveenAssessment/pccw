package com.pccw.assignment.userapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pccw.assignment.userapi.model.CreateUserRequest;
import com.pccw.assignment.userapi.model.UpdateUserRequest;
import com.pccw.assignment.userapi.model.User;
import com.pccw.assignment.userapi.service.UserService;

import io.swagger.annotations.ApiParam;

/**
 * @author naveen
 *
 */
@RestController
public class UserApiController implements UserApi {

	@Autowired
	private UserService userService;
	
	@Override
	public ResponseEntity<User> createUsingPUT(
			@ApiParam(value = "request", required = true) @Valid @RequestBody CreateUserRequest request) {
		final Long userId = userService.save(request);
		return new ResponseEntity<User>(userService.get(userId), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<User> deleteUsingDELETE(
			@ApiParam(value = "id", required = true) @PathVariable("id") Long id) {
		userService.delete(id);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<User> getUsingGET(@ApiParam(value = "id", required = true) @PathVariable("id") Long id) {
		return new ResponseEntity<User>(userService.get(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<User>> listUsingGET1(
			@ApiParam(value = "page") @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "size") @RequestParam(value = "size", required = false) Integer size) {
		return new ResponseEntity<List<User>>(userService.getUserDetails(page, size), HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<User> updateUsingPOST1(
			@ApiParam(value = "request", required = true) @Valid @RequestBody UpdateUserRequest request) {
		Long userId = userService.update(request);
		return new ResponseEntity<User>(userService.get(userId), HttpStatus.OK);
	}

}
