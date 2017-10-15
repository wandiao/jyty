package com.jyty.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jyty.dao.DaoSupport;
import com.jyty.entity.BaseType;
import com.jyty.entity.Project;
import com.jyty.util.ReqData;

/**
 * 项目
 * @author Administrator
 *
 */
@Service("projectService")
@SuppressWarnings("unchecked")
public class ProjectService {
	@Resource(name = "daoSupport")
	private DaoSupport dao; 
	
	
	/**
	 * 项目详情
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Project getProjectById(int id) throws Exception {	
		return (Project) dao.findForObject("ProjectMapper.getProjectItem", id);
	}
	
	/**
	 * 新增项目
	 * @param rData
	 * @return
	 * @throws Exception
	 */
	public Object addNewProject(ReqData rData) throws Exception {
		return dao.save("ProjectMapper.addProject", rData);
	}
	
	/**
	 * 获取项目所有分类
	 * @return
	 * @throws Exception
	 */
	public List<BaseType> getTypes() throws Exception {
		return (List<BaseType>) dao.findForList("ProjectMapper.getTypes", null);
	}
	
	/**
	 * 获取项目列表
	 * @param rData
	 * @return
	 * @throws Exception
	 */
	public List<Object> getProjectList(ReqData rData) throws Exception {
		return (List<Object>) dao.findForList("ProjectMapper.getProjectList", rData);
	}
	
	/**
	 * 增加阅读数
	 * @return
	 * @throws Exception
	 */
	public Object addReadNum() throws Exception {
		return  dao.update("ProjectMapper.addReadNum", null);
	}
	
	public Object updateProject(ReqData rData) throws Exception {
		return dao.update("ProjectMapper.updateObject", rData);
	}
	
}
