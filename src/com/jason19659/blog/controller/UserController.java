/**
 * 
 */
package com.jason19659.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jason19659.blog.service.UserService;

/**
 * @author <a href="mailto:jason19659@163.com">jason19659</a>
 *
 * com.jason19659.blog.controller.user
 *
 * 2014年3月17日
 */
@Controller
public class UserController {
	private UserService userService;
	
	@RequestMapping({"/index","/"})
	public String index() {
		return "/index";
	}
	

	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
}
