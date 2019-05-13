package com.me.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.exception.UserException;
import com.me.pojo.User;


public class UserDAO extends DAO {

	public UserDAO() {
	}

	public User get(int userId) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from user where id = :id");
			q.setInteger("id", userId);
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Problems occur. Could not get the user." + userId, e);
		}
	}
	
	public User authenticateLogin(String userName, String password) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from user where username = :username and password = :password");
			q.setString("username", userName);
			q.setString("password", password);
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Problems occur. Could not get the user." + userName, e);
		}
	}

	public int register(User u) throws UserException {
		try {
			int i;
			begin();
			String username = u.getUsername();
			System.out.println(username);
			Query q = getSession().createQuery("from user where username = :username");
			q.setString("username", username);
			User getuser = (User) q.uniqueResult();
			if (getuser == null) {
				getSession().save(u);
				i = 1;
			} else {
				i = 0;
			}
			commit();
			return i;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Problems occur. Could not create the user." + e.getMessage());
		}
	}
	
	public void update(User u) throws UserException {
		try {
			begin();
			getSession().update(u);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Problems occur. Could not update the user.", e);
		}
	}

	public void delete(User user) throws UserException {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Problems occur. Could not delete the user." + user.getUsername(), e);
		}
	}
}