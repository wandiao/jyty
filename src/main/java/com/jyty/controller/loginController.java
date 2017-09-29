package com.jyty.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jyty.entity.ResponseData;
import com.jyty.entity.User;
import com.jyty.util.ReqData;
import com.jyty.service.UserService;

@Controller
public class loginController {
	private  Logger logger = Logger.getLogger(this.getClass());
	@Resource(name="userService")
	private UserService userService;
	@RequestMapping(value="/login")
	public String listView() throws Exception {
		return "login";
	}
	
	@RequestMapping(value="/toLogin")
	@ResponseBody
	public ResponseData toLogin(HttpSession session, HttpServletRequest request) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ResponseData response = new ResponseData();
		if(username == null  || "".equals(username) || password == null || "".equals(password)){
			response = response.failure("用户名密码不能为空");
			return response;
		}
		int count = userService.userIsExist(username);
		logger.info("数量为"+count);
		if(count > 0) {
			User u = userService.getUserByNameAndPwd(username, password);
			if(u!=null) {
				session.setAttribute("username", username);
				response = response.success(u);
				
			}else{
				response = response.failure("用户名或密码错误");
			}
		}else{
			response.failure("用户名不存在");
		};
		
		return response;
	}
	
	
	
}
