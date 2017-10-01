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
import com.jyty.entity.BaseType;
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
	 * 项目列表页
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView listView(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		int pageNum=1;
		int pageSize=0;
		ReqData rData = new ReqData(request);
		if(rData.getString("pageNum")!=null &&! "".equals(rData.getString("pageNum"))){
			pageNum = Integer.parseInt(rData.getString("pageNum"));
		}
		if(rData.getString("pageSize")!=null &&! "".equals(rData.getString("pageSize"))){
			pageSize = Integer.parseInt(rData.getString("pageSize"));
		}
		 PageHelper.startPage(pageNum, pageSize);
		 List<Object> projects = projectService.getProjectList(rData);
		 mv.addObject("projects", projects);
		 logger.info(projects.size());
		 PageInfo<Object> page = new PageInfo<Object>(projects);
		 PageData pd = new PageData();
		 pd.setPageNum(page.getPageNum());
		 pd.setPageSize(page.getPageSize());
		 pd.setDataList(projects);
		 pd.setTotalCount(page.getTotal());
		 pd.setTotalPage(page.getPages());
		 mv.setViewName("project_list");
		 return mv;
	}
	
	/**
	 * 新增项目页
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/add")
	public ModelAndView addView(HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<BaseType> types = projectService.getTypes();
		mv.addObject("types", types);
		logger.info(types);
		String error_msg = request.getParameter("error_msg");
		String mString = request.getParameter("msg");
		mv.setViewName("project_add");
		mv.addObject("error_msg", error_msg);
		return mv;
	}
	@RequestMapping(value="/add.do")
	public ModelAndView addProject(HttpServletRequest request) {
		ModelAndView mv =  new ModelAndView("redirect:/project/add");
		
		ReqData rData = new ReqData(request);
		Date date = new Date();
		rData.put("create_time", date);
		try {
			String result = projectService.addNewProject(rData).toString();
			if (Integer.parseInt(result) == 1) {
				mv.addObject("msg", "新增成功");
			}
			logger.info("result:" + result);
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("error_msg", "新增失败");
			// TODO: handle exception
		}
		return mv;
	}

}
