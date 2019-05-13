package com.me.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.exception.MessageException;
import com.me.exception.UserException;
//import com.neu.edu.exception.CategoryException;
import com.me.pojo.*;

public class MessageDAO extends DAO{

	public Message create(Message Message) {
		try {
			begin();
			getSession().save(Message);
			commit();
		
		} catch (HibernateException e) {
			rollback();
		}
		return Message;
	}
	
	public void delete(Message user) throws MessageException {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new MessageException("Problems occur. Could not delete the message." + user.getMessage(), e);
		}
	}
	
	public List<Message> list() throws MessageException {
		try {
			begin();
			Query q = getSession().createQuery("from message");
			List<Message> list = (List<Message>)q.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new MessageException("Problems occur. Could not list the messages.", e);
		}
	}
}
