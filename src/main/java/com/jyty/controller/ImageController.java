package com.jyty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/image")
public class ImageController {
	
	@RequestMapping(value="/add")
	public ModelAndView addImage() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("image_add");
		return mv;
	}
	@RequestMapping(value="/list")
	public ModelAndView Imagelist() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("image_list");
		return mv;
	}
	@RequestMapping(value="/type")
	public ModelAndView Imagetype() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("image_type");
		return mv;
	}
}
