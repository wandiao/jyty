package com.jyty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/article")
public class ArticleController {
	@RequestMapping(value="/add")
	public ModelAndView addarticle() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("article_add");
		return mv;
	}
	@RequestMapping(value="/list")
	public ModelAndView lisetarticle()throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("article_list");
		return mv;
	}
	@RequestMapping(value="/type")
	public ModelAndView typearticle()throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("article_type");
		return mv;
	}
}
