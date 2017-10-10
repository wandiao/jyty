package com.jyty.controller.api;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jyty.entity.ResponseData;
import com.jyty.entity.User;
import com.jyty.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600,methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
@Controller
@RequestMapping("/api/user")
public class UserApiController {
	private  Logger logger = Logger.getLogger(this.getClass());
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping(value="/login")
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
				session.setAttribute("userid", u.getId());
				response = response.success(u);
				
			}else{
				response = response.failure("用户名或密码错误");
			}
		}else{
			response.failure("用户名不存在");
		};
		
		return response;
	}
	
	@RequestMapping(value="/profile")
	@ResponseBody
	public ResponseData getUserInfo(int id) throws Exception {
		ResponseData response = new ResponseData();
		User u = userService.getUserInfo(id);
		if(u != null) {
			response = response.success(u);
		}
		return response;
	};
}
