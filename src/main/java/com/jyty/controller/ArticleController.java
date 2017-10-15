package com.jyty.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jyty.entity.BaseType;
import com.jyty.service.ArticleService;
import com.jyty.service.ImageService;
import com.jyty.util.ReqData;

@Controller
@RequestMapping(value="/article")
public class ArticleController {
	@Resource(name="articleService")
	ArticleService articleService;
	@RequestMapping(value="/add")
	public ModelAndView addarticle(HttpServletRequest request) throws Exception {
		System.out.println(request.getSession().getServletContext().getRealPath("/"));
		ModelAndView mv = new ModelAndView();
		String error_msg = request.getParameter("error_msg");
		String msg = request.getParameter("msg");
		List<BaseType> types = articleService.getTypes();
		mv.setViewName("article_add");
		mv.addObject("error_msg", error_msg);
		mv.addObject("msg", msg);
		mv.addObject("types", types);
		return mv;
	}
	@RequestMapping(value="/add.do")
	public ModelAndView addAction(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("redirect:/article/add");
		ReqData rData = new ReqData(request);
		Date date = new Date();
		rData.put("create_time", date);
		String result;
		try {
			result = articleService.addNewArticle(rData).toString();
			if(Integer.parseInt(result) == 1) {
				mv.addObject("msg", "上传成功");
			} else {
				mv.addObject("err_msg", "上传失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mv.addObject("err_msg", "系统错误");
		}
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
