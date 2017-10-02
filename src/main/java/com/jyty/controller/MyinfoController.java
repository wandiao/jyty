package com.jyty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/myinfo")
public class MyinfoController {
	@RequestMapping(value="/detail")
	public ModelAndView detail_info() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("personinfo");
		return mv;
	}
}
