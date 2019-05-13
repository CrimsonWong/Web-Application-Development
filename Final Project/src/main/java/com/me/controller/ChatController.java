package com.me.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.dao.MessageDAO;
import com.me.dao.UserDAO;
import com.me.exception.MessageException;
import com.me.exception.UserException;
import com.me.pojo.Message;
import com.me.pojo.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ChatController {
	
	@Autowired
	UserDAO userDao;
	
	@Autowired
	MessageDAO messageDao;
	
	@RequestMapping(value = "/viewAllMessages", method = RequestMethod.GET)
	public ModelAndView viewall()
			throws UserException, MessageException {
		ModelAndView mv = new ModelAndView();
		List<Message> messages = messageDao.list();
		
		mv.addObject("messages",messages);
		mv.setViewName("viewAllMessages");
		return mv;
	}
	
	@RequestMapping(value = "/viewMyMessages", method = RequestMethod.GET)
	public ModelAndView viewMyMessage(HttpSession session)
			throws UserException, MessageException {
		ModelAndView mv = new ModelAndView();
		User user = (User)session.getAttribute("user");
		int userId = user.getUid();
		User getuser = userDao.get(userId);
		System.out.println(getuser.getUid());
		System.out.println(getuser.getMessages());
		
		mv.addObject("user",getuser);
		mv.setViewName("viewMyMessages");
		return mv;
	}

	@RequestMapping(value = "/sendMessage")
	public ModelAndView send(@ModelAttribute("Message") Message message, HttpServletRequest request, 
			HttpSession session) throws MessageException {
		//String message = request.getParameter("message");
		User u = (User)session.getAttribute("user");
		
		try {
			
			int userId = u.getUid();
			User user = userDao.get(userId);
			message.setUser(user);
			
			messageDao.create(message);
			
			user.getMessages().add(message);
			userDao.update(user);
			
			session.setAttribute("user", user);


		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("home");
	}
	
	
	
}
