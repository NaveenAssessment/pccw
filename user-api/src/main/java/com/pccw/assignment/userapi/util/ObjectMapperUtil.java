/**
 * 
 */
package com.pccw.assignment.userapi.util;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.pccw.assignment.userapi.entity.Users;
import com.pccw.assignment.userapi.model.CreateUserRequest;
import com.pccw.assignment.userapi.model.UpdateUserRequest;
import com.pccw.assignment.userapi.model.User;

/**
 * @author naveen
 * Model to entity and entity to model mapper util class
 *
 */
public class ObjectMapperUtil {

	@Autowired
	private static ModelMapper modelMapper = new ModelMapper();

	private ObjectMapperUtil() {

	}

	/**
	 * converts from CreateUserRequest model to Users entity object
	 * @param user
	 * @return
	 */
	public static Users convertToEntity(CreateUserRequest user) {
		Users users = modelMapper.map(user, Users.class);
		return users;
	}

	/**
	 * converts from UpdateUserRequest model to Users entity object
	 * @param user
	 * @return
	 */
	public static Users convertToEntity(UpdateUserRequest user) {
		Users users = modelMapper.map(user, Users.class);
		return users;
	}

	/**
	 * converts from User model to Users entity object
	 * @param user
	 * @return
	 */
	public static Users convertToEntity(User user) {
		Users users = modelMapper.map(user, Users.class);
		return users;
	}

	/**
	 * converts from Users entity to User model object
	 * @param users
	 * @return
	 */
	public static User convertToModel(Users users) {
		User user = modelMapper.map(users, User.class);
		return user;
	}

	/**
	 * <p>
	 * Note: outClass object must have default constructor with no arguments
	 * </p>
	 *
	 * @param entityList
	 *            list of entities that needs to be mapped
	 * @param outCLass
	 *            class of result list element
	 * @param <D>
	 *            type of objects in result list
	 * @param <T>
	 *            type of entity in <code>entityList</code>
	 * @return list of mapped object with <code><D></code> type.
	 */
	public static <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
		return entityList.stream().map(entity -> map(entity, outCLass)).collect(Collectors.toList());
	}

	/**
	 * <p>
	 * Note: outClass object must have default constructor with no arguments
	 * </p>
	 *
	 * @param <D>
	 *            type of result object.
	 * @param <T>
	 *            type of source object to map from.
	 * @param entity
	 *            entity that needs to be mapped.
	 * @param outClass
	 *            class of result object.
	 * @return new object of <code>outClass</code> type.
	 */
	public static <D, T> D map(final T entity, Class<D> outClass) {
		return modelMapper.map(entity, outClass);
	}

	/**
	 * Maps {@code source} to {@code destination}.
	 *
	 * @param source
	 *            object to map from
	 * @param destination
	 *            object to map to
	 */
	public static <S, D> D map(final S source, D destination) {
		modelMapper.map(source, destination);
		return destination;
	}

}
