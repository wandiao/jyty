package com.jyty.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jyty.entity.User;
import com.jyty.service.UserService;
import com.jyty.util.ReqData;


@Controller
@RequestMapping(value="/myinfo")
public class MyinfoController {
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping(value="/detail")
	public ModelAndView detail_info(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		int id = (Integer) session.getAttribute("userid");
		User u = userService.getUserInfo(id);
		mv.setViewName("personinfo");
		mv.addObject("user", u);
		return mv;
	}
	@RequestMapping(value="/revise")
	public ModelAndView revise_info(HttpSession session, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		int id = (Integer) session.getAttribute("userid");
		User u = userService.getUserInfo(id);
		String error_msg = request.getParameter("error_msg");
		String msg = request.getParameter("msg");
		mv.setViewName("inforevise");
		mv.addObject("user", u);
		mv.addObject("error_msg", error_msg);
		mv.addObject("msg", msg);
		return mv;
	}
	
	@RequestMapping(value="revise.do")
	public ModelAndView reviseInfo(HttpSession session, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/myinfo/revise");
		ReqData rData = new ReqData(request);
		int id = (Integer) session.getAttribute("userid");
		rData.put("id", id);
		String result = userService.updateUserInfo(rData).toString();
		if (Integer.parseInt(result) == 1) {
			mv.addObject("msg", "新增成功");
		}
		return mv;
		
	}
}
