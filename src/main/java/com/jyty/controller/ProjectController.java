package com.jyty.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyty.entity.Project;
import com.jyty.entity.PageData;
import com.jyty.entity.ResponseData;
import com.jyty.service.ProjectService;
import com.jyty.util.ReqData;

/**
 * @author Administrator
 * 类名称：ArticleController
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600,methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.OPTIONS})
@Controller
@RequestMapping("/project")
public class ProjectController {
	private  Logger logger = Logger.getLogger(this.getClass());
	@Resource(name="projectService")
	ProjectService projectService;
	
	/**
	 * 查找文章详情
	 * @param aid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/projectDetail")
	@ResponseBody
	public ResponseData getArticleDetail(String id) throws Exception {
		ResponseData responseData = new ResponseData();
		if(id == null || "".equals(id)) {
			responseData.failure("项目id不能为空");	
		}else{
			int aid = Integer.parseInt(id);
			Project project = projectService.getProjectById(aid);
			responseData = responseData.success(project);
		}
		
		return responseData;
	}
	@RequestMapping(value="/list")
	public String listView() throws Exception {
		return "project_list";
	}
	
	@RequestMapping(value="/add")
	public String addView() throws Exception {
		return "project_add";
	}
	@RequestMapping(value="/add.do", method = RequestMethod.POST)
	public ModelAndView addProject(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		ReqData rData = new ReqData(request);
		Date date = new Date();
		rData.put("create_time", date);
		try {
			Object result = projectService.addNewProject(rData);
			mv.setViewName("project_list");
			logger.info("result:" + result);
		} catch (Exception e) {
			e.printStackTrace();
			mv.setViewName("project_add");
			// TODO: handle exception
		}
		return mv;
	}
}
