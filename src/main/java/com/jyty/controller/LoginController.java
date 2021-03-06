package com.jyty.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jyty.entity.ResponseData;
import com.jyty.entity.User;
import com.jyty.util.ReqData;
import com.jyty.service.UserService;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	private  Logger logger = Logger.getLogger(this.getClass());
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping(value="")
	public ModelAndView listView() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}			
}
