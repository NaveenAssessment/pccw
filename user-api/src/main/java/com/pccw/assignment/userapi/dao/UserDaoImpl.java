
package com.pccw.assignment.userapi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pccw.assignment.userapi.entity.Users;

/**
 * @author naveen
 *
 */
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.openSession();
	}

	@Override
	public Long addUser(Users users) {
		getSession().save(users);
		return users.getId();
	}

	@Override
	public Users getUser(Long id) {
		return getSession().get(Users.class, id);
	}

	@Override
	public Long updateUser(Users users) {
		Session session = getSession();
		Criteria criteria = session.createCriteria(Users.class);
		criteria.add(Restrictions.eq("name", users.getName()));
		Users existingUser = (Users) criteria.uniqueResult();
		Long userId;
		if (existingUser != null) {
			existingUser.setPassword(users.getPassword());
			existingUser.setUsername(users.getUsername());
			existingUser.setEmail(users.getEmail());
			session.update(existingUser);
			userId = existingUser.getId();
		} else {
			session.save(users);
			userId = users.getId();	
		}
		session.flush();
		return userId;
	}

	@Override
	public boolean deleteUser(Long userId) {
		Session session = getSession();
		Users users = session.byId(Users.class).load(userId);
		session.delete(users);
		session.flush();
		return true;
	}

	@Override
	public List<Users> getUserDetails(Integer page, Integer size) {
		Criteria criteria = getSession().createCriteria(Users.class);
		if (size != null) {
			criteria.setFetchSize(size);
		}
		if (page != null) {
			criteria.setFirstResult(page);
		}
		List<Users> list = criteria.list();
		return list;
	}

}
