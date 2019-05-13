package com.me.controller;

import java.util.HashSet;
import java.util.Set;

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
//import com.me.pojo.Question;
import com.me.pojo.User;

@Controller
@RequestMapping("/*")
public class IndexController {

	@Autowired
	MessageDAO messageDao;

	@Autowired
	UserDAO userDao;
	
	@RequestMapping("/")
	public ModelAndView viewHome() {
		return new ModelAndView("login");
	}
	
	@RequestMapping("/backlogin")
	public ModelAndView backLogin(HttpSession session) {
		session.invalidate();
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/backhome")
	public ModelAndView backHome() {
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView createAdvert(HttpServletRequest request, HttpSession session)
			throws  UserException {
		String option = request.getParameter("option");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		ModelAndView mv = null;
		
		if (option.equals("Login") ) {
			User user = userDao.authenticateLogin(userName, password);
			//System.out.println(user.getId());
			if (user != null) {
				session.setAttribute("user", user);
				mv = new ModelAndView("home");
			} else {
				mv = new ModelAndView("loginError");
			}
		} 
		else if (option.equals("Register")) {
			User newuser = new User(userName, password);
			int i = userDao.register(newuser);
			if (i == 1) {
				mv = new ModelAndView("registerSuccess");
			}else {
				mv = new ModelAndView("registerError");
			}
			
		}
		
		return mv;
		
	}
}